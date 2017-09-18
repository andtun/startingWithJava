import java.util.Scanner;

// python-like input
public class input {

    // universal text if what you entered is wrong
    public static String wrongInput = "Фигню ввели. Повторите ввод: ";


    // read a String from keyboard
    public static String getStr() {
        Scanner read = new Scanner(System.in);
        return read.nextLine();
    }


    // print some text, read a String from keyboard
    public static String getStr(String alert) {
        System.out.print(alert);
        return getStr();
    }


    // read an Int for keyboard
    public static int getInt() {
        Scanner read = new Scanner(System.in);
        if (read.hasNextInt()) return read.nextInt();
        else return getInt(wrongInput);
    }


    // print some text, read an Int for keyboard
    public static int getInt(String alert) {
        System.out.println(alert);
        return getInt();
    }

    // get a boolean value: 1 -- for true, 0 -- for false
    public static Boolean getBool() {
        int choice = getInt("0 for False, 1 for True");
        while ((choice != 0) && (choice != 1)) {
            choice = getInt(wrongInput);
        }
        return (choice == 1);
    }


    // print some text, get a Bool  value
    public static Boolean getBool(String alert) {
        System.out.println(alert);
        return getBool();
    }

    // read an int, check if it's positive
    public static int getPositiveInt(String alert) {
        int n = input.getInt(alert);
        while (n < 1) {
            n = input.getInt(input.wrongInput);
        }
        return n;
    }
}
