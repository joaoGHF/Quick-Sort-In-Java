package org.quicksort;

public class QuickSort {
    public static void main(String[] args) throws Exception {
        final int quantity = 100;
        int[] array = new int[quantity];

        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * quantity);
        }

        for (int i : array) {
            System.out.print(i + "  ");
        }

        System.out.println("\n\n");

        long time_init = System.currentTimeMillis();

        quickSort(array, 0, array.length - 1);

        long time_term = System.currentTimeMillis();

        for (int i : array) {
            System.out.print(i + "  ");
        }

        System.out.println("\n\n");

        System.out.println("Sorting time: " + (time_term - time_init) + "ms");
    }

    public static void quickSort(int[] array, int init, int fin) {
        if (init < fin) {
            int positionPivot = separate(array, init, fin);
            quickSort(array, init, positionPivot - 1);
            quickSort(array, positionPivot + 1, fin);
        }
    }

    public static int separate(int[] array, int init, int fin) {
        int pivot = array[init];
        int i = init + 1;
        int f = fin;
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
