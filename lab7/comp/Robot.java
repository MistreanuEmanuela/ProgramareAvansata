import java.util.Random;

public class Robot implements Runnable {
        private String name;
        private boolean running=true;
        Exploration explore;
        public Robot(String name) {
            this.name = name;
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
}
