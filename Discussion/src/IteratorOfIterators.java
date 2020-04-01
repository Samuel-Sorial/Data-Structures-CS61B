import java.util.Iterator;
import java.util.*;

public class IteratorOfIterators implements Iterator<Integer>{
    List<Integer> list;

    public IteratorOfIterators(List<Iterator<Integer>> a){
        list = new LinkedList<>();
        int i = 0;
        while(!a.isEmpty()){
            Iterator<Integer> currentIterator = a.get(i);
            if(!currentIterator.hasNext()){
                a.remove(i);
                i-=1;
            }
            else{
                list.add(currentIterator.next());
            }
            if(a.isEmpty())
                break;
            i = (i+1) % a.size();
        }

    }
    @Override
    public boolean hasNext() {
        return !list.isEmpty();
    }

    @Override
    public Integer next() {
        return list.remove(0);
    }
}