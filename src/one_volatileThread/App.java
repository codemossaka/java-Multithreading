package one_volatileThread;

public class App {
    private int count = 0;

    public static void main(String[] args) throws InterruptedException {
        App app = new App();
        app.doWork();
    }

    public void doWork() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
//                count++;
                increment();
            }

        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
//                count++;
                increment();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Count is: " + count);
    }

    public synchronized void increment() {
        count++;
    }
}
