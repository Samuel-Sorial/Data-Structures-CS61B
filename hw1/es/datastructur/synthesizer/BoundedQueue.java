package es.datastructur.synthesizer;

/**
 * @author : Samuel-Sorial
 * @param <T>
 */

public interface BoundedQueue<T> {

    int capacity(); // return size of the buffer.

    int fillCount(); // return number of items currently in the buffer.

    void enqueue(T x); // add item x to the end of it.

    T dequeue(); // get the first item and delete it from the front.

    T peek(); // return (but dont delete) the first item.

    /**
    @return: boolean determining if the queue is empty or not
     */
    default boolean isEmpty(){
        if(fillCount() == 0)
            return true;
        else
            return false;
    }

    /**
     * @return: boolean if the queue is full or not
     */
    default boolean isFull(){
        if(capacity() == fillCount())
            return true;
        else
            return false;
    }
}
