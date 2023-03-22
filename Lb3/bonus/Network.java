import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.*;
import java.time.Month;

public class Network {
    static List<Node> list = new ArrayList<>();
    public static void add(Node n) {

        list.add(n);
    }
    public static int importance(Node n) {
        return n.numberOfRelationships();
    }

    public static void print() {
        Collections.sort(list, new Comparator<Node>(){
            public int compare (Node n1, Node n2) {
                return n1.numberOfRelationships().compareTo( n2.numberOfRelationships());
            }
            });
            System.out.println(list);
    }

}
