public class SelectionSort implements SortAlgorithm {
    @Override
    public void sort(int[] array) {
        int n = array.length;

        // one by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++) {
            // find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (array[j] < array[min_idx])
                    min_idx = j;

            //swap the found minimum element with the first element of the unsorted array
            int temp = array[min_idx];
            array[min_idx] = array[i];
            array[i] = temp;
        }
    }
}
