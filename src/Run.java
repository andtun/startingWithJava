/**
 * the file we Run to make the whole thing work
 */
public class Run {

    /**
     * the main method (runs the whole thing)
     * @param args  u know the param :)
     */
    public static void main(String[] args) {

        // get list size
        int n = Input.getPositiveInt("Введите целое число - размер массива.");
        // create a list
        int[] list = new int[n];
        // fill the list
        ArrayTools.fill_manually_or_random(list);

        // get what to do
        int option = Input.getInt("Введите 1 для quicksort, 2 - для поиска, 3 - for bubblesort, 4 - for stupid sort, 5 - for heap");
        switch (option) {

            // quicksort
            case 1:
                Sort.quicksort.sort(list);
                ArrayTools.print(list);
                break;

            // binary Search
            case 2:
                Search.pretty_binary(list);
                break;

            // bubble Sort
            case 3:
                Sort.bubblesort.sort(list);
                break;

            // stupid Sort
            case 4:
                Sort.StupidSort.sort(list);
                break;

            case 5:
                Sort.PyramidSort.sort(list);
                break;

            // if the option is wrong
            default:
                System.out.println("Фигню ввели. Программа завершает работу.");
        }

    }
}
