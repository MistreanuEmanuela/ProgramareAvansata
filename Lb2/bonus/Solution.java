import java.util.ArrayList;

public class Solution {
    static Problem p = new Problem();
    public static int[][] createAdiacenteMatrix() {
        int[][] matrix = new int[p.Locations.size()][p.Locations.size()];
        for (int i = 0; i <= p.Locations.size() - 1; i++) {
            for (int j = 0; j <= p.Locations.size() - 1; j++) {
                for (int k = 0; k <= p.Roads.size() - 1; k++)
                    if ((p.Roads.get(k).getLoc1().equals(p.Locations.get(i)) && p.Roads.get(k).getLoc2().equals(p.Locations.get(j))) ||
                            (p.Roads.get(k).getLoc2().equals(p.Locations.get(i)) && p.Roads.get(k).getLoc1().equals(p.Locations.get(j))))
                        matrix[i][j] = 1;
            }
        }
        return matrix;
    }

    public static int distanceMin(ArrayList<Location> D, float b[]) {
        int index = 0;
        float min = 100000000;
        for (int i = 0; i <= D.size() - 1; i++) {
            for (int j = 0; j <= p.Locations.size() - 1; j++)
                if (p.Locations.get(j).equals(D.get(i)))
                    if (b[j] < min) {
                        min = b[j];
                        index = j;
                    }

        }
        return index;
    }

    static int getIndexLocation(Location loc) {
        int index = 0;
        for (int i = 0; i < p.Locations.size(); i++) {
            if (p.Locations.get(i).equals(loc))
                index = i;
        }
        return index;
    }

    static float Deijkstra(int a[][], Location source, Location target)
    {
        int sourceIndex ,targetIndex;
        sourceIndex = getIndexLocation(source);
        targetIndex = getIndexLocation(target);

        float[] distance = new float[p.Locations.size()];
        int[] previous = new int[p.Locations.size()];
        ArrayList<Location> LocationsD = new ArrayList<Location>();
        for (int i = 0; i < p.Locations.size(); i++) {
            distance[i] = 10_000_000;
            previous[i] = -1;
            LocationsD.add(p.Locations.get(i));
        }

        distance[sourceIndex] = 0;
        int nodCurent = 0;
        while (LocationsD.size() > 0) {
            nodCurent = distanceMin(LocationsD, distance);
            for (int r = 0; r < LocationsD.size(); r++) {
                if (p.Locations.get(nodCurent).equals(LocationsD.get(r))) {
                    LocationsD.remove(r);
                }
            }
            if (previous[nodCurent]== targetIndex) {
                int i = targetIndex;
                while (distance[i] > 0) {
                    System.out.println(p.Locations.get(i).getName() + " - ");
                    i = previous[i];
                }
                System.out.println(p.Locations.get(getIndexLocation(source)).getName());
                return distance[targetIndex];
            }

            for (int j = 0; j < p.Locations.size(); j++) {
                if (a[nodCurent][j] == 1) {
                    for (int k = 0; k < LocationsD.size(); k++)
                        if (LocationsD.get(k).equals(p.Locations.get(j))) {
                            float aux = 0;
                            for (int k1 = 0; k1 <= p.Roads.size() - 1; k1++) {
                                if ((p.Roads.get(k1).getLoc1().equals(p.Locations.get(nodCurent)) && p.Roads.get(k1).getLoc2().equals(p.Locations.get(j))) ||
                                        (p.Roads.get(k1).getLoc2().equals(p.Locations.get(nodCurent)) && p.Roads.get(k1).getLoc1().equals(p.Locations.get(j)))) {
                                    aux = distance[nodCurent] + p.Roads.get(k1).getLenght();
                                    if (aux < distance[j]) {
                                        distance[j] = aux;
                                        previous[j] = nodCurent;
                                    }
                                }
                            }
                        }
                }
            }
        }
        return 0;
    }

    public static void bestRoute(Location a, Location b) {
            int[][] matrix = new int[p.Locations.size()][p.Locations.size()];
            matrix = createAdiacenteMatrix();
            float distance=Deijkstra(matrix, a, b);
            if(distance>0){
            System.out.println("Distanta: "+ distance);
     }
            else
            {
           System.out.println("Nu putem ajunge din locatia "+ a.getName()+ " in locatia "+ b.getName());
        }
    }
    public static void bestRouteBetweenLocation(String name1, String name2)
    {
        Location source=new Location("a",0,0);
           Location target=new Location("b",0,0);
        for(int i=0; i<p.Locations.size(); i++)
        {
            if(p.Locations.get(i).getName().equals(name1))
                source=p.Locations.get(i);
            if(p.Locations.get(i).getName().equals(name2))
               target=p.Locations.get(i);
        }
       bestRoute(source, target);
    }
}
