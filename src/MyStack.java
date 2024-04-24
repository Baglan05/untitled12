public class MyStack<T> {
    private final MyArrayList<T> list = new MyArrayList<>();

    public void push(T item) { list.add(item); }
    public T pop() { return list.removeLast(); }
    public T peek() { return list.getLast(); }
    public boolean isEmpty() { return list.size() == 0; }
}
