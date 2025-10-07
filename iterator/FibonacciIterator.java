import java.util.Iterator;

// The iterator handles all logic when it comes the sequence.
public class FibonacciIterator implements Iterator<Integer> {
    private int prev = 0;
    private int curr = 1;
    private final int max;
    private int count = 0;

    // No need to verify the max value here since the sequence class will throw an error if it's incorrect.
    public FibonacciIterator(int max) {
        this.max = max;
    }

    @Override
    public boolean hasNext() {
        return count < max;
    }

    // It makes more sense to keep the calculation in here
    // so that there is a clear separation between the sequence and the iterator.
    @Override
    public Integer next() {
        if (hasNext()) {
            int val;
            if (count == 1) {
                val = 1;
            }
            else {
                val = prev + curr;
                prev = curr;
                curr = val;
            }
        count++;
        return val;
        }
        return null;
    }
}
