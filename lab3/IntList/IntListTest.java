import static org.junit.Assert.*;

import org.junit.Test;

public class IntListTest {

    /**
     * Example test that verifies correctness of the IntList.of static
     * method. The main point of this is to convince you that
     * assertEquals knows how to handle IntLists just fine.
     */

    @Test
    public void testList() {
        IntList one = new IntList(1, null);
        IntList twoOne = new IntList(2, one);
        IntList threeTwoOne = new IntList(3, twoOne);

        IntList x = IntList.of(3, 2, 1);
        assertEquals(threeTwoOne, x);
    }

    @Test
    public void testdSquareList() {
        IntList L = IntList.of(1, 2, 3);
        IntList.dSquareList(L);
        assertEquals(IntList.of(1, 4, 9), L);
    }

    /**
     * Do not use the new keyword in your tests. You can create
     * lists using the handy IntList.of method.
     * <p>
     * Make sure to include test cases involving lists of various sizes
     * on both sides of the operation. That includes the empty list, which
     * can be instantiated, for example, with
     * IntList empty = IntList.of().
     * <p>
     * Keep in mind that dcatenate(A, B) is NOT required to leave A untouched.
     * Anything can happen to A.
     */

    @Test
    public void testSquareListRecursive() {
        IntList L = IntList.of(1, 2, 3);
        IntList res = IntList.squareListRecursive(L);
        assertEquals(IntList.of(1, 2, 3), L);
        assertEquals(IntList.of(1, 4, 9), res);
    }

    @Test
    public void testDcatenate() {
        IntList A = IntList.of(1, 2, 3);
        IntList B = IntList.of(4, 5, 6);
        IntList exp = IntList.of(1, 2, 3, 4, 5, 6);
        assertEquals(exp, IntList.dcatenate(A, B));
        assertEquals(IntList.of(1, 2, 3, 4, 5, 6), A);
    }

    @Test
    public void testCatenate() {
        IntList A = IntList.of(1, 2, 3);
        IntList B = IntList.of(4, 5, 6);
        IntList exp = IntList.of(1, 2, 3, 4, 5, 6);
        assertEquals(exp, IntList.catenate(A, B));
        assertEquals(IntList.of(1, 2, 3), A);
    }

    @Test
    public void testReverse(){
        // Test that the returned list is reversed
        // Test that the method is destructive which means it changed the passed list
        // Test that it handles nulls.

        IntList A = IntList.of(1,2,3,4);
        IntList B = IntList.of(4,3,2,1);
        IntList C = IntList.of(1,2,3,4);

        assertEquals("Not reversing the elements",B, IntList.reverse(A));
        assertNotEquals("Not destruct the passed list",C,A);
        assertNull("Not handling nulls",IntList.reverse(null));
    }

    @Test
    public void testSkippify(){
        // Test that it skippes the numbers correctly.
        IntList A = IntList.of(1,2,3,4,5,6,7,8,9,10);
        IntList expectedA = IntList.of(1,3,6,10);
        IntList B = IntList.of(9,8,7,6,5,4,3,2,1);
        IntList expectedB = IntList.of(9,7,4);
        A.skippify();
        B.skippify();
        assertEquals(expectedA, A);
        assertEquals(expectedB, B);
    }

}
