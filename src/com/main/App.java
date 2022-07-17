package com.main;

import java.util.List;

public class App {

    public static void main(String[] args) throws Exception {
        int[] array = { 5, 7, 1, 4, 6, 3, 2, 0 };
        BinaryEncoder encoder = new BinaryEncoder(array);
        List<String> binaryEncoded = encoder.encode();
        System.out.println(binaryEncoded);
        EliminationCompression compressor = new EliminationCompression(array);
        compressor.compress();
    }
}
