package sort.sorting_algorithms;
// Optimized java implementation of Bubble sort
import sort.Sort;

import java.io.*;

// Source code:
// https://www.geeksforgeeks.org/dsa/bubble-sort-algorithm/

public class BubbleSort implements Sort {

    // An optimized version of Bubble Sort
    public int[] sort(int[] arr){
        int i, j, temp;
        int n = arr.length;
        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {

                    // Swap arr[j] and arr[j+1]
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no two elements were
            // swapped by inner loop, then break
            if (swapped == false)
                break;
        }
        return arr;
    }
}