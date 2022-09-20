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
}

class Container extends Vessel {
    double containerAmount;

    public boolean checkCargo() { // Hvis antallet af containers er større end max, returner true
        return containerAmount > cargo;
    }

    public Container(String flagNation, String vesselType, int draft, int length, int width, int cargo) {
        super(flagNation, vesselType, draft, length, width, cargo);

    }

    public void loadingCargo(int containers) {
        this.containerAmount = containers;
    }

    public void utilitylevelofCapacity() {
        System.out.println("The container vessel is filled with " + (this.containerAmount / cargo) * 100 + "%");
        System.out.println();
    }

}

class Tankers extends Vessel {
    double compartmentsAmount;

    public boolean checkCargo() {
        return compartmentsAmount > cargo;
    }

    public Tankers(String flagNation, String vesselType, int draft, int length, int width, int cargo) {
        super(flagNation, vesselType, draft, length, width, cargo);

    }

    public void loadingCargo(int compartments) {

        compartmentsAmount = compartments;
        if(compartmentsAmount < cargo){
            System.out.println("Not enough cargospace!");
        }
        if(compartmentsAmount > cargo){
            System.out.println("Enough cargospace!");
        }
        
    }

    public void utilitylevelofCapacity() {
        System.out.println();
        System.out.println("The Tankers vessel is filled with " + (this.compartmentsAmount / cargo) * 100 + "%");
        System.out.println();
    }

}

class RoRo extends Vessel {
    double carLength;
    double truckLength;

    public boolean checkCargo() {
        return carLength + truckLength > cargo;
    }

    public RoRo(String flagNation, String vesselType, int draft, int length, int width, int cargo) {
        super(flagNation, vesselType, draft, length, width, cargo);

    }

    public void loadingCargo(int vehicles, int trucks) {
        this.carLength = vehicles * 8;
        this.truckLength = trucks * 30;

        System.out.println("Carlength on ship: " + this.carLength + ". Trucklength on ship: "
                + this.truckLength
                + ". Total amout of cargo length: " + (this.carLength + this.truckLength) + ".");
    }

    public void utilitylevelofCapacity() {
        System.out.println("Total ship length: " + cargo + ". Fraction of cargo space left: "
                + (this.carLength + this.truckLength / cargo) + "%");
        System.out.println();
    }
}
