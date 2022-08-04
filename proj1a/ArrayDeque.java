public class ArrayDeque<T> {
    private int front;
    private int back;
    private int size;
    private T[] items;

    /* Create an empty Array Deque: */
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0; // item in array that is not null.
        front = 4;
        back = 5;
    }


    /* Adds an item of type T to the front of the deque */
    public void addFirst(T item) {
        if (items[front] == null) {
            items[front] = item;
        }
        front -= 1;
        if (front < 0) {
            front = items.length - 1;
        }
        size += 1;
    }

    /* Adds an item of type T to the back of the deque */
    public void addLast(T item) {
        if (items[back] == null) {
            items[back] = item;
        }
        if (back > items.length - 1) {
            back = 0;
        }
        back += 1;
        size += 1;
    }

    /* Returns true if deque is empty, false otherwise */
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    /* Returns the number of items in the deque. Must be a constant time */
    public int size() {
        return size;
    }

    /* Prints the items in the deque from first to last, separated by a space. */
    public void printDeque() {
        int temp = front;
        while (items[temp] != null) {
            System.out.print(" ");
            temp += 1;
            if (temp > items.length - 1) {
                temp = 0;
            }
        }
    }

    /* Removes and returns the item at the front of the deque.
    If no such item exists, returns null */
    public T removeFirst() {
        if (!isEmpty()) {
            T temp = items[front];
            items[front] = null;
            size -= 1;
            front += 1;
            if (front > items.length - 1) {
                front = 0;
            }
            return temp;
        }
        return null;
    }

    /* Removes and returns the item at the last of the deque.
    If no such item exists, returns null */
    public T removeLast() {
        if (!isEmpty()) {
            T temp = items[back];
            items[back] = null;
            size -= 1;
            back -= 1;
            if (back < 0) {
                back = items.length - 1;
            }
            return temp;
        }
        return null;
    }


    /* Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
    If no such item exists, returns null. Must not alter the deque! Must use Iteration.
     */
    public T get(int index) {
        return items[index];
    }

}
