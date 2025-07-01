package dsa;

import java.util.ArrayList;
import java.util.List;

/**
 * The Sorter class provides various sorting algorithms for sorting a list in ascending order.
 */
public class Sorter {

    /**
     * For best performance use Array-like lists like ArrayList.
     * Basic SelectionSort that sorts a list in ascending order.
     * Best case complexity of O(n).
     * Average case complexity of O(n²).
     * Worst case complexity of O(n²).
     * Unstable.
     * @param list List to be sorted
     * @param <T> type of list element
     */
    public static <T extends Comparable<T>> void selectionSort(List<T> list) {
        if (list == null || list.isEmpty()) {
            System.out.println("List is empty or null");
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            int minElement = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).compareTo(list.get(minElement)) < 0) {
                    minElement = j;
                }
            }
            swap(list, i, minElement);

        }
    }

    /**
     * For best performance use Array-like lists like ArrayList.
     * Basic InsertionSort that sorts a list in ascending order.
     * Best case complexity of O(n).
     * Average case complexity of O(n²).
     * Worst case complexity of O(n²).
     * Stable.
     * @param list List to be sorted
     * @param <T> type of list element
     */
    public static <T extends Comparable<T>> void insertionSort(List<T> list) {
        if (list == null || list.isEmpty()) {
            System.out.println("List is empty or null");
            return;
        }

        for (int i = 1; i < list.size(); i++) {
            T currentElement = list.get(i);
            for (int j = i - 1; j >= 0 && list.get(j).compareTo(currentElement) > 0; j--) {
                swap(list, j + 1, j);
            }
        }
    }

    /**
     * For best performance use Array-like lists like ArrayList.
     * Basic BubbleSort that sorts a list in ascending order.
     * Best case complexity of O(n).
     * Average case complexity of O(n²).
     * Worst case complexity of O(n²).
     * Stable.
     * @param list List to be sorted
     * @param <T> type of list element
     */
    public static <T extends Comparable<T>> void bubbleSort(List<T> list) {
        if (list == null || list.isEmpty()) {
            System.out.println("List is empty or null");
            return;
        }

        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = list.size() - 1; j > i; j--) {
                if (list.get(j).compareTo(list.get(j - 1)) < 0) {
                    swap(list, j, j - 1);
                }
            }
        }
    }

    /**
     * For best performance use Array-like lists like ArrayList.
     * Basic MergeSort algorithm that recursively sorts a list in ascending order by using divide and conquer.
     * Best case complexity of O(nlog(n)).
     * Average case complexity of O(nlog(n)).
     * Worst case complexity of O(nlog(n)).
     * Stable.
     * @param list List to be sorted
     * @param <T> type of list element
     */
    public static <T extends Comparable<T>> void mergeSort(List<T> list) {
        if (list == null || list.isEmpty()) {
            System.out.println("List is empty or null");
            return;
        }

        int middle = list.size() / 2;
        List<T> left = new ArrayList<>(list.subList(0, middle));
        List<T> right = new ArrayList<>(list.subList(middle, list.size()));

        mergeSort(left);
        mergeSort(right);
        merge(list, left, right);
    }

    /**
     * For best performance use Array-like lists like ArrayList.
     * Basic QuickSort algorithm that sorts a list in ascending order.
     * Best case complexity of O(nlog(n)).
     * Average case complexity of O(nlog(n)).
     * Worst case complexity of O(n²).
     * Instable.
     * @param list List to be sorted
     * @param <T> type of list element
     */
    public static <T extends Comparable<T>> void quickSort(List<T> list) {
        if (list == null || list.isEmpty()) {
            System.out.println("List is empty or null");
            return;
        }

        quickSortHelper(list, 0, list.size() - 1);
    }

    // recursive helper method for quickSort
    private static <T extends Comparable<T>> void quickSortHelper(List<T> list, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(list, low, high);
            quickSortHelper(list, low, pivotIndex - 1);
            quickSortHelper(list, pivotIndex + 1, high);
        }
    }

    // helper method for quickSort
    private static <T extends Comparable<T>> int partition(List<T> list, int low, int high) {
        T pivot = list.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (list.get(j).compareTo(pivot) <= 0) {
                i++;
                swap(list, i, j);
            }
        }

        swap(list, i + 1, high);
        return i + 1;
    }

    // helper method for mergeSort
    private static <T extends Comparable<T>> void merge(List<T> result, List<T> left, List<T> right) {
        int i = 0, j = 0, k = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).compareTo(right.get(j)) <= 0) {
                result.set(k++, left.get(i++));
            } else {
                result.set(k++, right.get(j++));
            }
        }

        while (i < left.size()) {
            result.set(k++, left.get(i++));
        }

        while (j < right.size()) {
            result.set(k++, right.get(j++));
        }
    }

    // helper method for swapping two elements in a list
    private static <T> void swap(List<T> list, int i, int j) {
        T tmp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, tmp);
    }

}
