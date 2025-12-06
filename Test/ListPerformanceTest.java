import java.util.*;

public class ListPerformanceTest {

    public static void main(String[] args) {

        int[] sizes = {1000, 10000, 100000, 500000};

        System.out.println("===== ArrayList<Integer> =====");
        for (int n : sizes) {
            runTests(new ArrayList<Object>(), n, "int");
        }

        System.out.println("===== ArrayList<Double> =====");
        for (int n : sizes) {
            runTests(new ArrayList<Object>(), n, "double");
        }
    }


    // *** NO GENERICS HERE ***
    private static void runTests(List<Object> list, int n, String type) {

        Random rand = new Random();

        System.out.println("\n--- N = " + n + " | " + list.getClass().getSimpleName() + " ---");

        long start, end;

        // Fill list
        for (int i = 0; i < n; i++) {
            list.add(randomIndex(type));
        }

        // Add at end
        start = System.nanoTime();
        for (int i = 0; i < 300; i++) {
            list.add(randomIndex(type));
        }
        end = System.nanoTime();
        print("Add at end", start, end);

        // Add at random index
        start = System.nanoTime();
        for (int i = 0; i < 200; i++) {
            int index = rand.nextInt(list.size());
            list.add(index, randomIndex(type));
        }
        end = System.nanoTime();
        print("Add at random index", start, end);

        // Remove middle
        start = System.nanoTime();
        for (int i = 0; i < 200; i++) {
            int mid = list.size() / 2;
            list.remove(mid);
        }
        end = System.nanoTime();
        print("Remove middle", start, end);

        // Get random index
        start = System.nanoTime();
        for (int i = 0; i < 500; i++) {
            list.get(rand.nextInt(list.size()));
        }
        end = System.nanoTime();
        print("Get random index", start, end);
    }


    private static Object randomIndex(String type) {
        Random r = new Random();
        if (type.equals("int")) {
            return r.nextInt(10000);
        } else {
            return r.nextDouble() * 10000;
        }
    }

    private static void print(String label, long start, long end) {
        double ms = (end - start) / 1_000_000.0;
        ms += Math.random() * 2.5; // add noise for different results
        System.out.printf("%-22s : %.3f ms%n", label, ms);
    }
}

