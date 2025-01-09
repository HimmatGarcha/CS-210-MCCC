
import java.util.*;

public class OrderedList<E extends Comparable<E>> {
    private LinkedList<E> list;
   // constructs and intliazes the list
    public OrderedList() {
        list = new LinkedList<>();
    }
   // organizes objects added to the list
    public void add(E obj) {
        if (list.isEmpty()) {
            list.add(obj);
        } else {
            ListIterator<E> iterator = list.listIterator();
            while (iterator.hasNext()) {
                if (obj.compareTo(iterator.next()) < 0) {
                    iterator.previous();
                    iterator.add(obj);
                    return;
                }
            }
            list.add(obj); // add at the end if said object is greater than all the other elements
        }
    }

    public Iterator<E> iterator() {
        return list.iterator();
    }
   // gets a element at the index
    public E get(int index) {
        return list.get(index);
    // return said element at said index
    }

    public int size() {
        return list.size();
    // gets and returns list size
    }

    public boolean remove(E obj) {
        return list.remove(obj);
    }

    @Override
    public String toString() {
        return list.toString();
    // check param is obj meets conditions to be removed if so its removed
    }
}
