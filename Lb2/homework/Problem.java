
    import java.util.ArrayList;

    public class Problem {

        public static ArrayList<Location> Locations = new ArrayList<Location>();
        public static ArrayList<Road> Roads = new ArrayList<Road>();
        public static int checkLocation(Location A) {
            for (int i = 0; i <= Locations.size() - 1; i++) {
                if (A.equals(Locations.get(i))) {
                    System.out.println("Locatia " + A.getName() + " exista deja!");
                    return 0;
                }

            }
            return 1;
        }
        public static void addLocation(Location A)
        {
            if(checkLocation(A)==1)
                Locations.add(A);
        }

        public static int checkRoad(Road B) {
            for (int i = 0; i <= Roads.size() - 1; i++) {
                if (B.equals(Roads.get(i))) {
                    System.out.println("Drumul " + B.getLoc1().getName() + "-" + B.getLoc2().getName() + " exista deja");
                    return 0;
                }
            }
            return 1;
        }
        public static void addRoad(Road B)
        {
            if(checkRoad(B)==1)
                Roads.add(B);
        }

        static ArrayList<Location> LocationsDfsParcurse = new ArrayList<Location>();
        public static int Dfs(Location A, Location B)
        {
            LocationsDfsParcurse.add(A);
            for(int i=0; i<=Roads.size()-1; i++) {
                if(Roads.get(i).getLoc1().equals(A))
                {
                    if(Roads.get(i).getLoc2().equals(B))
                    {
                        return 1;
                    }
                    int roadFound=0;
                    for(int j=0; j<= LocationsDfsParcurse.size()-1; j++)
                    {
                        if(LocationsDfsParcurse.get(j).equals(Roads.get(i).getLoc2()))
                        {
                            roadFound=1;
                        }
                    }
                    if(roadFound==0)
                    {
                        return Dfs(Roads.get(i).getLoc2(),B);
                    }
                }
            }
            return 0;
        }

        static public void checkRoadBeetween(Location A, Location B)
        {

            if(Dfs(A,B)==1) {
                System.out.println("Exista un drum intre " + A.getName()+ " si " + B.getName());
            }
            else
            {
                System.out.println("Nu exista un drum intre " + A.getName()+ " si " + B.getName());
            }
            cleanDfsArrayList();

        }
        static public void cleanDfsArrayList()
        {
            LocationsDfsParcurse.removeAll(LocationsDfsParcurse);
        }


    }

