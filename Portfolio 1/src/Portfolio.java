public class Portfolio {
    public static void main(String[] args) {
        Tankers tankersVessel = new Tankers("Norge", "Tanker", 25, 100, 40, 10);
        Container containerVessel = new Container("Somalia", "Container", 1, 5, 2, 25);
        RoRo roRoVessel = new RoRo("Finland", "RoRo", 50, 150, 60, 150);

        tankersVessel.loadingCargo(15);
        tankersVessel.utilitylevelofCapacity();
        containerVessel.loadingCargo(3);
        containerVessel.utilitylevelofCapacity();
        roRoVessel.loadingCargo(7, 1);
        roRoVessel.utilitylevelofCapacity();

    }

}

abstract class Vessel {
    String flagNation;
    String vesselType;
    int draft;
    int length;
    int width;
    double cargo;

    public Vessel(String flagNation, String vesselType, int draft, int length, int width, int cargo) {
        this.flagNation = flagNation;
        this.vesselType = vesselType;
        this.draft = draft;
        this.length = length;
        this.width = width;
        this.cargo = cargo;

    }

    // abstract void loadingCargo(int cargo, int vehicles ); // Ved at lave denne
    // abstract metode sikrer vi, at alle subclasses
    // af Vessel
    // Har udkommenteret loading cargo, som abstract metode. Subclass kan ikke arve
    // abstract metode fra superclass, hvis der er forskellige parametre
    // anvender denne

    abstract void utilitylevelofCapacity();

    abstract boolean checkCargo();

    abstract boolean checkFraction();

}

// <----- Containers ----->

class Container extends Vessel {
    double containerAmount;
    double fraction;

    public boolean checkCargo() { // Hvis antallet af containers er større end max, returner true
        return containerAmount > cargo;
    }

    public boolean checkFraction() {
        return fraction < 100.0;
    }

    public Container(String flagNation, String vesselType, int draft, int length, int width, int cargo) {
        super(flagNation, vesselType, draft, length, width, cargo);

    }

    public void loadingCargo(int containers) {
        this.containerAmount = containers;
    }

    public void utilitylevelofCapacity() {
        this.fraction = (this.containerAmount / cargo) * 100;
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
        return fraction < 100.0;
    }

    public Tankers(String flagNation, String vesselType, int draft, int length, int width, int cargo) {
        super(flagNation, vesselType, draft, length, width, cargo);

    }

    public void loadingCargo(int compartments) {
        compartmentsAmount = compartments;
    }

    public void utilitylevelofCapacity() {
        this.fraction = (this.compartmentsAmount / cargo) * 100;
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
        return fraction < 100.0;
    }

    public RoRo(String flagNation, String vesselType, int draft, int length, int width, int cargo) {
        super(flagNation, vesselType, draft, length, width, cargo);

    }

    public void loadingCargo(int vehicles, int trucks) {
        this.carLength = vehicles * 8;
        this.truckLength = trucks * 30;
    }

    public void utilitylevelofCapacity() {
        this.fraction = ((this.carLength + this.truckLength) / cargo) * 100;
    }
}
