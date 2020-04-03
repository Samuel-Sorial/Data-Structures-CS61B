import java.util.NoSuchElementException;

/**
 * @author : Samuel Sorial
 */
public class UnionFind {

    int[] elements;
    int[] sizes;
    /* Creates a UnionFind data structure holding n vertices. Initially, all
       vertices are in disjoint sets. */
    public UnionFind(int n) {
        elements = new int[n];
        sizes = new int[n];

        for(int i = 0; i<elements.length; i++){
            elements[i] = -1;
            sizes[i] = 1;
        }
    }

    /* Throws an exception if v1 is not a valid index. */
    private void validate(int vertex) {
        throw new NoSuchElementException("The index is not valid");
    }

    /* Returns the size of the set v1 belongs to. */
    public int sizeOf(int v1) {
        int root = find(v1);
        return sizes[v1];
    }

    /* Returns the parent of v1. If v1 is the root of a tree, returns the
       negative size of the tree for which v1 is the root. */
    public int parent(int v1) {
        if(elements[v1] == -1)
            return -sizeOf(v1);
        else
            return elements[v1];
    }

    /* Returns true if nodes v1 and v2 are connected. */
    public boolean connected(int v1, int v2) {
        return find(v1) == find(v2);
    }

    /* Connects two elements v1 and v2 together. v1 and v2 can be any valid 
       elements, and a union-by-size heuristic is used. If the sizes of the sets
       are equal, tie break by connecting v1's root to v2's root. Unioning a 
       vertex with itself or vertices that are already connected should not 
       change the sets but may alter the internal structure of the data. */
    public void union(int v1, int v2) {
        int root1 = find(v1);
        int root2 = find(v2);
        if(root1 == root2)
            return;
        else if(sizes[root1] > sizes[root2]){
            elements[v2] = v1;
            sizes[root1] += sizes[root2];
        }
        else{
            elements[v1] = v2;
            sizes[root2] += sizes[root1];
        }
    }

    /* Returns the root of the set V belongs to. Path-compression is employed
       allowing for fast search-time. */
    public int find(int vertex) {
        if(elements[vertex] == -1)
            return vertex;
        else
            return find(elements[vertex]);
    }

}
