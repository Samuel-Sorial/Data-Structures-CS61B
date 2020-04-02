package es.datastructur.synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer arb = new ArrayRingBuffer(10);
        for(int i = 1; i <= 10; i++)
            arb.enqueue(i);

        assertEquals(10,arb.capacity());
        assertEquals(10,arb.fillCount());
        assertFalse(arb.isEmpty());
        assertEquals(1,arb.peek());
        assertEquals(1,arb.dequeue());
        assertEquals(2,arb.peek());
    }
}
