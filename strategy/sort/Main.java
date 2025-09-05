package sort;

import sort.sorting_algorithms.BubbleSort;
import sort.sorting_algorithms.InsertionSort;
import sort.sorting_algorithms.SelectionSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        SortContext sortContext = new SortContext(new SelectionSort());

        System.out.println("Creating dataset");

        int[] set1 = createRandomArray(90, 300);
        int[] set2 = createRandomArray(100000, 50000);

        System.out.println("Testing small array:");
        System.out.println(Arrays.toString(set1));


        System.out.println();
        System.out.println("Testing selection sort...");
        testSortingAlgorithm(sortContext, set1);

        System.out.println();
        System.out.println("Testing insertion sort...");
        sortContext.setStrategy(new InsertionSort());
        testSortingAlgorithm(sortContext, set1);

        System.out.println();
        System.out.println("Testing bubble sort...");
        sortContext.setStrategy(new BubbleSort());
        testSortingAlgorithm(sortContext, set1);

        System.out.println();
        System.out.println("=".repeat(50));
        System.out.println();
        System.out.println("Testing large array:");

        System.out.println();
        System.out.println("Testing selection sort...");
        sortContext.setStrategy(new SelectionSort());
        testSortingAlgorithm(sortContext, set2);

        System.out.println();
        System.out.println("Testing insertion sort...");
        sortContext.setStrategy(new InsertionSort());
        testSortingAlgorithm(sortContext, set2);

        System.out.println();
        System.out.println("Testing bubble sort...");
        sortContext.setStrategy(new BubbleSort());
        testSortingAlgorithm(sortContext, set2);
    }

    public static int[] createRandomArray(int n, int max) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * max);
        }
        return arr;
    }

    public static void testSortingAlgorithm(SortContext sortContext, int[] set) {
        int[] setCopy = Arrays.copyOf(set, set.length);
        double startTime = System.nanoTime();
        int[] _z = sortContext.sortArray(setCopy);
        double endTime = System.nanoTime();
        double totalTime = endTime - startTime;
        // Asked ChatGPT to remove scientific notation for better readability (for tiny numbers)
        System.out.printf("Total time taken: %.9f s%n", totalTime / 1_000_000_000.0);

    }
}
