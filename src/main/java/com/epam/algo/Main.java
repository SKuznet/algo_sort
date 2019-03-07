package com.epam.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static int[] inputArray;
    private static int[] helperArray;

    public static void main(String[] args) {
        String varNumbers = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            varNumbers = reader.readLine().replaceAll("\\s+", "");
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        if (varNumbers == null) {
            throw new IllegalArgumentException("please add some digits");
        }

        String[] stringsArray = varNumbers.split(",");
        inputArray = new int[stringsArray.length];
        helperArray = new int[stringsArray.length];

        try {
            for (int i = 0; i < stringsArray.length; i++) {
                inputArray[i] = Integer.parseInt(stringsArray[i]);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        Main main = new Main();

        // bubbleSort
//        System.out.println(Arrays.toString(main.bubbleSortArray(inputArray)));
        mergeSort(0, inputArray.length -1);
        System.out.println(Arrays.toString(inputArray));
    }

    public void sort(int[] inputArray) {
        Main.inputArray = inputArray;
        Main.helperArray = new int[inputArray.length];
        mergeSort(0, inputArray.length -1);
    }

    private static void mergeSort(int lowerBoundary, int higherBoundary) {
        if(lowerBoundary < higherBoundary) {
            int middleBoundary = lowerBoundary + (higherBoundary - lowerBoundary) / 2;
            mergeSort(lowerBoundary, middleBoundary);
            mergeSort(middleBoundary + 1, higherBoundary);
            merge(lowerBoundary, middleBoundary, higherBoundary);
        }
    }

    private static void merge(int lowerBoundary, int middleBoundary, int higherBoundary) {
        for (int i = lowerBoundary; i <= higherBoundary ; i++) {
            helperArray[i] = inputArray[i];
        }

        int i = lowerBoundary;
        int j = middleBoundary + 1;
        int k = lowerBoundary;

        while (i <= middleBoundary && j <= higherBoundary) {
            if (helperArray[i] <= helperArray[j]) {
                inputArray[k] = helperArray[i];
                i++;
            } else {
                inputArray[k] = helperArray[j];
                j++;
            }
            k++;
        }

        while (i <= middleBoundary) {
            inputArray[k] = helperArray[i];
            k++;
            i++;
        }
    }

    private int[] bubbleSortArray(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
}
