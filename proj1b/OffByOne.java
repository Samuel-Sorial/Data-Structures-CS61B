public class OffByOne implements CharacterComparator{
    private int N;

    public OffByOne(int n){
        this.N = n;
    }
    @Override
    public boolean equalChars(char x, char y) {

        return x+ this.N ==y || x- this.N == y;
    }
}
