
import java.util.*;

public class TestOrderedList {
    public static void main(String[] args) {
        OrderedList<Integer> orderedList = new OrderedList<>();

        // test case add method
        orderedList.add(5);
        orderedList.add(3);
        orderedList.add(4);
        System.out.println("After adding 5, 3, 4: " + orderedList); // result should print: [3, 4, 5]
        System.out.println("Size of the list: " + orderedList.size()); // result should print: 3

        // test to remove method
        orderedList.remove(4);
        System.out.println("After removing 4: " + orderedList); // Should print: [3, 5]

        // test the iterator
        System.out.println("Elements in the list:");
        Iterator<Integer> iterator = orderedList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // more test get method
        System.out.println("Element at index 0: " + orderedList.get(0)); // Should print: 3

        // test cases for the add method with duplicate elements
        orderedList.add(5);
        orderedList.add(5);
        System.out.println("After adding 5 twice: " + orderedList); // Should print: [3, 5, 5, 5]

        // test cases to remove method with non-existing element
        boolean isRemoved = orderedList.remove(7);
        System.out.println("After trying to remove 7: " + orderedList + ", removed: " + isRemoved); // Should print: [3, 5, 5, 5], removed: false

        // test case for get method with invalid index
        try {
            System.out.println("Element at index 10: " + orderedList.get(10));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Caught exception: " + e.getMessage()); // cases should print: Index: 10, Size: 4
        }
    }
}
