package sort;

import sort.sorting_algorithms.SelectionSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        SortContext sortContext = new SortContext(new SelectionSort());

        int[] test = createRandomArray(30, 100);
        System.out.println(Arrays.toString(test));

        int[] sortedTest = sortContext.sortArray(test);
        System.out.println(Arrays.toString(sortedTest));
    }

    public static int[] createRandomArray(int n, int max) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * max);
        }
        return arr;
    }

    public static void testSortingAlgorithm() {
        int[] set1 = createRandomArray(30, 100);
        int[] set2 = createRandomArray(100000, 5000);
    }
}
