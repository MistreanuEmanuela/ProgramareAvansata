
import java.util.ArrayList;
public class Main {

    public static void main(String[] args) {
        Problem pb = new Problem();
        GasStation Rompetrol = new GasStation("Rompetrol", -5, 40, 5);
        City A = new City("Iasi", 30, 75);
        City D = new City("Cluj", 30, 75);
        Location B = new City("Botosani", 32, 73);
        Location X = new City("a", 31, 74);
        Location da = new City("Botosani", 32, 73);
        AirPort C = new AirPort("Aeroportul International Iasi", 30, 75);
        Road A1 = new Express(10000, 100, A, B);
        Road A2 = new Express(1000, 33, B, X);
        Road A3 = new Highway(100, 33, X, D);
        System.out.println(Rompetrol.toString());
        Problem.addLocation(B);
        Problem.addLocation(A);
        Problem.addLocation(X);
        //addLocation(da);
        Problem.addRoad(A1);
        Problem.addRoad(A2);
        Problem.addRoad(A3);
        Problem.checkRoadBeetween(A, X);
        Problem.checkRoadBeetween(A, C);
        Problem.checkRoadBeetween(C, B);
        Problem.checkRoadBeetween(A, D);

    }
}