
public class ArrayDeque<T> {
    /*
  @author: Samuel Sorial
  An Array implementation of a deque using double linked lists.
  */
    private T[] items;
    private int nextFirst;
    private int nextLast;
    private int size;
    private double minimumFactor;

    public ArrayDeque(){
        items = (T[]) new Object[8];
        nextFirst = 0;
        nextLast = 1;
        minimumFactor = .25;
        size = 0;
    }
    /*
    Deep copy of the deque
    @param: deque that needs to be copied.
     */
    public ArrayDeque(ArrayDeque original){
        this();
        resize(original.items.length);
        int start = increaseOne(original.nextFirst);
        for (int index = start; index != original.nextLast; index = increaseOne(index)){
            this.items[index] = (T) original.items[index];
        }
        this.nextLast = original.nextLast;
        this.nextFirst = original.nextFirst;
        this.size = original.size;
    }

    private boolean isFull(){
        if(size == items.length)
            return true;
        else
            return false;
    }

    private void resize(int newSize){
        T[] newItems = (T[]) new Object[newSize];
        int start = increaseOne(nextFirst);
        for(int i=0, index = start; index != nextLast; index= increaseOne(index), i++){
            newItems[i] = items[index];
        }
        items = newItems;
        nextFirst = newSize - 1;
        nextLast = size;
    }

    private int decreaseOne(int index){
        if(index == 0)
            return items.length-1;
        else
            return index-1;
    }

    private int increaseOne(int index){
        if(index== items.length -1)
            return 0;
        else
            return index+1;
    }
    /*
    Add an item to the first of the deque.
    @param: item to be placed in the front.
     */
    public void addFirst(T item) {
        if (isFull())
            resize(items.length*2);
        items[nextFirst] = item;
        nextFirst = decreaseOne(nextFirst);
        size++;
    }
    /*
    Add an item to the back of the deque.
    @param: item to be placed at the back.
     */
    public void addLast(T item){
        if(isFull())
            resize(items.length*2);
        items[nextLast] = item;
        nextLast = increaseOne(nextLast);
        size++;
    }
    /*
    @return: if the deque is empty or not.
     */
    public boolean isEmpty(){
        if(size == 0 )
            return true;
        else
            return false;
    }
    /*
    @return: the size of the deque.
     */
    public int size(){
        return size;
    }
    /*
    Prints the deque in the order.
     */
    public void printDeque(){
        int index = increaseOne(nextFirst);
        while(index != nextLast){
            System.out.println(items[index].toString());
            index = increaseOne(index);
        }
    }
    /*
    @return: the first element of the deque and remove it.
     */
    public T removeFirst(){
        if(size == 0)
            return null;

        int currIndex = increaseOne(nextFirst);
        T item = items[currIndex];
        items[currIndex] = null;
        nextFirst = currIndex;
        size--;
        if(items.length>= 16 && size<items.length * minimumFactor)
            resize(items.length/2);
        return item;
    }
    /*
    @return: the last item of the deque and remove it.
     */
    public T removeLast(){
        if(size == 0)
            return null;
        int currLast = decreaseOne(nextLast);
        T item = items[currLast];
        items[currLast] = null;
        nextLast = decreaseOne(nextLast);
        size--;
        if(items.length>=16 && size<items.length* minimumFactor)
            resize(items.length/2);
        return item;
    }
    /*
    @param: the index of the required item in the deque.
    @return: item at the specific index
     */
    public T get(int index){
        if(index>items.length)
            return null;
        index = (increaseOne(nextFirst) + index ) % items.length;
        return items[index];
    }

}
