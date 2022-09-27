public class Portfolio {
    public static void main(String[] args) {
        Tankers tankersVessel = new Tankers("Norge", 25, 100, 40, 10);
        Container containerVessel = new Container("Somalia", 1, 5, 2, 25);
        RoRo roRoVessel = new RoRo("Finland", 50, 150, 60, 150);

        tankersVessel.loadingCargo(10);
        tankersVessel.utilitylevelofCapacity();
        containerVessel.loadingCargo(26);
        containerVessel.utilitylevelofCapacity();
        roRoVessel.loadingCargo(7, 1);
        roRoVessel.utilitylevelofCapacity();

    }

}

abstract class Vessel {
    String flagNation;
    int draft;
    int length;
    int width;
    double cargo;

    public Vessel(String flagNation, int draft, int length, int width, int cargo) {
        this.flagNation = flagNation;
        this.draft = draft;
        this.length = length;
        this.width = width;
        this.cargo = cargo;

    }

    abstract boolean checkCargo();

    abstract double utilitylevelofCapacity();

    abstract boolean checkFraction();

    abstract boolean belowBoundary();

}

// <----- Containers ----->

class Container extends Vessel {
    double containerAmount;
    double fraction;

    public boolean checkCargo() { // Hvis antallet af containers er større end max, returner true
        return containerAmount > cargo;
    }

    public double utilitylevelofCapacity() {
        this.fraction = (this.containerAmount / cargo) * 100.0;
        return fraction;
    }

    public boolean checkFraction() {
        return utilitylevelofCapacity() < 100.0;
    }

    public boolean belowBoundary() {
        return utilitylevelofCapacity() < 0;
    }

    public Container(String flagNation, int draft, int length, int width, int cargo) {
        super(flagNation, draft, length, width, cargo);

    }

    public void loadingCargo(int containers) {
        this.containerAmount = containers;
    }

}

// <----- Tankers ----->

class Tankers extends Vessel {
    double compartmentsAmount;
    double fraction;

    public boolean checkCargo() {
        return compartmentsAmount > cargo;
    }

    public boolean checkFraction() {
        return utilitylevelofCapacity() < 100.0;
    }

    public boolean belowBoundary() {
        return utilitylevelofCapacity() < 0;
    }

    public Tankers(String flagNation, int draft, int length, int width, int cargo) {
        super(flagNation, draft, length, width, cargo);

    }

    public void loadingCargo(int compartments) {
        compartmentsAmount = compartments;
    }

    public double utilitylevelofCapacity() {
        this.fraction = (this.compartmentsAmount / cargo) * 100.0;
        return fraction;
    }

}

// <----- RoRo ----->

class RoRo extends Vessel {
    double carLength;
    double truckLength;
    double fraction;

    public boolean checkCargo() {
        return carLength + truckLength > cargo;
    }

    public boolean checkFraction() {
        return utilitylevelofCapacity() < 100.0;
    }

    public boolean belowBoundary() {
        return utilitylevelofCapacity() < 0;
    }

    public RoRo(String flagNation, int draft, int length, int width, int cargo) {
        super(flagNation, draft, length, width, cargo);

    }

    public void loadingCargo(int vehicles, int trucks) {
        this.carLength = vehicles * 8;
        this.truckLength = trucks * 30;
    }

    public double utilitylevelofCapacity() {
        this.fraction = ((this.carLength + this.truckLength) / cargo) * 100.0;
        return fraction;
    }
}

// <----- Dummy classes ----->
class shippingDepartment {
    double vesselPosX;
    double vesselPosY;
    String futurePort;

    public void currentVesselPos (double longitude, double latitude) {
        this.vesselPosX = longitude;
        this.vesselPosY = latitude;
    }

    public void futureDestination (String port) {
        this.futurePort = port;
    }

}


