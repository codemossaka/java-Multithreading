package one_volatileThread;

public class Processor extends Thread {

    private volatile boolean running = true;

    @Override
    public void run() {
        while (running) {
            for (int i = 0; i < 10; ++i) {
                System.out.println("Helo ");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public void shutdown() {
        running = false;
    }
}
