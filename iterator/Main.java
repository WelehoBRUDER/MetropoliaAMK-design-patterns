import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        FibonacciSequence fib = new FibonacciSequence(10);
        for (Iterator<Integer> it = fib.iterator(); it.hasNext(); ) {
            System.out.print(it.next() + " ");
        }
    }
}
