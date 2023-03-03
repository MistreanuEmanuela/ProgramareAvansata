

public class Road {
        private float lenght;
        private RoadType type;
        private int limit;
        private location loc1, loc2;
    static public double calculateDistance(float x1, float y1, float x2, float y2)
    {
        return Math.sqrt((x2-x1)*(x2-x1)-(y2-y1)*(y2-y1));
    }

    public Road(float lenght, RoadType type, int limit, Location loc1, Location loc2) {
            if (lenght > calculateDistance(loc1.getX(), loc1.getY(), loc2.getX(), loc2.getY()))
                this.lenght = lenght;
            else
                System.out.println("Distanta incorecta");
        this.type = type;
        this.limit = limit;
        this.loc1 = loc1;
        this.loc2 = loc2;
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
