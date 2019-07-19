package four_threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App {

    private Random random = new Random();
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();
    private List<Integer> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();

    private void stageOne() {
        synchronized (lock1) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list1.add(random.nextInt(100));
        }
    }

    private void stageTwo() {
        synchronized (lock2) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list2.add(random.nextInt(100));
        }
    }

    private void process() {
        for (int i = 0; i < 1000; i++) {
            stageOne();
            stageTwo();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Starting ...........");
        long start = System.currentTimeMillis();
        App app = new App();
        Thread t1 = new Thread(app::process);
        Thread t2 = new Thread(app::process);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        long end = System.currentTimeMillis();

        System.out.println("Time take: " + (end - start));
        System.out.println("List1: " + app.list1.size() + "; list2: " + app.list2.size());
    }
}
