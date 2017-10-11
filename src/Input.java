import java.util.Scanner;

/**
 * python-like Input
 */
public class Input {

    /**
     * universal text if what you entered is wrong
     */
    public static String wrongInput = "Фигню ввели. Повторите ввод: ";


    /**
     * get a string from keyboard
     * @return  String the user entered
     */
    public static String getStr() {
        Scanner read = new Scanner(System.in);
        return read.nextLine();
    }


    /**
     * print some text, read a String from keyboard
     * @param alert what you want to print before reading
     * @return  String the user entered
     */
    public static String getStr(String alert) {
        System.out.print(alert);
        return getStr();
    }


    /**
     * read an Int for keyboard
     * @return  int the user entered
     */
    public static int getInt() {
        Scanner read = new Scanner(System.in);
        if (read.hasNextInt()) return read.nextInt();
        else return getInt(wrongInput);
    }


    /**
     * Same as getInt()
     * @param alert what you want to print before reading
     * @return  int the user entered
     */
    public static int getInt(String alert) {
        System.out.println(alert);
        return getInt();
    }

    /**
     * read a boolean value from keyboard
     * 1 is for true, 0 - for false
     * no other values accepted
     * @return  true if the user entered '1', false if the user entered '0'
     */
    public static Boolean getBool() {
        int choice = getInt("0 for False, 1 for True");
        while ((choice != 0) && (choice != 1)) {
            choice = getInt(wrongInput);
        }
        return (choice == 1);
    }


    /**
     * see getBool, but alerts a string before reading
     * @param alert what to alert
     * @return  true or false (Bool values)
     */
    public static Boolean getBool(String alert) {
        System.out.println(alert);
        return getBool();
    }

    /**
     * read a positive int from keyboard
     * @param alert alerts a string
     * @return  a positive int
     */
    public static int getPositiveInt(String alert) {
        int n = Input.getInt(alert);
        while (n < 1) {
            n = Input.getInt(Input.wrongInput);
        }
        return n;
    }
}
