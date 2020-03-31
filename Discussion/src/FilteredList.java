import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class FilteredList<T> implements Iterable<T> {
    List<T> list;
    int currIndex;
    Predicate<T> currFilter;
    public FilteredList(List<T> L, Predicate<T> filter) {
        list = L;
        currFilter = filter;
        currIndex=0;
    }

    @Override
    public Iterator<T> iterator() {
        FilteredIterator<T> iterator = new FilteredIterator<>();
        return iterator;
    }

    private class FilteredIterator<T> implements Iterator<T>{

        @Override
        public boolean hasNext() {
            while (list.get(currIndex) != null) {
                if (currFilter.test(list.get(currIndex)))
                    return true;
                else
                    currIndex++;
            }
            return false;
        }
        @Override
        public T next() {
            if(hasNext()) {
                T element = (T) list.get(currIndex);
                currIndex++;
                return element;
            }
            else
                throw new NoSuchElementException();
        }
    }
}
