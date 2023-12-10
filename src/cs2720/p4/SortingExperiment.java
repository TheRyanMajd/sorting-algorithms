package cs2720.p4;

import java.util.Random;
import java.util.Scanner;

public class SortingExperiment {

    public static void main(String[] args) {
        // Define the input sizes
        System.out.println("Choose an input size (int): ");
        Scanner scan = new Scanner(System.in);
        int userSize = scan.nextInt();
        int[] inputSizes = { 100, 500, 1000, 5000, 10000, 20000, 25000, 30000, userSize };

        // Print header for the table
        System.out.println("Size of input\tSelection\tMerge\t\tHeap\tQuickSort-fp\tQuickSort-rp");

        // Run experiments for each input size
        for (int size : inputSizes) {
            // System.out.print(size + "\t");

            // Run each algorithm multiple times and take the average
            long selectionComparisons = runAlgorithmMultipleTimes("selectionSort", size);
            long mergeComparisons = runAlgorithmMultipleTimes("mergeSort", size);
            long heapComparisons = runAlgorithmMultipleTimes("heapSort", size);
            long quickSortFpComparisons = runAlgorithmMultipleTimes("quickSortFP", size);
            long quickSortRpComparisons = runAlgorithmMultipleTimes("quickSortRP", size);

            // Print the number of comparisons for each algorithm
            System.out.println(size + "\t(sel)" + selectionComparisons + "\t(mergeComp)" + mergeComparisons
                    + "\t\t(heap)" +
                    heapComparisons + "\t(qsFP)" + quickSortFpComparisons + "\t(qsRP)" + quickSortRpComparisons);
        }
        scan.close();
    }

    // Function to run an algorithm multiple times and return the average number of
    // comparisons
    private static long runAlgorithmMultipleTimes(String algorithmName, int size) {
        long totalComparisons = 0;
        int numberOfRuns = 5; // You can adjust this number based on your preference

        for (int i = 0; i < numberOfRuns; i++) {
            // Generate random input array
            int[] array = generateRandomArray(size);

            // Prompt user for sorting algorithm
            Sorting sorting = new Sorting();

            // Apply the chosen sorting algorithm
            switch (algorithmName) {
                case "selectionSort":
                    sorting.selectionSort(array);
                    totalComparisons += sorting.getNumComparisons();
                    break;
                case "mergeSort":
                    sorting.mergeSort(array);
                    totalComparisons += sorting.getNumComparisons();
                    break;
                case "heapSort":
                    sorting.heapSort(array);
                    totalComparisons += sorting.getNumComparisons();
                    break;
                case "quickSortFP":
                    sorting.quickSortFP(array);
                    totalComparisons += sorting.getNumComparisons();
                    break;
                case "quickSortRP":
                    sorting.quickSortRP(array);
                    totalComparisons += sorting.getNumComparisons();
                    break;
                default:
                    System.out.println("Invalid choice. Exiting.");
                    System.exit(1);
            }
        }

        // Calculate the average number of comparisons
        return totalComparisons / numberOfRuns;
    }

    // Function to generate a random array of a given size
    private static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(10_000); // You can adjust the range of random values
        }

        return array;
    }
}
