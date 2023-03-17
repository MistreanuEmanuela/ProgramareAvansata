import java.util.Objects;

public class Location {
    protected String name;
    protected String type;
    protected float x, y;

    static public int validationCoordonates(float x, float y) {
        if (x < -90 || x > 90 || y < -180 || y > 180)
            return 1;
        else
            return 0;
    }

    /**
     * Class constructor.
     * @param name the name for a new location
     * @param x the  x-coordonate for location in cartezian sistem
     * @param y the  y-coordonate for location in cartezian sistem
     */
    public Location(String name, float x, float y) {
        this.name = name;
        if (validationCoordonates(x, y) > 0) {
            System.out.println("Coordonatele nu sunt valide");
            System.exit(-1);
        } else {
            this.x = x;
            this.y = y;
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Float.compare(location.x, x) == 0 && Float.compare(location.y, y) == 0 && name.equals(location.name) && Objects.equals(type, location.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, x, y);
    }


    /**
     * This method sets the name of the location from which it is called
     * @param name a String which will become the name of the location
     */
    public void setName(String name) {
        this.name = name;
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

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    /**
     *This method is an override of the toString method that customizes the way a location is displayed as a string
     * @return a String consisting of location data
     */
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



