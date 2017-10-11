/**
 * all methods that search arrays
 */
public class search {

    /**
     * binary search applied to a given array
     * @param list  the array you give
     * @param elem  the value you want to find
     * @return  index of the element found or -1
     */
    private static int binary(int[] list, int elem) {
        sort.quicksort.sort(list);
        System.out.print("Отсортированный массив: ");
        arrayTools.print(list);
        int b = 0;
        int e = list.length;

        while ((e - b) > 1) {
            int ind = (b+e)/2;
            if (elem != list[ind])
                if (elem > list[ind])
                    b = ind;
                else
                    e = ind;
            else
                return ind;
        }
        return -1;
    }

    /**
     * binary search with all the pretty stuff like prints & input class methods
     * @param list  the list in which we look for the element
     */
    public static void pretty_binary(int[] list) {
        int elem = input.getInt("Введите элемент, который надо найти");

        int res = binary(list, elem);
        if (res == -1)
            System.out.print(String.format("Элемент '%d' не найден", elem));
        else
            System.out.print(String.format("Элемент '%d' найден в отсортированном мотиве с индексом %d", elem, res));
    }

}
