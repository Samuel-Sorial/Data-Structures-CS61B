public class OffByOne implements CharacterComparator{
    private int N;

    @Override
    public boolean equalChars(char x, char y) {

        return x+ 1 ==y || x- 1 == y;
    }
}
