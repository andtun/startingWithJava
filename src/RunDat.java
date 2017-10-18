class TimeTracker implements SortingAlg{

    private SortingAlg alg;
    String name;
    double result;

    public TimeTracker(SortingAlg alg, String name) {
        this.alg = alg;
        this.name = name;
    }

    public TimeTracker(SortingAlg alg) {
    }

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
    public RunDat(SortingAlg alg) {
        super(alg);
    }

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
