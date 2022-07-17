package com.main;

import java.util.Arrays;
import java.util.List;

public class EliminationCompression {
    private int[] arrays;

    EliminationCompression(int[] array) {
        this.arrays = array;
    }

    public void compress() {
        int[] array = quickSort(0, 7);
        System.out.println(Arrays.toString(this.arrays));

        // Sort using quick sort
        // Begin compression
    }

    public int[] quickSort(int low, int high) {
        // code courtesy of geeksforgeeks
        if (low < high) {
            int pivotIndex = getPartition(low, high);
            quickSort(low, pivotIndex - 1);
            quickSort(pivotIndex + 1, high);
        }
        return this.arrays;
    }

    public int getPartition(int low, int high) {
        int temp = 0;
        int pivot = this.arrays[high];
        int i = (low - 1);
        for (int j = low; j <= high - 1; j++) {
            if (this.arrays[j] < pivot) {
                i++;
                temp = this.arrays[i];
                this.arrays[i] = this.arrays[j];
                this.arrays[j] = temp;
            }
        }
        temp = this.arrays[i + 1];
        this.arrays[i + 1] = this.arrays[high];
        this.arrays[high] = temp;
        // System.out.println(Arrays.toString(this.arrays));
        return (i + 1);
    }
}
