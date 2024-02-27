import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Bag<T> implements Iterable<T> {
    private List<T> items = new ArrayList<>();

    // Add an item to the bag
    public void add(T item) {
        items.add(item);
    }

    // Check if the bag is empty
    public boolean isEmpty() {
        return items.isEmpty();
    }

    // Get the number of items in the bag
    public int size() {
        return items.size();
    }

    // Implement the Iterable interface
    @Override
    public Iterator<T> iterator() {
        return items.iterator();
    }}