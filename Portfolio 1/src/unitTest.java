import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

//Dette er klassen vi bruger til unit test, af loadingCargo metoderne.
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
        containerVessel.loadingCargo(24);
        assertEquals(containerVessel.checkFraction(), true);
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
}
