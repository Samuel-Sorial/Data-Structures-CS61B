import org.junit.Test;

import static org.junit.Assert.*;

public class TestUnioinFind {
    @Test
    public void testBasicCreation(){
        TwoArrays un1 = new TwoArrays(15);
        assertFalse(un1.connected(1,2));
        un1.union(1,3);
        un1.union(3,4);
        un1.union(4,2);
        un1.union(6,7);
        un1.union(9,6);
        un1.union(9,1);
    }
}
