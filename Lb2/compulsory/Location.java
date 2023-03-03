

public class Location {
        private String name;
        private LocationType type;
        private float x, y;

    public Location(String name, LocationType type, float x, float y) {
        this.name = name;
        this.type = type;
        this.x = x;
        this.y = y;
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
