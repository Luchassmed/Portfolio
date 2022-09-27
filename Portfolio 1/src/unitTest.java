import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class unitTest {

    @Test
    void containerCheckCargo() {
        Container containerVessel = new Container("Somalia", 1, 5, 2, 25);
        containerVessel.loadingCargo(24);
        assertEquals(containerVessel.checkCargo(), false);
    }

   @Test
   void containerCheckFraction(){
        Container containerVessel = new Container("Somalia", 1, 5, 2, 25);
        containerVessel.loadingCargo(9);
        assertEquals(containerVessel.checkFraction(), true);
   }

   @Test
   void containerBelowBoundary(){
        Container containerVessel = new Container("Somalia", 1, 5, 2, 25);
        containerVessel.loadingCargo(-10);
        assertEquals(containerVessel.belowBoundary(), true);
   }

    @Test
    void tankersTest() {
        Tankers tankersVessel = new Tankers("Norge", 25, 100, 40, 10);
        tankersVessel.loadingCargo(5);
        assertEquals(tankersVessel.checkCargo(), false);
    }

    @Test
    void tankersCheckFraction() {
        Tankers tankersVessel = new Tankers("Norge", 25, 100, 40, 10);
        tankersVessel.loadingCargo(7);
        assertEquals(tankersVessel.checkFraction(), true);
    }

    @Test
   void tankersBelowBoundary(){
        Tankers tankersVessel = new Tankers("Finland", 25, 100, 40, 10);
        tankersVessel.loadingCargo(10);
        assertEquals(tankersVessel.belowBoundary(), false);
   }

    @Test
    void roRoTest() {
        RoRo roRoVessel = new RoRo("Finland", 50, 150, 60, 150);
        roRoVessel.loadingCargo(7, 1);
        assertEquals(roRoVessel.checkCargo(), false);
    }

    @Test
    void roRoCheckFraction() {
        RoRo roRoVessel = new RoRo("Finland", 50, 150, 60, 150);
        roRoVessel.loadingCargo(7, 1);
        assertEquals(roRoVessel.checkFraction(), true);
    }

    @Test
    void roRoBelowBoundary() {
        RoRo roRoVessel = new RoRo("Finland", 50, 150, 60, 150);
        roRoVessel.loadingCargo(7, 1);
        assertEquals(roRoVessel.belowBoundary(), false);
    }

    @Test 
    void testVesselPosNull() { // Unit test that checks if the vessel has a position.
        
        assertEquals(shippingDepartment.testVesselPosNull(), false);
    }

    @Test
     void testVesselPosBelow () { // Unit test that checks if the vessel has a position below zero.
    }
}
