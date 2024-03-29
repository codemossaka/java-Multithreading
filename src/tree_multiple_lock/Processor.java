package tree_multiple_lock;

public class Processor implements Runnable {

    private int id;

    public Processor(int id) {
        this.id = id;
    }

    private volatile boolean running = true;

    @Override
    public void run() {
        System.out.println("Starting: " + id);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Completed: " + id);


    }
}
