import java.util.Random;

public class Robot implements Runnable {
    private int numberCells=0;
    private String name;
    private boolean running = true;
    Exploration explore;

    public Robot(String name) {
        this.name = name;
        this.numberCells=0;
    }

    public void run() {
        while (running) {
            Random random = new Random();
            int row = random.nextInt(3);
            int col = random.nextInt(3);
            if (explore.getMap().existPosition()) {
                explore.getMap().visit(row, col, this);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                System.out.println("Am completat toata matricea");
                System.out.println(this+ "a completat " + this.numberCells+ " celule");
                break;
            }
        }
    }

    public void setExplore(Exploration explore) {
        this.explore = explore;
    }

    @Override
    public String toString() {
        return "Robot{" +
                "name='" + name + '\'' +
                '}';
    }

    public void stop() {
        this.running = false;
    }

    public void start() {
        this.running = true;
    }

    public void stopTime(int n) {
        this.running = false;
        try {
            System.out.println("Sleeping robot ...");
            Thread.sleep(n * 1000); // 15 seconds in milliseconds
            System.out.println("Done sleeping.");
        } catch (InterruptedException e) {
            // handle the exception if the sleep is interrupted
            e.printStackTrace();
        }
        this.running = true;
        this.run();
    }
    public int isRun() {
        if (this.running == false) {
            return 0;
        }
        return 1;
    }

    public void setNumberOfCells() {
        this.numberCells = this.numberCells+1;
    }
}