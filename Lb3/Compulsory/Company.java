public class Company implements  Node, Comparable<Company> {
    private String name;

    public Company(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int compareTo(Company o) {
        return this.name.compareTo(o.name);
    }
}
