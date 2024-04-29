public class MyStack<T> {

    MyArrayList<T> arr = new MyArrayList<>();
    public boolean is_empty(){
        return this.arr.size() == 0;
    }

    public int size(){
        return this.arr.size();
    }

    public T peek(){
        return this.arr.getLast();
    }

    public void push(T element){
        this.arr.add(element);
    }

    public void pop(){
        this.arr.remove(this.arr.size()-1);
    }
}
