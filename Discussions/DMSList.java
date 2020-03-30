public class DMSList{
    private IntNode sentinel;
    public DMSList(){
        sentinel = new IntNode(-1000, new IntNode(0,null));
    }
    public class IntNode{
        public int item;
        public IntNode next;
        public IntNode(int i, IntNode h){
            item=i;
            next = h;
        }
        public int max(){
            if(next ==null)
                return item;
            return Math.max(item,next.max());
        }
    }

    /* Returns 0 if list is empty. Otherwise, returns the max element. */
    public int max(){
        return sentinel.next.max();
    } 
}