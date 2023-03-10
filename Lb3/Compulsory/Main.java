import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
public class Main {

    public static void main(String[] args) {
        List <Node> Nodes=new ArrayList<>();
        Person a=new Person("Ana") ;
        Nodes.add(a);
        Person b=new Person("Maria");
        Nodes.add(b);
        Person c=new Person("Luca");
        Nodes.add(c);
        Company d=new Company("Continental");
        Company r=new Company("Amazon");
        Nodes.add(d);
        Nodes.add(r);
        System.out.println(Nodes);
        
    }
}
