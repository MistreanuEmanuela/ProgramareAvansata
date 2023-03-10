class GasStation extends Location
{
    private double gasPrice;

    /**
     * This is costructor for class GasStation which extends class Location
     */
    public GasStation(String name,float x, float y,double gasPrice) {
        super(name, x, y);
        this.type="GAS STATION";
        this.gasPrice=gasPrice;
    }


    public double getGasPrice() {
        return gasPrice;
    }

    public void setGasPrice(double gasPrice) {
        this.gasPrice = gasPrice;
    }
}