import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
public class Main {
    static public void print()
    {
        for(int i=0; i<Nodes.size(); i++)
        {
            System.out.println(Nodes.get(i).toString());
        }
    }
    static List <Node> Nodes=new ArrayList<>();
    public static void main(String[] args) {
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
        print();
    }

}