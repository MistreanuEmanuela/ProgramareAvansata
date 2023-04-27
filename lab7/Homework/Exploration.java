import java.util.ArrayList;
import java.util.List;

    public class Exploration {
        private int timeLimit=10;
        private SharedMemory mem;
        private ExplorationMap map;
        private final static List<Robot> robots = new ArrayList<>();
        public void start() {
            long startTime = System.currentTimeMillis();
            System.out.println(startTime);
            System.out.println(timeLimit * 100000000000L);
            for (Robot robot : robots) {
                robot.setExplore(this);
                Thread robotThread = new Thread(robot);
                robotThread.start();
            }

        }

        public void stopCommand()
        {
            for (Robot robot : robots) {
                robot.stop();
            }
        }
  public void startCommand()
  {
      for (Robot robot : robots) {
          robot.start();
      }
      this.start();
  }
        public void stopTimeCommand(int n)
        {
            for (Robot robot : robots) {
                robot.stopTime(n);
            }
        }

        public static void addRobot(Robot r)
        {
            robots.add(r);
        }
        public ExplorationMap getMap() {
            return map;
        }

        public Exploration(int n)
        {
          this.mem= new SharedMemory(n);
          this.map=new ExplorationMap(n);
        }
        public List<Robot> isStop()
        {
            List<Robot> rob=new ArrayList<>();
            for (Robot robot : robots) {

                if(robot.isRun()==0)
                    rob.add(robot);
            }
            return rob;
        }
        public List<Robot> getRobots()
        {
            List<Robot> rob=new ArrayList<>();
            for (Robot robot : robots) {
                System.out.println(robot.isRun());
                if(robot.isRun()==1)
                    rob.add(robot);
            }
            return rob;
        }
    }

