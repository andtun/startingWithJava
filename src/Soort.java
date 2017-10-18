import java.util.ArrayList;
import java.util.List;

interface ISort {
List <Integer> sort(List <Integer> arg);
}

public class Soort implements ISort {

    public static void main (String[] args) {
        ISort bubble = new Soort();
        ISort newsort = new NewSort();

        List <Integer> kudah = new ArrayList<Integer>();
        System.out.println(bubble.sort(kudah));
    }


    @Override
    public List<Integer> sort(List<Integer> arg) {
        return new ArrayList<Integer>(){
            {
                add(1);
            }
        };
    }
}

class NewSort implements ISort {

    void smth() {

    }

    @Override
    public List<Integer> sort(List<Integer> arg) {
        return new ArrayList<Integer>() {
            {
                add(1);
            }
        };
    }
}
