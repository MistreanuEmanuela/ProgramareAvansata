import java.util.ArrayList;
import java.util.List;

    public class Exploration {
        private final SharedMemory mem = new SharedMemory(3);
        private final ExplorationMap map = new ExplorationMap(3);
        private final static List<Robot> robots = new ArrayList<>();
        public void start() {
            for (Robot robot : robots) {
                robot.setExplore(this);
                Thread robotThread=new Thread(robot);
                robotThread.start();
            }
        }
        public static void addRobot(Robot r)
        {
            robots.add(r);
        }
        public ExplorationMap getMap() {
            return map;
        }

    }

