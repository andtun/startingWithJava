/**
 * All sorting algorithms have sort() method
 */
interface SortingAlg {
    void sort(int[] list);
}

/**
 * Timetracker tracks the time of execution of a sorting algorithm
 */
class TimeTracker implements SortingAlg{

    private SortingAlg alg;
    String name;
    double result;

    /**
     * init new Timetracker
     * @param alg   the algorithm to be tested
     * @param name  the name of the algorithm
     */
    public TimeTracker(SortingAlg alg, String name) {
        this.alg = alg;
        this.name = name;
    }

    /**
     * sorting decorator for all .sort() methods
     * Runs the method and checks its execution time
     * @param list  the list to be sorted
     */
    @Override
    public void sort(int[] list) {
        long start = System.nanoTime();
        alg.sort(list);
        long end = System.nanoTime();
        result = (end - start)/1000000000.0;

        System.out.print("Работа алгоритма " + name + " завершена за ");
        System.out.print(result);
        System.out.println(" секунд");
    }
}

public class RunDat extends TimeTracker{

    /**
     * init new Timetracker
     *
     * @param alg  the algorithm to be tested
     * @param name the name of the algorithm
     */
    public RunDat(SortingAlg alg, String name) {
        super(alg, name);
    }

    /**
     * Get the fastest algorithm out of the list given
     * @param trackers  array of the algorithms (SortingAlg elements)
     * @return  fastest algorithm (TimeTracker object)
      */
    static TimeTracker minResult(TimeTracker[] trackers) {
        double min = trackers[0].result;
        TimeTracker bestTracker = trackers[0];
        for (int i = 1; i < trackers.length; i++) {
            if (trackers[i].result < min) {
                min = trackers[i].result;
                bestTracker = trackers[i];
            }
        }
        return bestTracker;
    }

    public static void main (String[] args) {
        // get list size
        int n = Input.getPositiveInt("Введите целое число - размер массива.");
        // create a list
        int[] list = new int[n];
        // fill the list
        ArrayTools.fill_manually_or_random(list);

        // list of the algorithms
        TimeTracker[] algs = new TimeTracker[] {
                new TimeTracker(new Sort.quicksort(), "quicksort"),
                new TimeTracker(new Sort.bubblesort(), "bubblesort"),
                new TimeTracker(new Sort.StupidSort(), "stupidsort"),
                new TimeTracker(new Sort.PyramidSort(), "pyramidsort"),
        };

        for (TimeTracker track: algs) {
            track.sort(list);
        }

        System.out.println("--------------------------------");
        TimeTracker bestAlg = minResult(algs);
        System.out.print("Быстрее всех оказался алгоритм " + bestAlg.name);

    }
}
