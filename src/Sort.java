import static java.lang.Math.abs;


/**
 * all sorting methods
 */
public class Sort {

    /**
     * quicksort algorithm
     */
    public static class quicksort implements SortingAlg {

        /**
         * call quicksort.Sort() in the main file to Sort an array with the quicksort algo
         * @param list  the array which needs to be sorted
         */

        @Override
        public void sort(int[] list) {
            int begin = 0;
            int end = list.length - 1;
            sort_step(begin, end, list);
            ArrayTools.print(list);
        }

        /**
         * one sorting step
         * @param begin the first element (index) of the sub-array we work on
         * @param end   the last element (index) of the sub-array we work on
         * @param list  the array itself
         */
        private static void sort_step(int begin, int end, int[] list) {
            //if loop not finished yet
            if (begin < end) {

                // assign the values to new variables so we can safely change them
                int b = begin;
                int e = end;

                // quick Sort base - the element we compare others with
                // may be chosen by random, but this one is considered to be the most efficient
                int base = b - (b - e) / 2;

                while (b < e) {
                    // kinda bubblesort element
                    while (b < base && (list[b] <= list[base])) {
                        b++;
                    }
                    while (e > base && (list[base] <= list[e])) {
                        e = e - 1;
                    }

                    // swap numbers, if the first one is bigger
                    if (b < e) {
                        ArrayTools.int_swap(list, b, e);

                        // start with a new base
                        if (b == base)
                            base = e;
                        else if (e == base)
                            base = b;
                    }
                }

                // Sort numbers smaller than base
                sort_step(begin, base, list);
                // Sort numbers bigger than base
                sort_step(base + 1, end, list);
            }
        }
    }

    /**
     * bubble Sort algorithm
     */
    public static class bubblesort implements SortingAlg {

        /**
         * call bubblesort.Sort() in the main file to Sort an array with the bubble Sort algo
         * @param list  the list which needs to be sorted
         */
        @Override
        public void sort(int[] list) {

            for(int i = list.length-1 ; i > 0 ; i--){
                for(int j = 0 ; j < i ; j++){
                if( list[j] > list[j+1] )
                    ArrayTools.int_swap(list, j, j+1);
                }
            }
        ArrayTools.print(list);
        }
    }


    /**
     * Stupid (or "monkey") sort - keep randomly mixing the array until it's sorted
     */
    public static class StupidSort implements SortingAlg {

        /**
         * Randomly shuffle array elements
         * @param list  the array to be shuffled
         */
        private static void mix (int[] list) {
            for (int i = 0; i < list.length; i++) {
                ArrayTools.int_swap(list, i, abs(ArrayTools.random_int(list.length - 1)));
            }
        }

        /**
         * Check if the array is sorted (straight)
         * @param list  the array to be checked
         * @return  true if sorted, else - false
         */
        private static boolean sorted(int[] list) {
            for (int i = 1; i < list.length; i++) {
                if (list[i-1] > list[i])
                        return false;
            }
            return true;
        }

        /**
         * Stupidly sort an array
         * @param list  the array to be sorted
         */

        @Override
        public void sort(int[] list) {
            while (!sorted(list))
                mix(list);
            ArrayTools.print(list);
        }

    }


    // TODO: comment the heapsort, test it

    /**
     * Convert the array to a heap, sort the heap
     */
    public static class PyramidSort implements SortingAlg {

        /**
         * Sort an array
         * @param list  the array to be sorted
         */
        @Override
        public void sort(int[] list) {

            for (int i = list.length / 2 - 1; i >= 0; i--)

                // convert the array to a heap
                shiftDown(list, i, list.length);

            for (int i = list.length - 1; i > 0; i--) {
                ArrayTools.int_swap(list, 0, i);
                shiftDown(list, 0, i);
            }

            ArrayTools.print(list);
        }

        private static void shiftDown(int[] a, int i, int n) {
            int child;
            int tmp;

            for (tmp = a[i]; leftChild(i) < n; i = child) {
                child = leftChild(i);
                if (child != n - 1 && (a[child] < a[child + 1]))
                    child++;
                if (tmp < a[child])
                    a[i] = a[child];
                else
                    break;
            }
            a[i] = tmp;
        }

        private static int leftChild(int i) {
            return 2 * i + 1;
        }


    }
}
