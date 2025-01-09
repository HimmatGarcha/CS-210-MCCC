import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] sizes = {100, 500, 1000, 5000, 10000, 50000, 100000, 500000, 1000000};
        SortAlgorithm[] algorithms = {new InsertionSort(), new SelectionSort(), new BubbleSort(), new MergeSort(), new HeapSort(), new QuickSort()};

        for (SortAlgorithm algorithm : algorithms) {
            for (int size : sizes) {
                int[] array = generateRandomArray(size);
                long startTime = System.currentTimeMillis();
                algorithm.sort(array);
                long endTime = System.currentTimeMillis();
                System.out.println("Time for " + algorithm.getClass().getSimpleName() + " with size " + size + ": " + (endTime - startTime) + "ms");
            }
        }
    }
     /**
     * generates an array of random integers.
     * size the size of the array
     * reutrn the generated array
     */
    public static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(size);
        }
        return array;
    }
}
