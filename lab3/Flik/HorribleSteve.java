import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class HorribleSteve {
    @Test
    public void testFlik() {
        int i = 0;
        for (int j  = 0; i  < 500; ++i, ++j) {
            assertTrue("They are not equal", Flik.isSameNumber(i, j));
        }
    }
}
