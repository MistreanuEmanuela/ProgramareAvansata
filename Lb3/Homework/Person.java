
public class Person implements  Node, Comparable<Person> {
    private String name;

    public Person(String name) {
        this.name=name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.name);
    }
}
