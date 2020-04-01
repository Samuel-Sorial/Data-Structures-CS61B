import java.util.Iterator;
import java.util.NoSuchElementException;

/** @author: Samuel-Sorial.
 *  Iterates over every Kth element of the IntList given the constructor
 * for example, if L intlist contains 0,1,2,3,4,5,6,7 and K = 2
 * for(Iterator<Integer> p = new KnthIntList(L,2); p.hasNext();){
 *     System.out.println(p);
 * }
 * prints: 0,2,4,6.
 */
public class KthIntList implements Iterator<Integer> {

    public int k;
    private IntList curList;
    private boolean hasNext;

    public KthIntList(IntList I, int k){
        this.k = k;
        this.curList = I;
        this.hasNext = true;
    }

    @Override
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override
    public Integer next() {
        if(hasNext) {
            Integer result = curList.first;
            for (int i = 0; i < k; i++){
                if (curList.rest == null){
                    hasNext = false;
                }
                curList = curList.rest;
            }
            return result;
        }
        else{
            throw new NoSuchElementException();
        }
    }
}
