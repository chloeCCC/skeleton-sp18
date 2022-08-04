public class LinkedListDeque<T> {

    private int size;
    private TNode sentinel;

    /* Nested class */
    private class TNode {
        private TNode prev;
        private T item;
        private TNode next;

        public TNode(TNode p, T i, TNode n) {
            item = i;
            prev = p;
            next = n;
        }
    }

    /* Create an empty Linked List Deque: An empty DLList has only a sentinel,
    and a sentinel.next and sentinel.prev both refer back to sentinel.*/
    public LinkedListDeque() {
        sentinel = new TNode(sentinel, null, sentinel);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

//    public LinkedListDeque(T item) {
//        sentinel = new TNode((T)63, null, null);
//        sentinel.next = new TNode(item, sentinel, sentinel);
//        sentinel.prev = new TNode(item, sentinel, sentinel);
//        size = 1;
//    }

    /* Adds an item of type T to the front of the deque */
    public void addFirst(T item) {
        sentinel.next = new TNode(sentinel, item, sentinel.next);
        size += 1;
    }

    /* Adds an item of type T to the back of the deque */
    public void addLast(T item) {
        sentinel.prev = new TNode(sentinel.prev, item, sentinel);
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
        TNode p = sentinel;
        p = p.next;
        while (p != sentinel) {
            System.out.print(" ");
            p = p.next;
        }
    }

    /* Removes and returns the item at the front of the deque.
     If no such item exists, returns null */
    public T removeFirst() {
        if (!isEmpty()) {
            T temp = sentinel.next.item;
            sentinel.next = sentinel.next.next;
            size -= 1;
            return temp;
        }
        return null;
    }

    /* Removes and returns the item at the last of the deque.
    If no such item exists, returns null */
    public T removeLast() {
        if (!isEmpty()) {
            T temp = sentinel.prev.item;
            sentinel.prev = sentinel.prev.prev;
            size -= 1;
            return temp;
        }
        return null;
    }


    /* Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
    If no such item exists, returns null. Must not alter the deque! Must use Iteration.
     */
    public T get(int index) {
        TNode p = sentinel;
        int i = 0;
        p = p.next;
        while (i < size) {
            if (i == index) {
                return p.item;
            }
            p = p.next;
            i += 1;
        }
        return null;
    }

    /* Same as get, but uses recursion */

    public T getRecursive(int index) {
        if (isEmpty()) {
            return null;
        }
        TNode p = sentinel;
        return helper(p.next, index);
    }

    private T helper(TNode p, int index) {
        if (index == 0) {
            return p.item;
        }
        return helper(p.next, index--);
    }

}
