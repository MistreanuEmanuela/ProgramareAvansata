
import java.time.Month;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Network a=new Network();
        Programmer Ana = new Programmer("Ana");
        Ana.setBirthday(21,Month.FEBRUARY, 2000);
        Programmer Maria = new Programmer("Maria");
        Maria.setBirthday(19,Month.JANUARY,1999);
        Maria.setLimbaj("C");
        Programmer Luca = new Programmer("Luca");
        Programmer Continental = new Programmer("Continental");
        Programmer Amazon = new  Programmer("Amazon");
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
        Network.print();
        Algorithm alg=new Algorithm();
        alg.network=a;
        alg.checkNodesDesconnected();
    }
}