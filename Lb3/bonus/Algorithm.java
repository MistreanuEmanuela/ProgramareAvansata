import java.util.ArrayList;
import java.util.List;

public class Algorithm {
    static Network network = new Network();
    static int[][] a = new int[network.list.size()][network.list.size()];

    public static void createMatrix() {
        for (int i = 0; i < network.list.size(); i++) {
            for (int j = 0; j < network.list.size(); j++) {
                if (network.list.get(i).check(network.list.get(j)) == 1) {
                    a[i][j] = 1;
                }
            }
        }
    }

    static List<Integer> lista = new ArrayList<>();
    static int[] vizited = new int[10];

    static public void init() {
        for (int i = 0; i < 5; i++) {
            vizited[i] = 0;
        }

    }

    public static int DfsAlgorithm(Node n) {
        vizited[network.list.indexOf(n)] = 1;
        if (!lista.contains(network.list.indexOf(n)))
            lista.add(network.list.indexOf(n));
        for (int i = 0; i < network.list.size(); i++) {
            if (a[network.list.indexOf(n)][i] == 1) {
                if (lista.contains(i) == false && n.equals(radacina) == false) {
                    System.out.println("Exista noduri care deconecteaza reteau: " + n.getName());
                    return 0;
                }
                if (!lista.contains(i))
                    lista.add(i);
            }
        }
        for (int i = 0; i < network.list.size(); i++) {
            if (a[network.list.indexOf(n)][i] == 1 && vizited[i] == 0) {
                DfsAlgorithm(network.list.get(i));
            }
        }
        return 1;
    }

    static public Node radacina;

    public static void checkNodesDesconnected() {
        lista.clear();
        init();
        createMatrix();
        for (int i = 0; i < network.list.size(); i++) {
            radacina = Network.list.get(i);
            if (DfsAlgorithm(Network.list.get(i)) != 1) {
                System.out.println("Nu exista noduri care sa deconecteze reteau");
            }
        }
    }

    public static void subgraphs() {
        createMatrix();
        lista.clear();
        init();
        for (int i = 0; i < Network.list.size(); i++) {
            lista.clear();
            init();
            radacina = Network.list.get(i);
            printSubgraph1Conected(Network.list.get(i));
            lista.clear();
            init();
            printSubgraph2Conected(Network.list.get(i));
        }
    }

    static List<Node> listNoduriDeconectare = new ArrayList<>();

    public static int printSubgraph1Conected(Node n) {
        vizited[Network.list.indexOf(n)] = 1;
        if (!lista.contains(Network.list.indexOf(n)))
            lista.add(Network.list.indexOf(n));
        for (int i = 0; i < Network.list.size(); i++) {
            if (a[Network.list.indexOf(n)][i] == 1) {
                if (lista.contains(i) == false && n.equals(radacina) == false && !listNoduriDeconectare.contains(n)) {
                    System.out.println("Nodul " + n.getName() + " deconecteaza reteau daca este sters ");
                    lista.add(i);
                    System.out.print("Sugraf :{ ");
                    listNoduriDeconectare.add(n);
                    for (int j = 0; j < lista.size(); j++)
                        System.out.print(Network.list.get(j).getName() + "  ");
                    System.out.println('}');
                    lista.remove(i);
                    System.out.print("Sugraf :{ ");
                    System.out.print(n.getName() + " ");

                    for (int j = 0; j < Network.list.size(); j++) {
                        if (!lista.contains(j))
                            System.out.print(Network.list.get(j).getName() + "  ");
                    }
                    System.out.println('}');
                    return 0;
                }

            if (!lista.contains(i))
                lista.add(i);
        }
    }
        for (int i = 0; i < Network.list.size(); i++) {
            if (a[Network.list.indexOf(n)][i] == 1 && vizited[i] == 0) {
                printSubgraph1Conected(Network.list.get(i));
            }
        }
       return 0;
    }
    static List<Node> listNoduriDeconectare2=new ArrayList<>();
    public static int printSubgraph2Conected(Node n)
    {
        vizited[Network.list.indexOf(n)] = 1;
        if( !lista.contains(Network.list.indexOf(n)))
            lista.add(Network.list.indexOf(n));
        for (int i = 0; i < Network.list.size(); i++) {
            if (a[Network.list.indexOf(n)][i] == 1) {
                for (int k = 0; k < Network.list.size(); k++) {
                    if (a[i][k] == 1) {
                        if (lista.contains(k) == false && n.equals(radacina) == false && (!listNoduriDeconectare2.contains(n) || !listNoduriDeconectare2.contains(Network.list.get(i)))) {
                            System.out.println("Nodul " + n.getName() + " si nodul " + Network.list.get(i).getName() + " deconecteaza reteau daca sunt sterse ");
                            System.out.print("Sugraf :{ ");
                            listNoduriDeconectare2.add(n);
                            listNoduriDeconectare2.add(Network.list.get(i));
                            for (int j = 0; j < lista.size(); j++)
                                System.out.print(Network.list.get(lista.get(j)).getName() + "  ");
                                System.out.print(Network.list.get(k).getName() + "  ");
                            System.out.println('}');
                            return 1;
                        }
                    }
                }
                if(!lista.contains(i))
                    lista.add(i);
            }
        }
        for (int i = 0; i < Network.list.size(); i++) {
            if (a[Network.list.indexOf(n)][i] == 1 && vizited[i] == 0) {
                printSubgraph2Conected(Network.list.get(i));
            }
        }
        return 0;
    }

}

