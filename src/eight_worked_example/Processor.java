package eight_worked_example;

import java.util.LinkedList;
import java.util.Random;

public class Processor {
    private LinkedList<Integer> list = new LinkedList<>();
    private final int LIMIT = 10;
    private final Object lock = new Object();

    public void producer() throws InterruptedException {
        int value = 0;
        while (true) {
            synchronized (lock) {
                while (list.size() == LIMIT){
                    lock.wait();
                    System.out.println("wating...");
                }
                list.add(value);
            }
        }
    }


    public void consumer() throws InterruptedException {
        Random random = new Random();

        while (true) {
            synchronized (lock) {
                while (list.size() == 0){
                    lock.wait();
                    System.out.println("wating...");
                }
                System.out.print("List size is:" + list.size());
                int value = list.removeFirst();
                System.out.println("; value is: " + value);
                lock.notify();
            }
            Thread.sleep(random.nextInt(1000));
        }

    }


}
