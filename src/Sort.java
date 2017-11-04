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

    public static class CountingSort implements SortingAlg{
        public void sort(int [] array) {
            int size = array.length;
            // Biggest number in the [array] used to create temporary
            int maximum = -Utility.INF;
            // Smallest number in [array] used as shift in ids' to save memory
            int shift = Utility.INF;

            for (int i = 0; i < size; ++i){
                if (array[i] > maximum){
                    maximum = array[i];
                }
                if (array[i] < shift){
                    shift = array[i];
                }
            }
            // Size of [temporary] including [shift] and +1
            Integer temporarySize = maximum + 1 - shift;

            // Stores amount of each number in [array]
            Integer [] temporary = new Integer [temporarySize];
            // Fills [temporary] with 0
            for (int number = 0; number < temporarySize; ++number){
                temporary[number] = 0;
            }
            // Fills [temporary] from [array]
            for (int i = 0; i < size; ++i){
                temporary[array[i] - shift] += 1;
            }

            // Index of next not yet updated field in [array]
            int index = 0;
            // Refills [array] using [temporary]
            for (int number = 0; number < temporarySize; ++number){
                if (temporary[number] > 0){
                    for (int i = 0; i < temporary[number]; ++i, ++index){
                        array[index] = number + shift;
                    }
                }
            }
        }
    }

    public static class SelectionSort implements SortingAlg{
        public void sort(int [] array) {
            int size = array.length;
            // Smallest number in the tail of [array], which will be swapped next
            int minimum;
            int minimumId;

            for (int i = 0; i < size - 1; ++i){
                minimum = Utility.INF;
                minimumId = -1;
                for (int j = i; j < size; ++j){
                    if (array[j] < minimum){
                        minimum = array[j];
                        minimumId = j;
                    }
                }
                Utility.swap(array, i, minimumId);
            }
        }
    }

    public static class CombSort implements SortingAlg{
        public void sort(int [] array) {
            int size = array.length;
            // Counts amount of swaps on every loop to check if [array] is already sorted
            boolean swapped = true;

            for (int delta = size; (delta > 1 || swapped);) {
                if (delta > 1)
                    delta = (int)(delta / 1.247);
                swapped = false;
                // Goes through [array] and swaps every two nearby elements, if they're in wrong order
                for (int j = 0; j + delta < size; ++j) {
                    if (array[j] > array[j + delta]) {
                        Utility.swap(array, j, j + delta);
                        swapped = true;
                    }
                }
            }
        }
    }

    public static class InsertionSort implements SortingAlg{
        public void sort(int [] array) {
            int size = array.length;
            int trash, j;

            for (int i = 1; i < size; ++i){
                trash = array[i];
                for (j = i; j > 0 && array[j - 1] > trash; --j){
                    array[j] = array[j - 1];
                }
                array[j] = trash;
            }
        }

    }

    public static class GnomeSortYulia implements SortingAlg {
        public void sort(int [] list) {
            for (int i = 1; i < list.length; i++) {
                while ((i > 0) && (list[i] < list[i - 1])) {
                    Utility.swap(list, i, i - 1);
                    i = i - 1;
                }
            }
        }
    }

    public static class InsertionSortYulia implements SortingAlg {
        public void sort(int[] list) {
            for (int i = 0; i < list.length; i++) {
                Integer elem = list[i];
                int j = i;
                while (j > 0 && elem < list[j - 1]) {
                    list[j] = list[j - 1];
                    --j;
                }
                list[j] = elem;
            }
        }
    }

    public static class SelectionSortYulia implements SortingAlg {
        public void sort(int[] list) {
            for (int i = 0; i < list.length - 1; i++) {
                Integer indexmin = i;
                for (int j = i + 1; j < list.length; j++) {
                    if (list[j] < list[indexmin]) {
                        indexmin = j;
                    }
                }
                Utility.swap(list, i, indexmin);
            }
        }
    }

    public static class CombSortYulia implements SortingAlg {
        public void sort(int[] list) {
            Integer gap = list.length;
            double factor = 1.247;
            while (gap > 1) {
                gap = (int) (gap / factor);
                for (int i = 0; i < list.length - gap; i++) {
                    if (list[i + gap] < list[i]) {
                        Utility.swap(list, i, i + gap);
                    }
                }
            }
        }
    }

}
