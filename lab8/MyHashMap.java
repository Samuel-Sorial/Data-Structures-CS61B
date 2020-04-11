import java.util.*;

/**
 * @author : Samuel-Sorial
 * @param <K>
 * @param <V>
 */
public class MyHashMap<K,V> implements Map61B<K,V> {
    private class Entry{
        K key;
        V value;
        public Entry(K key, V value){
            this.key = key;
            this.value = value;
        }
    }
    private final double loadFactor;
    private int totalSize;
    private Set<K> keySet;
    private List<Entry>[] elements;

    public MyHashMap(){
        this(16,.75);
    }

    public MyHashMap(int initialSize){
        this(initialSize,.75);
    }

    public MyHashMap(int initialSize, double loadFactor){
        totalSize = initialSize;
        elements = new List[totalSize];
        this.loadFactor = .75;
        keySet = new HashSet<>();
    }

    @Override
    public void clear() {
        elements = new List[totalSize];
        keySet = new HashSet<>();
    }

    @Override
    public boolean containsKey(K key) {
        if(key == null)
            return false;
        return keySet.contains(key);
    }

    @Override
    public V get(K key) {
        if(key == null || !keySet.contains(key))
            return null;
        int index = getIndex(key);
        for(Entry e : elements[index]){
            if(e.key.equals(key))
                return e.value;
        }
        return null;
    }

    @Override
    public int size() {
        return keySet.size();
    }

    @Override
    public void put(K key, V value) {
        if(key == null || value == null) {
            return;
        }
        if((keySet.size() / totalSize) == loadFactor)
            resize();
        int index = getIndex(key);
        if(keySet.contains(key)){
            changeValue(key,value,index);
            return;
        }
        if(elements[index] == null)
            elements[index] = new LinkedList<>();
        elements[index].add(new Entry(key,value));
        keySet.add(key);
    }

    private int getIndex(K key) {
        return (key.hashCode() & 0x7FFFFFFF) % totalSize;
    }

    private void resize() {
        int latestSize = totalSize;
        totalSize = totalSize*2;
        List[] newElements = new List[totalSize];
        for(int i = 0; i<latestSize; i++){
            for(Entry e : elements[i]){
                int newIndex = getIndex(e.key);
                if(newElements[newIndex] == null){
                    newElements[newIndex] = new LinkedList();
                }
                newElements[newIndex].add(e);
            }
        }
        elements = newElements;
    }

    private void changeValue(K key, V value,int index) {
        for(Entry e : elements[index]){
            if(e.key.equals(key))
                e.value = value;
        }
    }

    @Override
    public Set<K> keySet() {
        return keySet;
    }
    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator iterator() {
        return keySet.iterator();
    }
}
