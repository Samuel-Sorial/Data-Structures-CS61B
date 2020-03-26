public class LinkedListDeque<T> {

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
            size = 0;
        }
    }

    public LinkedListDeque(){
        sentinel = new TNode(null,null,null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size=0;
    }

    public void addFirst(T item){
        TNode added = new TNode(sentinel ,item, sentinel.next);
        sentinel.next.prev = added;
        sentinel.next = added;
        size++;
    }


}
