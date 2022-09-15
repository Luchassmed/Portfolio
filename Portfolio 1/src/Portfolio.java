public class Portfolio {
    public static void main(String[] args) {
        Tankers tankersVessel = new Tankers("Norge", "Tanker", 25, 100, 40, 10);
        Container containerVessel = new Container("Somalia", "Container", 1, 5, 2, 25);
        RoRo roRoVessel = new RoRo("Finland", "RoRo", 50, 150, 60, 150);

        tankersVessel.loadingCargo(5);
        tankersVessel.utilitylevelofCapacity();
        containerVessel.loadingCargo(23);
        containerVessel.utilitylevelofCapacity();
        roRoVessel.loadingCargo(8);
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

    abstract void loadingCargo(int cargo); // Ved at lave denne abstract metode sikrer vi, at alle subclasses af Vessel
                                           // anvender denne

    abstract void utilitylevelofCapacity();

}

class Container extends Vessel {
    double containerAmount;

    public Container(String flagNation, String vesselType, int draft, int length, int width, int cargo) {
        super(flagNation, vesselType, draft, length, width, cargo);

    }

    public void loadingCargo(int containers) {
        if (containers > this.cargo) {
            System.out.println("The maximum amount of countainers is " + this.cargo
                    + "Vessel is therefore only loaded with this amount of containers" + this.cargo);
            containerAmount = this.cargo;
        } else if (containers <= 0) {
            System.out.println("Cannot load " + containers + "Please load an approiate load");
        } else {
            this.containerAmount = containers;
        }

    }

    public void utilitylevelofCapacity() {
        System.out.println("The container vessel is filled with " + (this.containerAmount / cargo) * 100 + "%");
        System.out.println();
    }

}

class Tankers extends Vessel {
    double compartmentsAmount;

    public Tankers(String flagNation, String vesselType, int draft, int length, int width, int cargo) {
        super(flagNation, vesselType, draft, length, width, cargo);

    }

    public void loadingCargo(int compartments) {
        if (compartments > this.cargo) {
            System.out.println("The maximum amount of compartments is " + this.cargo
                    + "Vessel is therefore only loaded with this amount of compartments" + this.cargo);
            compartmentsAmount = this.cargo;
        } else if (compartments <= 0) {
            System.out.println("Cannot load " + compartmentsAmount + "Please load an approiate amount");
        } else {
            this.compartmentsAmount = compartments;
        }
    }

    public void utilitylevelofCapacity() {
        System.out.println();
        System.out.println("The Tankers vessel is filled with " + (this.compartmentsAmount / cargo) * 100 + "%");
        System.out.println();
    }

}

class RoRo extends Vessel {
    double carLength = 8;
    double truckLength = 30;

    public RoRo(String flagNation, String vesselType, int draft, int length, int width, int cargo) {
        super(flagNation, vesselType, draft, length, width, cargo);

    }

    public void loadingCargo(int vehicles) {
        this.carLength = vehicles;
        System.out.println("Carlength on ship: " + (carLength * 3) + ". Trucklength on ship: " + truckLength * 3
                + ". Total amout of cargo length: " + (carLength * 3 + truckLength * 3 + "."));
    }

    public void utilitylevelofCapacity() {
        System.out.println("Total ship length: " + length + ". Fraction of cargo space left: "
                + (carLength * 3 + truckLength * 3 / length) + "%");
                System.out.println();
    }
}
