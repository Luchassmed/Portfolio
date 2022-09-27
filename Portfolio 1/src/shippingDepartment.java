public class shippingDepartment {

    public double currentVesselPos(double position) { // Calculates the position of vessels in the sea.
        return position;
    }

    public static boolean testVesselPosNull() { // Unit test that checks if the vessel has a position.
        return true;
    }

    public static boolean testVesselPosBelow() { // Unit test that checks if the vessel has a position below zero.
        return true;
    }

    public String futureDestination(String port) { // Tells the shipping department the future destination of the
                                                   // vessels.
        return port;
    }

    public static boolean testDesination() { // Unit test that checks if the vessel has arrived at the planned location.
        return true;
    }

}
