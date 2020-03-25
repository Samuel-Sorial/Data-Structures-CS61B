public class SSList{
    private class IntNode{
        public int item;
        public IntNode next;
        
        public IntNode(int item, IntNode next){
            this.item = item;
            this.next = next;
        }
    }
    private IntNode first;

    public SSList(){
        first = new IntNode(4,null);
    }
    public void addFirst(int x){
        first = new IntNode(x,first);
    }
    /* Insert a given integer at a given positin */
    public void insert(int x, int pos){
        if(first == null || pos == 0){
            addFirst(x);
            return;
        }
        IntNode temp = first;
        while(temp.next != null && pos > 1){
            temp = temp.next;
            pos--;
        }
        temp.next = new IntNode(x,temp.next);
    }

    public void inverse(){
        if(first == null || first.next == null)
            return;
        
        IntNode ptr = first.next;
        first.next= null;

        while(ptr != null){
            IntNode temp = ptr.next;
            ptr.next = first;
            first = ptr;
            ptr = temp;
        }
    }
    public void recursiveInverse(){
        first = helperInverse(first);
    }
    private IntNode helperInverse(IntNode ls){
        if(ls == null || ls.next == null)
            return ls;
        else{
            IntNode end = ls.next;
            IntNode reverse = helperInverse(ls.next);
            end.next = ls;
            ls.next = null;
            return reverse;            
        }
    }
    public static void main(String[] args){
        SSList test = new SSList();
        test.addFirst(3);
        test.addFirst(2);
        test.addFirst(1);
        test.recursiveInverse();
    }
}