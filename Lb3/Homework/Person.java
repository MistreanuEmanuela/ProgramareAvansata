
import java.util.HashMap;
import java.time.Month;
import java.util.Map;
public abstract class Person implements  Node, Comparable<Person> {
    protected String name;
    protected int birthday=1;
    protected Month birthdayMonth=Month.JANUARY;
    protected int birthdayYear=1900;

    protected Map<Node, String> relationships=new HashMap<>();
    protected Person(String name) {
        this.name=name;
    }

    public void addRelationship(Node node, String  value)
  {
      relationships.put(node, value);
  }
  public void setBirthday(int d, Month m, int y)
  {
      this.birthday=d;
      this.birthdayMonth=m;
      this.birthdayYear=y;
  }
  public Person print()
  {
      return this;
  }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public Integer numberOfRelationships() {
        return relationships.size();
    }

}
