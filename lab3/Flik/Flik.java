/** An Integer tester created by Flik Enterprises. */
public class Flik {
    /*
    The bug is that Integer a and b is not primitive, they are objects and have the same address until 127,
    at 128 they got different addresses and that's why it breaks at the 128,
    here's the correct method that passes the tests.
     */
    public static boolean isSameNumber(Integer a, Integer b) {
        return a.intValue() == b.intValue();
    }
}
