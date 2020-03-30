import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class testSList {
    @Test
    public void test(){
        SList a = new SList();
        a.insertFront(1);
        SList b = new SList();
        b.insertFront(2);
        assertEquals(1,a.getFront());
        assertEquals(2,b.getFront());
        assertEquals(a.getFront(),b.getFront());
    }
}
