package part1_bubblesort;

import java.util.Scanner;
import java.util.Arrays;

public class Part1BubbleSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // Part 1.2.1 Ask user for length
        System.out.println("This program does bubble sort for specific array.");
        boolean running = true;

        while (running) {
            System.out.println("Please, enter length of your array.");
            int length = in.nextInt();
            in.nextLine();
            // Part 1.2.2 Ask if user wants to generate values or input by himself/herself
            System.out.println("What operation would you like to do?");
            System.out.println("1. Sort random numbers");
            System.out.println("2. Sort input numbers");
            System.out.println("0. Exit");
            int operation = in.nextInt();
            in.nextLine();

            switch (operation) {
                case 1:
                    // Part 1.2.3 Creation of array
                    int[] randomarray = arrayWithRandomValues(length);
                    // Part 1.2.5 Sorting
                    int[] sortedarray = bubbleSort(randomarray);
                    // Part 1.2.4-1.2.6 Output of given and sorted array
                    printArray(randomarray, sortedarray);
                    // Part 1.2.7 Ask if we want to continue
                    running = askToContinue();
                    if (!running) {
                        System.out.println("Bye!");
                    }
                    break;
                case 2:
                    // Part 1.2.3 Creation of array
                    int[] array = arrayWithUserValues(length);
                    // Part 1.2.5 Sorting
                    int[] sorteduserarray = bubbleSort(array);
                    // Part 1.2.4-1.2.6 Output of given and sorted array
                    printArray(array, sorteduserarray);
                    // Part 1.2.7 Ask if we want to continue
                    running = askToContinue();
                    if (!running) {
                        System.out.println("Bye!");
                    }
                    break;
                case 0:
                    running = false;
                    System.out.println("Bye!");
                    break;
                    default:
                        System.out.println("Invalid input!");
            }
        }
    }
    // 1.1.2 Method for array with random values
    public static int[] arrayWithRandomValues(int length) {
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 90) + 10;
        }
        return array;
    }
    // 1.1.3 Method for array with user values
    public static int[] arrayWithUserValues(int length) {
        Scanner in = new Scanner(System.in);
        int[] array = new int[length];
        System.out.println("Enter elements of your array");

        for (int i = 0; i < array.length; i++) {
            System.out.println("Element " + i + ":");
            array[i] = in.nextInt();
        }
        return array;
    }
    // Part 1.1.4 Bubble sort method
    public static int[] bubbleSort(int[] array) {
        int[] sorted = Arrays.copyOf(array, array.length);

        for (int i = 0; i < sorted.length - 1; i++) {
            for (int j = 0; j < sorted.length - i - 1; j++) {
                if (sorted[j] > sorted[j + 1]) {
                    int temp = sorted[j];
                    sorted[j] = sorted[j + 1];
                    sorted[j + 1] = temp;
                }
            }
        }
        return sorted;
    }
    public static void printArray(int[] array, int[] sortedarray) {
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(sortedarray));
    }
    public static boolean askToContinue() {
        Scanner in = new Scanner(System.in);
        System.out.println("Would you like to continue?");
        String option = in.nextLine().trim();
        boolean repeatoption = option.trim().toLowerCase().contains("y");
        return repeatoption;
    }
}