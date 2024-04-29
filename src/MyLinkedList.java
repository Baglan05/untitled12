import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements MyList<T> {

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    private class MyNode<T> {
        T data;
        MyNode<T> next;

        MyNode(T data) {
            this.data = data;
            next = null;
        }
    }

    private MyNode<T> head;
    private MyNode<T> tail;
    private int size;

    public MyLinkedList() {
        head = tail = null;
        size = 0;
    }

    @Override
    public void add(T data) {
        addLast(data);
    }

    @Override
    public void set(int index, T item) {
        checkIndex(index);
        MyNode<T> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        currentNode.data = item;
    }

    @Override
    public void add(int index, T item) {
        if (index == 0) {
            addFirst(item);
        } else if (index == size) {
            addLast(item);
        } else {
            checkIndex(index);
            MyNode<T> currentNode = head;
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.next;
            }
            MyNode<T> newNode = new MyNode<>(item);
            newNode.next = currentNode.next;
            currentNode.next = newNode;
            size++;
        }
    }

    @Override
    public void addFirst(T item) {
        MyNode<T> newNode = new MyNode<>(item);
        newNode.next = head;
        head = newNode;
        if (size == 0) {
            tail = head;
        }
        size++;
    }

    @Override
    public void addLast(T item) {
        MyNode<T> newNode = new MyNode<>(item);
        if (size == 0) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        MyNode<T> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.data;
    }

    @Override
    public T getFirst() {
        if (head == null) throw new NoSuchElementException("List is empty");
        return head.data;
    }

    @Override
    public T getLast() {
        if (tail == null) throw new NoSuchElementException("List is empty");
        return tail.data;
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        } else {
            MyNode<T> currentNode = head;
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.next;
            }
            currentNode.next = currentNode.next.next;
            size--;
        }
    }

    @Override
    public void removeFirst() {
        if (head == null) throw new NoSuchElementException("List is empty");
        head = head.next;
        if (head == null) tail = null;
        size--;
    }

    @Override
    public void removeLast() {
        if (tail == null) throw new NoSuchElementException("List is empty");
        if (head == tail) {
            head = tail = null;
        } else {
            MyNode<T> currentNode = head;
            while (currentNode.next != tail) {
                currentNode = currentNode.next;
            }
            currentNode.next = null;
            tail = currentNode;
        }
        size--;
    }

    @Override
    public void sort() {

    }

    @Override
    public int indexOf(Object object) {
        MyNode<T> currentNode = head;
        int index = 0;
        while (currentNode != null) {
            if (currentNode.data == null ? object == null : currentNode.data.equals(object)) {
                return index;
            }
            currentNode = currentNode.next;
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        int index = 0, lastIndex = -1;
        MyNode<T> currentNode = head;
        while (currentNode != null) {
            if (currentNode.data == null ? object == null : currentNode.data.equals(object)) {
                lastIndex = index;
            }
            currentNode = currentNode.next;
            index++;
        }
        return lastIndex;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        MyNode<T> currentNode = head;
        int index = 0;
        while (currentNode != null) {
            array[index++] = currentNode.data;
            currentNode = currentNode.next;
        }
        return array;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }


    @Override
    public int size() {
        return size;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("index not correct");
    }

};