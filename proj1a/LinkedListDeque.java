public class LinkedListDeque<T> {
    /*
     @author: Samuel Sorial
     A Linked List implementation of a deque using double linked lists.
     */
    private TNode sentinel;
    private int size;

    public class TNode{
        public TNode prev;
        public T item;
        public TNode next;

        public TNode(TNode prev, T item, TNode next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }

    public LinkedListDeque(){
        sentinel = new TNode(null,null,null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size=0;
    }

    public LinkedListDeque(LinkedListDeque original){
        this();
        if(original.isEmpty())
            return;
        TNode temp = original.sentinel.next;
        while(temp != original.sentinel){
            this.addLast(temp.item);
            temp = temp.next;
        }
    }
    /*
    @param item which is a T type
    Adds the given item to the beginning of the deque
     */
    public void addFirst(T item){
        TNode added = new TNode(sentinel ,item, sentinel.next);
        sentinel.next.prev = added;
        sentinel.next = added;
        size++;
    }

    /*
    @param item which is a T type
    Adds a given item to the end of the deque
     */
    public void addLast(T item){
        TNode added = new TNode(sentinel.prev,item,sentinel);
        sentinel.prev.next = added;
        sentinel.prev = added;
        size++;
    }
    /*
    @return true if the deque is empty
     */
    public boolean isEmpty(){
        if(size == 0)
            return true;
        else
            return false;
    }

    public int size(){
        return size;
    }
    /*
    Print each element at the deque in the order they were inserted on.
     */
    public void printDeque(){
        TNode temp = sentinel.next;
        while(temp != sentinel) {
            System.out.println(temp.item.toString());
            temp = temp.next;
        }
    }
    /*
    @return the first element of the deque
    Remove the first element and return it.
     */
    public T removeFirst(){
        if(isEmpty())
            return null;
        TNode result = sentinel.next;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size--;
        return result.item;
    }
    /*
    @return the last element of the deque
    Remove the last element of the deque and return it
     */
    public T removeLast(){
        if(isEmpty())
            return null;
        TNode result = sentinel.prev;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size--;
        return result.item;
    }
    /*
    @param the index of the required element
    @return the element at the specific index
     */
    public T get(int index){
        if(isEmpty() || index > size)
            return null;
        TNode temp = sentinel.next;
        while(index>0) {
            temp = temp.next;
            index--;
        }
        return temp.item;
        }
    /*
    Do the same as get(int index) but recursively.
     */
     public T getRecursive(int index){
        return getHelperRecursive(sentinel.next,index);
     }
    /*
    Helper method to run getRecursive.
     */
     private T getHelperRecursive(TNode temp, int index){
        if(index==0 || temp == null)
            return temp.item;
        else
            return getHelperRecursive(temp.next,index-1);
     }
    }


