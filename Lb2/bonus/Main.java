
import java.util.ArrayList;
import java.util.*;
public class Main {
    static public void populateProblem( Problem p)
    {
        for (int i=0; i<=100; i++) {
            String a=new String("Location");
            a=a+i;
            Location loc0=new Location(a,1,2);
            p.addLocation(loc0);
        }
        for(int i=0; i<=100000; i++)
        {
            int randomNr1= (int) (Math.random()*99);
            int randomNr2= (int) (Math.random()*99);
            float randomNr3= (float) (Math.random()*1_000_000_000);
            String b=new String("Road");
            b=b+i;
            Road rod=new Road(randomNr3,20,p.Locations.get(randomNr1),p.Locations.get(randomNr2) );
            p.addRoad(rod);
        }
    }

    public static void main(String[] args) {
        System.gc();
        Runtime runtime = Runtime.getRuntime();
        long usedMemoryBefore =
                runtime.totalMemory() - runtime.freeMemory();
        long initialTime = System.currentTimeMillis();
        Problem localProblem = new Problem();
        populateProblem(localProblem);
        Solution s=new Solution();
        s.p=localProblem;
        s.bestRouteBetweenLocation("Location0", "Location5");
        s.bestRouteBetweenLocation("Location7","Location3");
        /*
        Location a=new Location("a", 1, 1);
        Location b= new Location("b", 1, 1);
        Location c= new Location("c", 1, 1);
        Location d=new Location("d",1,1);
        Location f=new Location("f",1,1);
        Road a1=new Road(10,10,a,b);
        Road a2=new Road(10,10,b,c);
        Road a3=new Road(25,10,a,c);
        Road a4=new Road(10,10,c,d);
        Road a5=new Road(10,10, d, f);
        s.p.addLocation(a);
        s.p.addLocation(b);
        s.p.addLocation(c);
        s.p.addLocation(d);
        s.p.addLocation(f);
        s.p.addRoad(a1);
        s.p.addRoad(a2);
        s.p.addRoad(a3);
        s.p.addRoad(a4);
        s.p.addRoad(a5);
        s.bestRouteBetweenLocation("a","d");
        */
        long runningTime = System.currentTimeMillis() - initialTime;
        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        long memoryIncrease = usedMemoryAfter - usedMemoryBefore;
        System.out.println("Time: " +runningTime);
        System.out.println("Memorie: " + memoryIncrease);
    }
}