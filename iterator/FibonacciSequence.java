import java.util.Iterator;

// This class is only used as a wrapper for the iterator.
// No logic is stored here, except for defining the limit.
public class FibonacciSequence implements Sequence {
    private int limit;

    public FibonacciSequence(int limit) {
        setLimit(limit);
    }

    // While limit can be changed here, it does nothing if the iterator is already created.
    public void setLimit(int limit) {
        if (limit < 0) throw new IllegalArgumentException("limit cannot be negative");
        this.limit = limit;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new FibonacciIterator(limit);
    }
}
