import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

public class MyTrieSet implements  TrieSet61B{

    private DataIndexedCharMap root;
    private int totalKeys;

    public MyTrieSet(){
        root = new DataIndexedCharMap(false);
        totalKeys = 0;
    }
    @Override
    public void clear() {
        root = null;
        totalKeys = 0;
    }
    @Override
    public boolean contains(String key) {
        if(key == null){
            throw new NoSuchElementException();
        }
        char[] keys = key.toCharArray();
        DataIndexedCharMap temp = root;
        for(int i = 0; i<keys.length; i++){
            if(temp == null){
                return false;
            }
            if(temp.nextChars.containsKey(keys[i])){
                if(i == keys.length -1){
                    return temp.nextChars.get(keys[i]).isKey;
                }
                temp = temp.nextChars.get(keys[i]);
            }
        }
        return false;
    }

    @Override
    public void add(String key) {
        char[] keys = key.toCharArray();
        add(keys,0,root);
    }

    private void add(char[] keys, int i,DataIndexedCharMap curr) {
        if(curr.nextChars.containsKey(keys[i])){
            if(i == keys.length -1){
                curr.isKey = true;
            }else{
            add(keys,i+1,curr.nextChars.get(keys[i]));
            }
        }else{
            if(i == keys.length -1){
                curr.nextChars.put(keys[i], new DataIndexedCharMap(true));
            }else{
                curr.nextChars.put(keys[i], new DataIndexedCharMap(false));
                add(keys,i+1, curr.nextChars.get(keys[i]));
            }
        }
    }

    @Override
    public List<String> keysWithPrefix(String prefix) {
        return null;
    }

    @Override
    public String longestPrefixOf(String key) {
        return null;
    }

    private class DataIndexedCharMap{
        private boolean isKey;
        private HashMap<Character,DataIndexedCharMap> nextChars;

        private DataIndexedCharMap(boolean isKey){
            this.isKey = isKey;
            nextChars = new HashMap<>();
        }
    }
}
