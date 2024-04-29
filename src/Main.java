
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        MyMinHeap<Integer> arr = new MyMinHeap<>();

        arr.insert(30);
        arr.insert(35);
        arr.insert(25);
        System.out.println(arr.getMin());

        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.getMin());
            arr.deleteMin();
        }

    }
}