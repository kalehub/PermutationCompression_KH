package com.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.Math;

public class BinaryEncoder {
    private int[] arr;

    public BinaryEncoder(int[] array) {
        this.arr = array;
    }

    public void displayArrByIndex(int index) {
        System.out.println(this.arr[index]);
    }

    public List<String> encode() {
        int max = Arrays.stream(this.arr).max().getAsInt();
        int bitLength = getBitLength(max, 2);
        List<String> binary = toBinary(this.arr, bitLength);
        return binary;
    }

    public int getBitLength(int max, int logBase) {
        return (int) (Math.ceil(Math.log(max) / Math.log(logBase)));
    }

    public List<String> toBinary(int[] arr, int bitLength) {
        List<String> binary = new ArrayList<String>();
        for (int i = 0; i < arr.length; i++) {
            String binaryString = "";
            if (arr[i] == 0) {
                binaryString = "0".repeat(3);
            } else {
                int quotient = arr[i];
                while (quotient != 0) {
                    String remainder = String.valueOf(quotient % 2);
                    quotient = quotient / 2;
                    binaryString = remainder + binaryString;
                }
            }
            if (binaryString.length() < bitLength) {
                int lengthDifference = bitLength - binaryString.length();
                String pre = "0".repeat(lengthDifference);
                binaryString = pre + binaryString;
            }
            binary.add(binaryString);
        }
        return binary;
    }

}