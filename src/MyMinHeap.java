public class MyMinHeap<T extends Comparable<T>> {
    private final MyArrayList<T> array;

    public MyMinHeap() {
        array = new MyArrayList<>();
    }

    public void insert(T item) {
        array.add(item);
        int currentIndex = array.size() - 1;
        while (currentIndex > 0) {
            int parentIndex = (currentIndex - 1) / 2;
            if (array.get(currentIndex).compareTo(array.get(parentIndex)) >= 0) {
                break;
            }
            swap(currentIndex, parentIndex);
            currentIndex = parentIndex;
        }
    }

    public T deleteMin() {
        if (isEmpty()) {
            throw new RuntimeException("Heap is empty");
        }
        T min = array.get(0);
        array.set(0, array.get(array.size() - 1));
        array.remove(array.size() - 1);
        heapify(0);
        return min;
    }

    public T getMin() {
        if (isEmpty()) {
            throw new RuntimeException("Heap is empty");
        }
        return array.get(0);
    }

    public boolean isEmpty() {
        return array.size() == 0;
    }

    public int size() {
        return array.size();
    }

    private void heapify(int index) {
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        int smallestIndex = index;
        if (leftChildIndex < array.size() && array.get(leftChildIndex).compareTo(array.get(smallestIndex)) < 0) {
            smallestIndex = leftChildIndex;
        }
        if (rightChildIndex < array.size() && array.get(rightChildIndex).compareTo(array.get(smallestIndex)) < 0) {
            smallestIndex = rightChildIndex;
        }
        if (smallestIndex != index) {
            swap(index, smallestIndex);
            heapify(smallestIndex);
        }
    }

    private void swap(int i, int j) {
        T temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }
}

