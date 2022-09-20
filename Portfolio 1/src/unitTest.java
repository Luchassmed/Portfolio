import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

// import org.junit.Before;
// import org.junit.jupiter.api.BeforeEach;

//Dette er klassen vi bruger til unit test, af loadingCargo metoderne.
public class unitTest {


  

    @Test
    void containerTest(){
        Container containerVessel = new Container("Somalia", "Container", 1, 5, 2, 25);
        //containerVessel.loadingCargo(36);
        assertEquals(containerVessel.loadingCargo(36), 1); //Hvis antallet af containers er mindre end max, så er værdien false. Hvis den er false, så er der ikke for mange containers
    }

    @Test
    void tankersTest(){
        Tankers tankersVessel = new Tankers("Norge", "Tanker", 25, 100, 40, 10);
        tankersVessel.loadingCargo(5);
        assertEquals(tankersVessel.checkCargo(), false);
    }

    @Test
    void roRoTest(){
        RoRo roRoVessel = new RoRo("Finland", "RoRo", 50, 150, 60, 150);
        roRoVessel.loadingCargo(7, 1);
        assertEquals(roRoVessel.checkCargo(), false);
    }
}
