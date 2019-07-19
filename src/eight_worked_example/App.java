package eight_worked_example;

import java.util.LinkedList;

public class App {


    public static void main(String[] args) throws InterruptedException{

        final Processor processor = new Processor();

        Thread t1 = new Thread(()->{
            try {
                processor.producer();
            } catch (InterruptedException e) {

            }
        });
        Thread t2 = new Thread(()->{
            try {
                processor.consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {

        }

    }



}