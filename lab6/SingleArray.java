import java.util.NoSuchElementException;

public class SingleArray implements UnionFind {
    private int[] elements;


    public SingleArray(int number){
        elements = new int[number];
        for(int i = 0; i<number; i++)
            elements[i] = -1;
    }
    @Override
    public void validate(int v1) {
        if(v1 > elements.length || v1 < 0)
            throw new NoSuchElementException("Wrong element");
    }

    @Override
    public int sizeOf(int v1) {
        validate(v1);
        int root = find(v1);
        return elements[root];
    }

    @Override
    public int parent(int v1) {
        validate(v1);
        return elements[v1];
    }

    @Override
    public boolean connected(int v1, int v2) {
        validate(v1);
        validate(v2);
        if(v1 == v2)
            return true;
        int root1 = find(v1);
        int root2 = find(v2);
        return root1 == root2;
    }

    @Override
    public void union(int v1, int v2) {
        int root1 = find(v1);
        int root2 = find(v2);
        if(root1 == root2)
            return;
        else if(elements[root1] <elements[root2]){ // Which means that size of set1 bigger than set2
            elements[root1] += elements[root2]; // Add the size of set2 to the size of set1
            elements[v2] = root1; // Make the root of v2 : root1
        }
        else{ //Which means that size of set2 is bigger than set1 or they are equal.
            elements[root2] += elements[root1];  // Add the size of set1 to the size of set2
            elements[v1] = root2; //Make the root of v1 is root 2
        }
    }

    @Override
    public int find(int v1) {
        validate(v1); //Make sure this is a valid element.
        if(elements[v1] < 0) //If the stored value is negative, then it's a root (Base case)
            return v1;
        else
            return find(parent(v1)); //Recurse it with the parent of v1.
    }
}
