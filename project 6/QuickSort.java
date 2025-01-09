public class QuickSort implements SortAlgorithm {
    @Override
    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }
     /**
     * Recursive function to sort an array using Quick Sort algorithm.
     * array the array to sort
     * low starting index
     * high ending index
     */
    private void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);

            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }
   /**
     * Takes last element as pivot and places the pivot element at its correct position in sorted array,
     * and sll places smaller than pivo  to left of pivot and all greater elements to right of pivot.
     * array the array
     * low starting index
     * high ending index
     * partitioning index
     */
    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;

                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }
}
