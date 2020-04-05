package hw2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestPercolation {
    @Test
     public void testBasics() {
        Percolation p1 = new Percolation(4);
        p1.open(0,3);
        p1.isFull(0,1);
        p1.isFull(0,2);
        p1.open(1,3);
        p1.isFull(1,3);
        p1.open(2,2);
        p1.open(2,3);
        p1.open(3,3);
        p1.percolates();
    }
}
