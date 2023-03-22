import java.util.ArrayList;
import java.util.List;

public class Algorithm {
    static Network network=new Network();
    static int[][] a = new int[Network.list.size()][Network.list.size()];

    public static void createMatrix() {

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (Network.list.get(i).check(Network.list.get(j)) == 1) {
                    a[i][j] = 1;
                }
            }
        }
    }
    static List<Integer> lista=new ArrayList<>();
    static int[] vizited=new int[10];
    static public void init() {
        for (int i = 0; i < 5; i++) {
            vizited[i] = 0;
        }
        lista.add(Network.list.indexOf(Network.list.get(0)));
    }

    public static int DfsAlgorithm(Node n) {
        vizited[Network.list.indexOf(n)] = 1;
        for (int i = 0; i < 5; i++) {
            if (a[Network.list.indexOf(n)][i] == 1) {
                if (lista.contains(i) == false && n.equals(Network.list.get(0))==false) {
                    System.out.println("Nodul "+ n + " deconecteaza reteau daca este sters ");
                    return 1;
                }
                lista.add(i);
            }
        }
        for (int i = 0; i < 5; i++) {
            if (a[Network.list.indexOf(n)][i] == 1 && vizited[i] == 0) {
                DfsAlgorithm(Network.list.get(i));
            }
        }
        return 0;
    }
    public static void checkNodesDesconnected()
    {
        init();
        createMatrix();
        if(DfsAlgorithm(Network.list.get(0))!=0)
        {
            System.out.println("Nu exista noduri care sa deconecteze reteau");
        }
    }
}
