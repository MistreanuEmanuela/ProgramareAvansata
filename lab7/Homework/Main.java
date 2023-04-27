import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var explore = new Exploration(3);
        Robot r = new Robot("Wall-E");
        Robot r2 = new Robot("R2D2");
        Robot r3 = new Robot("Optimus Prime");
        explore.addRobot(r);
        explore.addRobot(r2);
        explore.addRobot(r3);
        ThreadPlayer threadPlayer=new ThreadPlayer(explore,  100);
        threadPlayer.start();
        int rasp = 0;
        Scanner scanner = new Scanner(System.in);
        while (rasp != 7) {
            System.out.println("Commands: ");
            System.out.println("1.Start the robots ");
            System.out.println("2.Stop the robots ");
            System.out.println("3.Start one robots ");
            System.out.println("4.Stop one robots ");
            System.out.println("5.Pause the robots ");
            System.out.println("6.Pause one robot ");
            System.out.println("7.Exit");
            rasp = scanner.nextInt();
            switch (rasp) {
                case 1:
                    explore.startCommand();
                    break;
                case 2:
                    explore.stopCommand();
                    break;
                case 4:
                    System.out.println("Roboti porniti in acest moment " + explore.getRobots());
                    System.out.println("Which robot do you want to stop?");
                    System.out.println("1.Wall-E");
                    System.out.println("2.R2D2");
                    System.out.println("3.Optimus Prime");
                    int nrRob = scanner.nextInt();
                    switch (nrRob) {
                        case 1:
                            r.stop();
                            break;
                        case 2:
                            r2.stop();
                            break;
                        case 3:
                            r3.stop();
                            break;
                    }
                case 3:
                    System.out.println("Roboti opriti in acest moment " + explore.isStop());
                    System.out.println("Which robot do you want to start?");
                    System.out.println("1.Wall-E");
                    System.out.println("2.R2D2");
                    System.out.println("3.Optimus Prime");
                    int nrRob1 = scanner.nextInt();
                    switch (nrRob1) {
                        case 1:
                            r.start();
                            break;
                        case 2:
                            r2.start();
                            break;
                        case 3:
                            r3.start();
                            break;
                    }
                case 6: {
                    System.out.println("Roboti porniti in acest moment " + explore.getRobots());
                    System.out.println("Which robot do you want to stop?");
                    System.out.println("1.Wall-E");
                    System.out.println("2.R2D2");
                    System.out.println("3.Optimus Prime");
                    int nrRob3 = scanner.nextInt();
                    System.out.println("How much do you want to sleep (in seconds)");
                    int time = scanner.nextInt();
                    switch (nrRob3) {
                        case 1:
                            r.stopTime(time);
                            break;
                        case 2:
                            r2.stopTime(time);
                            break;
                        case 3:
                            r3.stopTime(time);
                            break;
                    }
                }
                case 5:
                {
                    System.out.println("How much do you want to sleep (in seconds)");
                    int time1 = scanner.nextInt();
                    explore.stopTimeCommand(time1);
                }
                case 7: {
                    break;
                }
                default:
                {
                    System.out.println("Comanda gresita");
                }
            }
        }scanner.close(); // don't forget to close the scanner when you're done
    }
}