import java.util.HashMap;
import java.util.Map;

public class Company implements  Node, Comparable<Company> {
    private String name;
    private Map<Node, String> relationships = new HashMap<>();
    private int numberOfLocations;

    public Company(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
              //  ", relationships=" + relationships +
                ", numberOfLocations=" + numberOfLocations +
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

    public void setNumberOfLocations(int numberOfLocations) {
        this.numberOfLocations = numberOfLocations;
    }

    @Override
    public Integer numberOfRelationships() {
        return relationships.size();
    }

    @Override
    public void addRelationship(Node node, String value) {
        relationships.put(node, value);
    }

    @Override
    public int check(Node n) {
        if (relationships.containsKey(n))
            return 1;
        return 0;
    }
}
