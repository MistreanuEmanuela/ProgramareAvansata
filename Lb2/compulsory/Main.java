public class Main {
    static public double calculateDistance(float x1, float y1, float x2, float y2)
    {
        return Math.sqrt((x2-x1)*(x2-x1)-(y2-y1)*(y2-y1));
    }
    public static void main(String[] args) {
        location a=new location("Iasi",LocationType.ORAS,40, 20);
        a.setType(LocationType.ORAS);
        a.setX(40);
        a.setY(20);
        System.out.println(a.toString());
        location b=new location("Botosani", LocationType.ORAS, 60,20);
        b.setType(LocationType.ORAS);
        b.setY(20);
        b.setX(60);
        System.out.println(b.toString());
        road A1=new road(100,RoadType.AUTOSTRADA, 90, a,b);
        A1.setLimit(90);
        A1.setType(RoadType.AUTOSTRADA);
        A1.setLenght(120);
        System.out.println(A1.toString());
    }
} 
