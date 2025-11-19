

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();




        long startTime = System.nanoTime();
        //adding 100
        for(int i = 0; i < 1000; i++) {
            list.add(i);
        }

        //deleting 100
        for(int i = 0; i < 1000; i++) {
            list.remove(list.size() - 1);
        }
        long endTime = System.nanoTime();
        System.out.println("Time 1000: " + (double) (endTime - startTime) / 1_000_000_000.0);



        startTime = System.nanoTime();
        //adding 10000
        for(int i = 0; i < 10000; i++) {
            list.add(i);
        }

        //deleting 10000
        for(int i = 0; i < 10000; i++) {
            list.remove(list.size() - 1);
        }
        endTime = System.nanoTime();
        System.out.println("Time 10000: " + (double) (endTime - startTime) / 1_000_000_000.0);



        startTime = System.nanoTime();
        //adding 500000
        for(long i = 0; i < 100000; i++) {
            list.add((int) i);
        }

        //deleting 500000
        for(long i = 0; i < 100000; i++) {
            list.remove(list.size() - 1);
        }
        endTime = System.nanoTime();
        System.out.println("Time 100000: " + (double) (endTime - startTime) / 1_000_000_000.0);

        System.out.println("end");
    }
}
