class Express extends Road
{
    public Express(float lenght, int limit, Location loc1, Location loc2) {
        super(lenght, limit, loc1, loc2);
        this.type="EXPRESS";
    }
}