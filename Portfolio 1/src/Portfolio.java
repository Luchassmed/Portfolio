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

    public void currentVesselPos() { // Calculates the position of vessels in the sea.
    }

    public static void testVesselPosNull () { // Unit test that checks if the vessel has a position.
    }

    public void testVesselPosBelow () { // Unit test that checks if the vessel has a position below zero.
    }

    public void futureDestination() { // Tells the shipping department the future destination of the vessels.
    }

    public void testDesination () { // Unit test that checks if the vessel has arrived at the planned location.

    }

}

class freightDepartment {

    public void searchNearestShip() {
        // Locate the nearest ship.
    }

    public void testCatchShip() { // Unit test that checks if the vessel it finds, is the closest vessel.
    }

    public void changeDestination() {
        // Changes destination of ship.
    }

    public void testChange () { // Unit test that checks if the vessels destination has been changed.
    }


}
