import java.lang.reflect.Array;
import java.time.Month;
import java.time.MonthDay;
import java.time.Year;
import java.util.*;
import java.util.HashMap;
import java.util.Map;
public class Main {

    public static void main(String[] args) {
        Designer Ana = new Designer("Ana");
        Ana.setBirthday(21,Month.FEBRUARY, 2000);
        Ana.setExperienta(10);
        Programmer Maria = new Programmer("Maria");
        Maria.setBirthday(19,Month.JANUARY,1999);
        Maria.setLimbaj("C");
        Designer Luca = new Designer("Luca");
        Company Continental = new Company("Continental");
        Company Amazon = new Company("Amazon");
        Amazon.setNumberOfLocations(5);
        Network.add(Ana);
        Network.add(Maria);
        Network.add(Luca);
        Network.add(Continental);
        Network.add(Amazon);
        Ana.addRelationship(Luca, "prieteni");
        Ana.addRelationship(Amazon, "angajat");
        Ana.addRelationship(Maria, "sora");
        Maria.addRelationship(Continental,"boss");
        Maria.addRelationship(Luca,"cunostinte");
        Continental.addRelationship(Amazon,"parteneri");
        Network.print();
        System.out.println(Network.importance(Ana));
        System.out.println(Network.importance(Maria));
    }
}