package com.main;

public class App {

    public static void main(String[] args) throws Exception {
        int[] array = { 5, 7, 1, 4, 6, 3, 2, 0 };
        BinaryEncoder encoder = new BinaryEncoder(array);
        int[] binaryEncoded = encoder.encode();
    }
}
