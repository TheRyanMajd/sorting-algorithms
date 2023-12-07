package cs2720.p4;

import java.util.Random;

public class Sorting {

    public long numComparisons;

    public long getNumComparisons() {
	return this.numComparisons;
    }
    
    public void selectionSort(int[] array) {
	numComparisons = 0;
	int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
		    numComparisons += 1;
		}
            }

            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    public void mergeSort(int[] array) {
        mergeSortHelper(array, 0, array.length - 1);
    }

    private void mergeSortHelper(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSortHelper(array, left, mid);
            mergeSortHelper(array, mid + 1, right);

            merge(array, left, mid, right);
        }
    }

    private void merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = array[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
		numComparisons += 1;
	    } else {
                array[k] = rightArray[j];
                j++;
		numComparisons += 1;
            }
            k++;
        }

        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public void heapSort(int[] array) {
        int n = array.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0);
        }
    }

    private void heapify(int[] array, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && array[left] > array[largest]) {
            largest = left;
	    numComparisons += 1;
        }

        if (right < n && array[right] > array[largest]) {
            largest = right;
	    numComparisons += 1;
        }

        if (largest != i) {
	    numComparisons += 1;
	    int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            heapify(array, n, largest);
        }
    }

    public void quickSortFP(int[] array) {
        quickSortFPHelper(array, 0, array.length - 1);
    }

    private void quickSortFPHelper(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partitionFP(array, low, high);

            quickSortFPHelper(array, low, pivotIndex - 1);
            quickSortFPHelper(array, pivotIndex + 1, high);
        }
    }

    private int partitionFP(int[] array, int low, int high) {
        int pivot = array[low];
        int i = low + 1;

        for (int j = low + 1; j <= high; j++) {
            if (array[j] < pivot) {
		numComparisons += 1;
		int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
            }
        }

        int temp = array[i - 1];
        array[i - 1] = array[low];
        array[low] = temp;

        return i - 1;
    }

    public void quickSortRP(int[] array) {
        quickSortRPHelper(array, 0, array.length - 1);
    }

    private void quickSortRPHelper(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partitionRP(array, low, high);

            quickSortRPHelper(array, low, pivotIndex - 1);
            quickSortRPHelper(array, pivotIndex + 1, high);
        }
    }

    private int partitionRP(int[] array, int low, int high) {
        // Generate a random pivot index
        Random random = new Random();
        int pivotIndex = low + random.nextInt(high - low + 1);

        // Swap the pivot element with the last element
        int temp = array[pivotIndex];
        array[pivotIndex] = array[high];
        array[high] = temp;

        return partitionFP(array, low, high);
    }
} // sorting
