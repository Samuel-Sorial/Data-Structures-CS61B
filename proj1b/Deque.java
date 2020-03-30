public interface Deque<T> {

     void addFirst(T Item);

     void addLast(T item);

     default boolean isEmpty(){
         if(size()==0)
             return true;
         else
             return false;
     }

     int size();

     void printDeque();

     T removeFirst();

     T removeLast();

     T get(int index);
}
