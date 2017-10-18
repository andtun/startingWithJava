public abstract class TimeTracker implements SortingAlg{

    SortingAlg alg;

    public TimeTracker(SortingAlg alg) {
        this.alg = alg;
    }

    @Override
    public void sort(int[] list) {
        long start = System.nanoTime();
        alg.sort(list);
        long end = System.nanoTime();

        System.out.print("Работа алгоритма завершена за ");
        System.out.print((end - start)/3600000000.0);
        System.out.println(" секунд");
    }
}

public class run extends TimeTracker{
    public run(SortingAlg alg) {
        super(alg);
    }

    public static void main (String[] args) {
        SortingAlg quick = TimeTracker(Sort.quicksort);

    }
}


/*

public class TimeTracker {

    public static void main (String[] args) {
        List<Integer> l = new ArrayList<Integer>();\\
        long start = System.nanoTime();
        for (int i = -1000000; i < 1000000; i++) {
            l.add(i);
        }
        long end = System.nanoTime();
        System.out.println((end - start)/3600000000.0);
    }
}
*/
