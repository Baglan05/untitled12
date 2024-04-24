
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        MyArrayList<Integer> arr1 = new MyArrayList<>();
        MyLinkedList<Integer> arr2 = new MyLinkedList<>();
        arr1.add(15);

        arr1.remove(0);

        arr1.add(7);

        arr2.add(45);
        arr2.add(44);
        arr2.add(43);
        arr2.add(42);


        System.out.println(arr1.get(0));

        System.out.println(arr2.get(0));

        arr2.clear();

        for (int i = 0; i < arr2.size(); i++) {
            System.out.print(arr2.get(i) + " ");
        }

        arr2.add(49);

        System.out.println(arr2.getFirst());
        arr2.set(0, 50);
        System.out.println(arr2.getFirst());



    }
}