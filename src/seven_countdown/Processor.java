package seven_countdown;

import java.util.Random;
import java.util.Scanner;

public class Processor{

    public void producer() throws InterruptedException {
        Random random = new Random();
        synchronized (this) {
            System.out.println("Producer thread running .....");
            wait();
            System.out.println("Resumed.");
        }
    }


    public void consumer() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Thread.sleep(2000);
        synchronized (this) {
            System.out.println("Waiting for return key.");
            scanner.nextLine();
            System.out.println("Return key pressed.");
            notify();
            Thread.sleep(5000);
        }
    }



}
