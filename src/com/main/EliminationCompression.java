package com.main;

import java.util.Arrays;

public class EliminationCompression {
    private int[] arrays;

    EliminationCompression(int[] array) {
        this.arrays = array;
    }

    public void compress() {
        int[] arr = this.arrays.clone();
        arr = quickSort(0, 7, arr);
        // System.out.println("Unsorted:" + Arrays.toString(this.arrays));
        System.out.println("Sorted:" + Arrays.toString(arr));
        /*
         * Compression:
         * Select i item from array
         * Return its index in sorted array
         * Convert to binaries and determine its length
         */
        for (int i = 0; i < this.arrays.length; i++) {
            int idx = binarySearch(this.arrays[i], arr, 0, 7);
            String binaries = encodeToBinary(idx, this.arrays.length);
            System.out.println(binaries);
        }

    }

    private String encodeToBinary(int idx, int len) {
        int lengthNeeded = (int) (Math.ceil(Math.log(len) / Math.log(2)));
        String binNum = "";
        if (idx == 0) {
            return "0".repeat(lengthNeeded);
        }
        for (int i = idx; i > 0; i = i / 2) {
            String remainder = String.valueOf(i % 2);
            binNum = remainder + binNum;
        }
        if (binNum.length() < lengthNeeded) {
            binNum = "0".repeat(lengthNeeded - binNum.length()) + binNum;
        }
        return binNum;
    }

    public int binarySearch(int num, int[] array, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        if (num == array[mid]) {
            return mid;
        } else if (num > array[mid]) {
            return binarySearch(num, array, mid + 1, high);
        } else {
            return binarySearch(num, array, low, mid - 1);
        }
    }

    public int[] quickSort(int low, int high, int[] arr) {
        // code courtesy of geeksforgeeks
        if (low < high) {
            int pivotIndex = getPartition(low, high, arr);
            quickSort(low, pivotIndex - 1, arr);
            quickSort(pivotIndex + 1, high, arr);
        }
        return arr;
    }

    public int getPartition(int low, int high, int[] arr) {
        int temp = 0;
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return (i + 1);
    }
}
