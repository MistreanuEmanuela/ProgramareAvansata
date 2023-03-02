
import java.lang.Math;
enum LocationType{
     oras,
    aeroport,
    bezinarie;
}
enum RoadType{
    autostrada,
    expres,
    tara;
}
public class Main {
     static public double calculateDistance(float x1, float y1, float x2, float y2)
     {
         return Math.sqrt((x2-x1)*(x2-x1)-(y2-y1)*(y2-y1));
     }
    static public class location {
        private String name;
        private LocationType type;
        private float x, y;

        public location(String name) {
            this.name = name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setType(LocationType type) {
            this.type = type;
        }

        public void setX(float x) {
            this.x = x;
        }

        public void setY(float y) {
            this.y = y;
        }

        public String getName() {
            return name;
        }

        public LocationType getType() {
            return type;
        }

        public float getX() {
            return x;
        }

        public float getY() {
            return y;
        }

        @Override
        public String toString() {
            return "location{" +
                    "name='" + name + '\'' +
                    ", type=" + type +
                    ", x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
    static public class road {
        private float lenght;
        private RoadType type;
        private int limit;
        private location loc1, loc2;


        public road( location a, location b) {
            this.loc1=a;
            this.loc2=b;
        }

        public void setType(RoadType type) {
            this.type = type;
        }

        public void setLimit(int limit) {
            this.limit = limit;
        }

        public void setLenght(float lenght) {
            if (lenght > calculateDistance(loc1.getX(), loc1.getY(), loc2.getX(), loc2.getY()))
                this.lenght = lenght;
             else
                System.out.println("Distanta incorecta");
        }


        public float getLenght() {
            return lenght;
        }

        public RoadType getType() {
            return type;
        }

        public int getLimit() {
            return limit;
        }
        public String getLocations() {
            return loc1.getName()+" "+ loc2.getName();
        }

        @Override
        public String toString() {
            return "road{" +
                    "lenght=" + lenght +
                    ", type=" + type +
                    ", limit=" + limit +
                    ", loc1=" + loc1 +
                    ", loc2=" + loc2 +
                    '}';
        }
    }
    public static void main(String[] args) {
        location a=new location("Iasi");
        a.setType(LocationType.oras);
        a.setX(40);
        a.setY(20);
        System.out.println(a.toString());
        location b=new location("Botosani");
        b.setType(LocationType.oras);
        b.setY(20);
        b.setX(60);
        System.out.println(b.toString());
        road A1=new road(a,b);
        A1.setLimit(90);
        A1.setType(RoadType.autostrada);
        A1.setLenght(120);
        System.out.println(A1.toString());
    }
}
