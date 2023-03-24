
import java.time.Month;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        /*
        Network a=new Network();
        Designer Ana = new Designer("Ana");
        Ana.setBirthday(21,Month.FEBRUARY, 2000);
        Programmer Maria = new Programmer("Maria");
        Maria.setBirthday(19,Month.JANUARY,1999);
        Maria.setLimbaj("C");
        Designer Luca = new Designer("Luca");
        Company Continental = new Company("Continental");
        Company Amazon = new Company("Amazon");
        Network.add(Ana);
        Network.add(Maria);
        Network.add(Luca);
        Network.add(Continental);
        Network.add(Amazon);
        Ana.addRelationship(Luca, "prieteni");
        Ana.addRelationship(Maria, "sora");
        Maria.addRelationship(Luca,"cunostinte");
        Maria.addRelationship(Ana,"i");
        Luca.addRelationship(Maria,"a");
        Luca.addRelationship(Ana, "i");
        Continental.addRelationship(Luca,"a");
        Luca.addRelationship(Continental,"prieten");
        Amazon.addRelationship(Continental,"a");
        Continental.addRelationship(Amazon,"parteneri");
       // Network.print();
        Algorithm alg=new Algorithm();
        alg.network=a;
        alg.checkNodesDesconnected();

         */
        Network n=new Network();
        Person p1 =new Person("1") ;
        Person p2 =new Person("2") ;
        Person p3 =new Person("3") ;
        Person p4 =new Person("4") ;
        Person p5 =new Person("5") ;
        Person p6 =new Person("6") ;
        Person p7 =new Person("7") ;
        p1.addRelationship(p2,"a");
        p2.addRelationship(p1,"a");

        p1.addRelationship(p3,"a");
        p3.addRelationship(p1,"a");

        p2.addRelationship(p3,"a");
        p3.addRelationship(p2,"a");

        p2.addRelationship(p4,"a");
        p4.addRelationship(p2,"s");



        p6.addRelationship(p5,"a");
        p5.addRelationship(p6,"a");

        p5.addRelationship(p2,"a");
        p2.addRelationship(p5,"a");

        n.add(p1); n.add(p2);n.add(p3);n.add(p4);n.add(p5);n.add(p6);

        Algorithm alg1=new Algorithm();
        alg1.network=n;
        alg1.checkNodesDesconnected();
        alg1.subgraphs();
    }
}