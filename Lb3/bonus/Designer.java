public class Designer extends Person {
    public int experienta;
    public Designer(String name) {
        super(name);
    }

    public int getExperienta() {
        return experienta;
    }

    public void setExperienta(int experienta) {
        this.experienta = experienta;
    }


    @Override
    public String toString() {
        return "Designer{" +
                "experienta=" + experienta +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                "." + birthdayMonth +
                "." + birthdayYear +
               // ", relationships=" + //relationships +
                '}';
    }
}
