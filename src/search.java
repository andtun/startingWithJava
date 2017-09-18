
public class search {

    public static int binary(int[] list, int elem) {
        sort.quicksort.sort(list);
        System.out.print("Отсортированный массив: ");
        arrayTools.print(list);
        int b = 0;
        int e = list.length;

        //System.out.println(b);
        //System.out.println(e);
        while ((e - b) > 1) {
            //System.out.println(b);
            //System.out.println(e);
            //System.out.println("---");
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

    public static void pretty_binary(int[] list) {
        int elem = input.getInt("Введите элемент, который надо найти");

        int res = binary(list, elem);
        if (res == -1)
            System.out.print(String.format("Элемент '%d' не найден", elem));
        else
            System.out.print(String.format("Элемент '%d' найден в отсортированном мотиве с индексом %d", elem, res));
    }

}
