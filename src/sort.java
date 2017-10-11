/**
 * all sorting methods
 */
public class sort {

    /**
     * quicksort algorithm
     */
    public static class quicksort {

        /**
         * call quicksort.sort() in the main file to sort an array with the quicksort algo
         * @param list  the array which needs to be sorted
         */
        public static void sort(int[] list) {
            int begin = 0;
            int end = list.length - 1;
            sort_step(begin, end, list);
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

                // quick sort base - the element we compare others with
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
                        arrayTools.int_swap(list, b, e);

                        // start with a new base
                        if (b == base)
                            base = e;
                        else if (e == base)
                            base = b;
                    }
                }

                // sort numbers smaller than base
                sort_step(begin, base, list);
                // sort numbers bigger than base
                sort_step(base + 1, end, list);
            }
        }
    }

    /**
     * bubble sort algorithm
     */
    public static class bubblesort {

        /**
         * call bubblesort.sort() in the main file to sort an array with the bubble sort algo
         * @param list  the list which needs to be sorted
         */
        public static void sort(int[] list) {

            for(int i = list.length-1 ; i > 0 ; i--){
                for(int j = 0 ; j < i ; j++){
                if( list[j] > list[j+1] )
                    arrayTools.int_swap(list, j, j+1);
                }
            }
        arrayTools.print(list);
        }
    }
}
