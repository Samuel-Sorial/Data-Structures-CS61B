import edu.princeton.cs.algs4.Queue;

import org.junit.Assert;
import org.junit.Test;

public class TestSortAlgs {

    @Test
    public void testQuickSort() {
        Queue<Integer> q = new Queue<>();
        q.enqueue(4);
        q.enqueue(20);
        q.enqueue(1);
        q.enqueue(0);
        q.enqueue(20);
        q.enqueue(31);
        q.enqueue(166);
        q.enqueue(25);
        QuickSort.quickSort(q);
        Assert.assertTrue(isSorted(q));
    }

    @Test
    public void testMergeSort() {
        Queue<Integer> q = new Queue<>();
        q.enqueue(4);
        q.enqueue(20);
        q.enqueue(1);
        q.enqueue(0);
        q.enqueue(20);
        q.enqueue(31);
        q.enqueue(166);
        q.enqueue(25);
        Assert.assertTrue(isSorted(MergeSort.mergeSort(q)));
    }

    /**
     * Returns whether a Queue is sorted or not.
     *
     * @param items  A Queue of items
     * @return       true/false - whether "items" is sorted
     */
    private <Item extends Comparable> boolean isSorted(Queue<Item> items) {
        if (items.size() <= 1) {
            return true;
        }
        Item curr = items.dequeue();
        Item prev = curr;
        while (!items.isEmpty()) {
            prev = curr;
            curr = items.dequeue();
            if (curr.compareTo(prev) < 0) {
                return false;
            }
        }
        return true;
    }
}
