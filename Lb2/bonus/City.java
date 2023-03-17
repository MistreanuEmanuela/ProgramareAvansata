class City extends Location
{
    private long population;

    public City(String name, float x, float y) {
        super(name, x, y);
        this.type="CITY";
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public long getPopulation() {
        return population;
    }
}
