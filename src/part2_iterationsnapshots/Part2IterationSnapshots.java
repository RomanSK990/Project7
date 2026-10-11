package part2_iterationsnapshots;

import java.util.Scanner;
import java.util.Arrays;

public class Part2IterationSnapshots {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("This program does bubble sort for specific array.");
        boolean running = true;

        while (running) {
            System.out.println("What operation would you like to do?");
            System.out.println("1. Sort random 5 numbers and iterate it");
            System.out.println("2. Sort input numbers");
            System.out.println("0. Exit");
            int operation = in.nextInt();
            in.nextLine();

            switch (operation) {
                case 1:
                    int[] randomarray = arrayWithRandomValues();
                    int[] sortedarray = bubbleSort(randomarray);
                    generateAssignmentSnapshots(randomarray);
                    printArray(randomarray, sortedarray);
                    break;
                case 2:
                    int[] array = arrayWithUserValues();
                    int[] sorteduserarray = bubbleSort(array);
                    printArray(array, sorteduserarray);
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
    public static int[] arrayWithRandomValues() {
        int length = 5;
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 90) + 10;
        }
        return array;
    }
    public static int[] arrayWithUserValues() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter length of your array");
        int length = in.nextInt();
        in.nextLine();
        int[] array = new int[length];
        System.out.println("Enter elements of your array");

        for (int i = 0; i < array.length; i++) {
            System.out.println("Element " + i + ":");
            array[i] = in.nextInt();
        }
        return array;
    }
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

        System.out.println(Arrays.toString(sortedarray));
    }
    public static void generateAssignmentSnapshots(int[] randomarray) {

        System.out.println("Initial array:");
        printFormattedArray(randomarray, -1, -1);
        System.out.println();

        for (int i = 0; i < randomarray.length - 1; i++) {
            System.out.println("Outer loop, iteration " + (i + 1) + ":");
            printFormattedArray(randomarray, -1, -1);
            System.out.println("Inner loop:");

            for (int j = 0; j < randomarray.length - i - 1; j++) {
                boolean swapped = false;
                if (randomarray[j] > randomarray[j + 1]) {
                    int temp = randomarray[j];
                    randomarray[j] = randomarray[j + 1];
                    randomarray[j + 1] = temp;
                    swapped = true;
                }

                System.out.print("iteration " + (j + 1) + ":  ");
                if (swapped) {
                    printFormattedArray(randomarray, j, j + 1);
                } else {
                    printFormattedArray(randomarray, -1, -1);
                }
            }
            System.out.println();
        }
    }

    public static void printFormattedArray(int[] array, int swapped1, int swapped2) {
        for (int k = 0; k < array.length; k++) {
            if (k == swapped1 || k == swapped2) {
                System.out.print("**" + array[k] + "**  ");
            }
            else {
                System.out.print(array[k] + "  ");
            }
        }
        System.out.println();
    }
}