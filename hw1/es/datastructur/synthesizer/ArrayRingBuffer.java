package es.datastructur.synthesizer;
import java.util.Iterator;
/**
 * @author : Samuel Sorial
 * @param <T>
 */
public class ArrayRingBuffer<T>  implements BoundedQueue<T> {

    /* Index for the next dequeue or peek. */
    private int first;
    /* Index for the next enqueue. */
    private int last;
    /* Variable for the fillCount. */
    private int fillCount;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        rb =  (T[])  new Object[capacity];
        first = 0;
        last = 0;
        fillCount = 0;
    }
    private int increaseOne(int number){
        if(number == rb.length-1)
            return 0;
        else
            return number+1;
    }

    @Override
    public int capacity() {
        return rb.length;
    }

    @Override
    public int fillCount() {
        return fillCount;
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow").
     */
    @Override
    public void enqueue(T x) {
        if(isFull())
            throw new RuntimeException("Ring Buffer Overflow");
        rb[last] = x;
        last = increaseOne(last);
        fillCount++;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow").
     */
    @Override
    public T dequeue() {
        if(isEmpty())
            throw new RuntimeException("Ring Buffer Underflow");
        T result = rb[first];
        first = increaseOne(first);
        return result;
    }

    /**
     * Return oldest item, but don't remove it. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow").
     */
    @Override
    public T peek() {
        if(isEmpty())
            throw new RuntimeException("Ring Buffer Underflow");
        T result = rb[first];
        return result;
    }

    @Override
    public Iterator<T> iterator() {
        MyIterator iterator = new MyIterator();
        return iterator;
    }

    private class MyIterator implements Iterator<T>{
        int count = 0;
        int pos = first;

        @Override
        public boolean hasNext() {
            return count < fillCount;
        }

        @Override
        public T next() {
            T item = rb[pos];
            pos = increaseOne(pos);
            count++;
            return item;
        }
    }
    @Override
    public boolean equals(Object other){
        if(other == this)
            return true;
        else if(other == null)
            return false;
        else if(other.getClass() != ArrayRingBuffer.class)
            return false;
        ArrayRingBuffer<T> arr = (ArrayRingBuffer<T>) other;
        Iterator<T> iterator1 = this.iterator();
        Iterator<T> iterator2 = arr.iterator();
        while(iterator1.hasNext()) {
            if (iterator1.next() != iterator2.next())
                return false;
        }
        return true;
    }
}
