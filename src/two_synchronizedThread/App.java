package two_synchronizedThread;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Processor processor = new Processor();
        processor.start();

        System.out.println("Press return to stop ....");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        processor.shutdown();
    }
}
