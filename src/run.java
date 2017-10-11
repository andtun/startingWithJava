/**
 * the file we run to make the whole thing work
 */
public class run {

    /**
     * the main method (runs the whole thing)
     * @param args  u know the param :)
     */
    public static void main(String[] args) {

        // get list size
        int n = input.getPositiveInt("Введите целое число - размер массива.");
        // create a list
        int[] list = new int[n];
        // fill the list
        arrayTools.fill_manually_or_random(list);

        // get what to do
        int option = input.getInt("Введите 1 для quicksort, 2 - для поиска, 3 - for bubblesort");
        switch (option) {

            // quicksort
            case 1:
                sort.quicksort.sort(list);
                arrayTools.print(list);
                break;

            // binary search
            case 2:
                search.pretty_binary(list);
                break;

            // bubble sort
            case 3:
                sort.bubblesort.sort(list);
                break;

            // if the option is wrong
            default:
                System.out.println("Фигню ввели. Программа завершает работу.");
        }

    }
}
