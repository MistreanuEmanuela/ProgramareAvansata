class AirPort extends Location
{
    private int numberOfTerminals;
    public AirPort(String name, float x, float y) {
        super(name, x, y);
        this.type="AIR PORT";
    }

    public void setNumberOfTerminals(int numberOfTerminals) {
        this.numberOfTerminals = numberOfTerminals;
    }

    public int getNumberOfTerminals() {
        return numberOfTerminals;
    }
}


