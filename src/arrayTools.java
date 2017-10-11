import java.util.concurrent.ThreadLocalRandom;

/**
 * tools to work with arrays
 */
public class arrayTools {

    /**
     * generate a random int
     * @param range int a, so that all randomly generated values are in range +-a
     * @return  the randomly generated int
     */
    public static int random_int(int range) {
        range = Math.abs(range);
        int randomNum = ThreadLocalRandom.current().nextInt(-range, range + 1);
        return randomNum;
    }

    /**
     * methods to fill an array
     */
    public static class fill {

        /**
         * fill an array with random values
         * @param list  the array we wanna fill
         * @param range the range of randomness (see arrayTools.random_int())
         */
    public static void random(int[] list, int range) {
        for (int i = 0; i < list.length; i++) {
            list[i] = random_int(range);
        }
    }

        /**
         * fill an array with the values entered by user
         * @param list  the array we wanna fill
         */
    public static void from_input(int[] list) {
        System.out.println("Вводите массив из "+ list.length +" чисел");

        for (int i = 0; i < list.length; i++)
            list[i] = input.getInt("Введите "+ i +" элемент массива");
    }
    }

    /**
     * swap two elements of an array
     * @param list  the array we work with
     * @param ind1  index of one element
     * @param ind2  index of the other element
     */
    public static void int_swap(int[] list, int ind1, int ind2) {
        int t = list[ind1];
        list[ind1] = list[ind2];
        list[ind2] = t;
    }

    /**
     * fancy print an array
     * @param list  the array we wanna fancy-print
     */
    public static void print(int[] list) {
        for (int i: list) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }

    /**
     * ask whether to fill the array with random numbers or from input
     * then fill it using the fill class methods
     * @param list  the array to be filled
     */
    public static void fill_manually_or_random(int[] list) {
        Boolean use_random = input.getBool("Заполнить массив случайными числами");
        if (use_random) {
            fill.random(list, 1000);
            print(list);
        }
        else {
            fill.from_input(list);
        }
    }
}
