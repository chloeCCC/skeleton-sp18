public class ArrayDeque<T> {
    private int front;
    private int back;
    private int capacity = 8;
    private T[] items;

    /* Create an empty Array Deque: */
    public ArrayDeque() {
        items = (T[]) new Object[capacity];
        front = 0;
        back = 0;
    }


    /* Adds an item of type T to the front of the deque */
    public void addFirst(T item) {
        if (isFull()) {
            resize((int) (capacity * 1.5));
        }
        front = (front - 1 + capacity) % capacity;
        items[front] = item;
    }

    /* Adds an item of type T to the back of the deque */
    public void addLast(T item) {
        if (isFull()) {
            resize((int) (capacity * 1.5));
        }
        items[back] = item;
        back = (back + 1 + capacity) % capacity;
    }

    /* Returns true if deque is empty, false otherwise */
    public boolean isEmpty() {
        return front == back;
    }

    /* Returns the number of items in the deque. Must be a constant time */
    public int size() {
        return (back - front + capacity) % capacity;
    }

    /* Prints the items in the deque from first to last, separated by a space. */
    public void printDeque() {
        if (front < back) {
            for (int i = front; i < back; i++) {
                if (i == back - 1) {
                    System.out.println(items[i]);
                    break;
                }
                System.out.println(items[i] + " ");
            }
        } else if (front > back) {
            for (int i = front; i < capacity; i++) {
                System.out.println(items[i] + " ");
            }
            for (int i = 0; i < back; i++) {
                if (i == back - 1) {
                    System.out.println(items[i]);
                    break;
                }
                System.out.println(items[i] + " ");
            }
        }
    }

    /* Removes and returns the item at the front of the deque.
    If no such item exists, returns null */
    public T removeFirst() {
        if (!isEmpty()) {
            T temp = items[front];
            front = (front + 1 + capacity) % capacity;
            if (isLowUsage()) {
                resize((int) (capacity * 0.5));
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
            back = (back - 1 + capacity) % capacity;
            if (isLowUsage()) {
                resize((int) (capacity * 0.5));
            }
            return temp;
        }
        return null;
    }


    /* Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
    If no such item exists, returns null. Must not alter the deque! Must use Iteration.
     */
    public T get(int index) {
        if (index >= size() || index < 0 || isEmpty()) {
            return null;
        }
        if (front < back) {
            return items[index + front];
        } else if (front > back) {
            if (index + front < capacity) {
                return items[index + front];
            } else {
                return items[(index + front) % capacity];
            }
        }
        return null;
    }

    // check if array is full
    private boolean isFull() {
        return size() == capacity - 1;
    }


    // Resizing array
    private void resize(int newSize) {
        T[] newArray = (T[]) new Object[newSize];
        int size = size();
        if (front < back) {
            for (int i = front, j = 0; i < back && j < size; i++, j++) {
                newArray[j] = items[i];
            }
        } else if (front > back) {
            int j = 0;
            for (int i = front; j < capacity - front; i++, j++) {
                newArray[j] = items[i];
            }
            for (int i = 0; j < size; i++, j++) {
                newArray[j] = items[i];
            }
        }
        front = 0;
        back = size;
        items = newArray;
        capacity = newSize;

    }

}
