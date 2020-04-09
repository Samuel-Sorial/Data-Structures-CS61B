import java.util.Set;
import java.util.Iterator;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V> {
    private BST root;

    private class BST {
        private K key;
        private V value;
        private BST left, right;
        private int size;
        /*Test*/
        private BST(K k, V v) {
            key = k;
            value = v;
            size = 1;
        }
    }

    @Override
    public void clear() {
        root = null;
    }

    @Override
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    @Override
    public V get(K key) {
        return get(root, key);
    }

    private V get(BST x, K key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return get(x.left, key);
        } else if (cmp > 0) {
            return get(x.right, key);
        } else {
            return x.value;
        }
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(BST x) {
        if (x == null) {
            return 0;
        }
        return x.size;
    }

    @Override
    public void put(K key, V value) {
        root = put(root, key, value);
    }

    private BST put(BST x, K key, V value) {
        if (x == null) {
            return new BST(key, value);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = put(x.left, key, value);
        } else if (cmp > 0) {
            x.right = put(x.right, key, value);
        } else {
            x.value = value;
        }
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException();
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
    public Iterator<K> iterator() {
        throw new UnsupportedOperationException();
    }

    public void printInOrder() {
        printInOrder(root);
    }

    private void printInOrder(BST x) {
        if (x.left == null && x.right == null) {
            printNode(x);
        } else if (x.right == null) {
            printInOrder(x.left);
            printNode(x);
        } else if (x.left == null) {
            printNode(x);
            printInOrder(x.right);
        } else {
            printInOrder(x.left);
            printNode(x);
            printInOrder(x.right);
        }
    }

    private void printNode(BST x) {
        System.out.print(x.key);
        System.out.println(" " + x.value);
    }
}
