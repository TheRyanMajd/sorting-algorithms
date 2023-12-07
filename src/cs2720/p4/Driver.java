package cs2720.p4;

import java.io.*;
import java.util.*;

public class Driver {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java cs2720.p4.Driver <input_filename>");
            System.exit(1);
        }

        String filename = args[0];

        try {
            // Read integers from the file
            int[] array = readIntegersFromFile(filename);

            // Prompt user for sorting algorithm
            Scanner scanner = new Scanner(System.in);
            System.out.println("selection-sort (s) merge-sort (m) heap-sort (h) quick-sort-fp (q) quick-sort-rp (r)");
            System.out.print("Enter the algorithm: ");
            char choice = scanner.next().charAt(0);

            // Apply the chosen sorting algorithm
            Sorting sorting = new Sorting();

            switch (choice) {
                case 's':
                    sorting.selectionSort(array);
		    System.out.println("#Selection-sort comparisons: " + sorting.getNumComparisons());
		    break;
                case 'm':
                    sorting.mergeSort(array);
		    System.out.println("#Merge-sort comparisons: " + sorting.getNumComparisons());
		    break;
                case 'h':
                    sorting.heapSort(array);
		    System.out.println("#Heap-sort comparisons: " + sorting.getNumComparisons());
		    break;
                case 'q':
                    sorting.quickSortFP(array);
		    System.out.println("#Quick-sort-fp comparisons: " + sorting.getNumComparisons());
                    break;
                case 'r':
                    sorting.quickSortRP(array);
		    System.out.println("#Quick-sort-rp comparisons: " + sorting.getNumComparisons());
                    break;
                default:
                    System.out.println("Invalid choice. Exiting.");
                    System.exit(1);
            }
	    /*
            // Print the sorted array
            System.out.println("Sorted array:");
            for (int num : array) {
                System.out.print(num + " ");
            }
	    */
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid character.");
        }
    }

    private static int[] readIntegersFromFile(String filename) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new File(filename));
        List<Integer> integerList = new ArrayList<>();

        while (fileScanner.hasNext()) {
            if (fileScanner.hasNextInt()) {
                integerList.add(fileScanner.nextInt());
            } else {
                fileScanner.next(); // Skip non-integer tokens
            }
        }

        fileScanner.close();

        // Convert list to array
        int[] array = new int[integerList.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = integerList.get(i);
        }

        return array;
    }
}
