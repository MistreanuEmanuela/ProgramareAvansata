import java.util.Objects;

public class Road {
    protected float lenght;
    protected String type;
    protected int limit;
    protected Location loc1, loc2;
    static public double calculateDistance(float x1, float y1, float x2, float y2)
    {
        return Math.sqrt(((x2-x1)*(x2-x1))-((y2-y1)*(y2-y1)));
    }

    public Road(float lenght, int limit, Location loc1, Location loc2) {
        this.limit = limit;
        this.loc1 = loc1;
        this.loc2 = loc2;
        if (lenght > calculateDistance(loc1.getX(), loc1.getY(), loc2.getX(), loc2.getY()))
            this.lenght = lenght;
        else {
            System.out.println("Incorect distance..");
            System.exit(-1);
        }

    }


    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void setLenght(float lenght) {
        if (lenght > calculateDistance(loc1.getX(), loc1.getY(), loc2.getX(), loc2.getY()))
            this.lenght = lenght;
        else {
            System.out.println("Distanta incorecta intre localitatile" + getLocations());
            System.exit(-1);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Road road = (Road) o;
        return Float.compare(road.lenght, lenght) == 0 && limit == road.limit && Objects.equals(type, road.type) && loc1.equals(road.loc1) && loc2.equals(road.loc2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lenght, type, limit, loc1, loc2);
    }

    public float getLenght() {
        return lenght;
    }

    public String getType() {
        return type;
    }

    public int getLimit() {
        return limit;
    }

    public Location getLoc1() {
        return loc1;
    }

    public Location getLoc2() {
        return loc2;
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





