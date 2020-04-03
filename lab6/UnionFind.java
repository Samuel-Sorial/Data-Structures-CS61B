/**
 * @author : Samuel Sorial
 * The interface of unioin find data structure, it's not required from the course, however, I did to be able
 * to apply my knowledge at two different implementations of unioin find.
 */
public interface UnionFind {

    /*
    Throws an exception if v1 is not a valid index.
     */
    void validate( int v1);

    /*
    Returns the size of the set v1 belongs to.
     */
    int sizeOf(int v1);

    /*
    Returns the parent of v1
     */
    int parent(int v1);

    /*
    Returns true if nodes v1 and v2 are connected together
     */
    boolean connected(int v1, int v2);

    /*
    connects two elements v1 and v2 together if and only if v1 and v2 are valid elements.
     */
    void union(int v1, int v2);

    /*
    Returns the root of the set v1 belongs to.
     */
    int find(int v1);

}
