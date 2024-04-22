public class MyLinkedList<T> implements MyList<T> {
    private class Node {
        T data;
        Node next, prev;
        Node(T data) { this.data = data; }
    }

    private Node head, tail;
    private int size;

    public MyLinkedList() {
        head = tail = null;
        size = 0;
    }

    // Implement required methods here...
    // Methods like addFirst, addLast, removeFirst, removeLast will update head and tail references.

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }
}
