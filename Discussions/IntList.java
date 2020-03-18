public class IntList {
    public int first;
    public IntList rest;        

    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }
    public static IntList square(IntList L){
        if(L == null)
            return L;
        else{
            IntList rest = square(L.rest);
            IntList squaredList = new IntList(L.first*L.first,rest);
            return M;
        }
    }
    public static IntList squareDestructive(IntList L){
        if(L.rest==null){
            L.first = L.first *L.first;
            return L;
        }
        else{
            L.first = L.first *L.first;
            L.rest = squareDestructive(L.rest);
            return L;
        } 
    }
    public static void main(String[] args){
        IntList testing = new IntList(3,null);
        testing  = new IntList(5,testing);
        testing = new IntList(7,testing);
        square(testing);
    }
}
