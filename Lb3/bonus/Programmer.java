public class Programmer extends Person{
    String limbaj;
    public Programmer(String name) {
        super(name);
    }

    public void setLimbaj(String limbaj) {
        this.limbaj = limbaj;
    }

    public String getLimbaj() {
        return limbaj;
    }

    @Override
    public String toString() {
        return "Programmer{" +
                "name='" + name + '\'' +
                ", relationships=" +// relationships +
                '}';
    }
}
