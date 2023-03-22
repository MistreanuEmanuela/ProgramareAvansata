
 import java.util.HashMap;
 import java.util.Map;
public interface Node
{
    String getName();
    Integer numberOfRelationships();
    void addRelationship(Node node, String  value);
    int check(Node n);

}
