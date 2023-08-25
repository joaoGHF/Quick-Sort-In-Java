package org.quicksort;

/**
 * <p>
 * The {@code QuickSort} class has the private method {@code separate()}, the
 * public method {@code quickSort()} and the {@code main} method.
 * Sort an array of integers using the sort algorithm {@code Quick Sort}.
 * </p>
 */
public class QuickSort {
    /**
     * <p>
     * The main method create and initialize an array of integer with random values,
     * print your content before and after the sorting, sort the array and finnaly
     * print the sorting time in ms.
     * </p>
     * 
     * @param args are not used in this program
     */
    public static void main(String[] args) {
        final int quantity = 10;
        int[] array = new int[quantity];

        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * quantity);
        }

        System.out.println("Ramdom array:");
        for (int i : array) {
            System.out.print(i + "  ");
        }

        System.out.println("\n\n");

        long timeInit = System.currentTimeMillis();

        quickSort(array, 0, array.length - 1);

        long timeTerm = System.currentTimeMillis();

        System.out.println("Sorted array");
        for (int i : array) {
            System.out.print(i + "  ");
        }

        System.out.println("\n\n");

        System.out.println("Sorting time: " + (timeTerm - timeInit) + "ms");
    }

    /**
     * <p>
     * Method resposable to recursively sort the array internaly until all elements
     * are sorted.
     * </p>
     * 
     * @param array an array of type integer to be sorted
     * @param init  the init of the sorting
     * @param end   the end of the sorting
     */
    public static void quickSort(int[] array, int init, int end) {
        if (init < end) {
            int positionPivot = separate(array, init, end);
            quickSort(array, init, positionPivot - 1);
            quickSort(array, positionPivot + 1, end);

        }
    }

    /**
     * <p>
     * In the process of separating lists, this method is performed until it returns
     * a pivot (the divisible element between the two lists).
     * </p>
     * 
     * @param array an array of type integer to be sorted
     * @param init the init of separating
     * @param end the end of separating
     * @return the pivot of type {@code int}
     */
    private static int separate(int[] array, int init, int end) {
        int pivot = array[init];
        int i = init + 1;
        int f = end;
        while (i <= f) {
            if (array[i] <= pivot) {
                i++;
            } else if (pivot < array[f]) {
                f--;
            } else {
                int swap = array[i];
                array[i] = array[f];
                array[f] = swap;
                i++;
                f--;
            }
        }

        array[init] = array[f];
        array[f] = pivot;
        return f;
    }
}
