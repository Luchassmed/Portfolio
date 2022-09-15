import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;

public class unitTest {

    
  

    @Test
    void myTest(){
        Container containerVessel = new Container("Somalia", "Container", 1, 5, 2, 25);
        containerVessel.loadingCargo(24);
        assertEquals(containerVessel.checkCargo(), false);
    }
}
