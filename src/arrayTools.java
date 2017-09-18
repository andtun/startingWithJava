import java.util.concurrent.ThreadLocalRandom;

// jus' to work with arrays
public class arrayTools {

    // generate a random int
    public static int random_int(int range) {
        range = Math.abs(range);
        int randomNum = ThreadLocalRandom.current().nextInt(-range, range + 1);
        return randomNum;
    }

    public static class fill {

    // fill.random -- fill an array with random values
    public static void random(int[] list, int range) {
        for (int i = 0; i < list.length; i++) {
            list[i] = random_int(range);
        }
    }

    // fill.from_input -- fill an array with provided values
    public static void from_input(int[] list) {
        System.out.println("Вводите массив из "+ list.length +" чисел");

        for (int i = 0; i < list.length; i++)
            list[i] = input.getInt("Введите "+ i +" элемент массива");
    }
    }

    public static void int_swap(int[] list, int ind1, int ind2) {
        int t = list[ind1];
        list[ind1] = list[ind2];
        list[ind2] = t;
    }

    // fancy printing a list
    public static void print(int[] list) {
        for (int i: list) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }

    // ask how to fill an array
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
