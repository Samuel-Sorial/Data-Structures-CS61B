public class OffByN implements CharacterComparator{
    private int N;

    public OffByN(int n){
        this.N = n;
    }
    @Override
    public boolean equalChars(char x, char y) {

        return x+ this.N ==y || x- this.N == y;
    }
}
