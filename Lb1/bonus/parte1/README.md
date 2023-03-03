Create the adjacency matrix of a regular graph. The number of vertices and the vertex degree are given as arguments.

Metode:

* metoda createAdjacencyMatrixRegularGraph- creaza si returneaza o matrice de adiacenta a unui graf regulat
-un graf regulat este un graf in care fiecare nod are acelasi grad;
-metoda implementata se bazeaza pe urmatoarea logica:
plecand de la o matrice nula, si de la prima linie (corespunzatoare primului nod) punem 1 (adica reprezentam o muchie) pe urmatoarele pozitii pana obtinem gradul
(nr de elemente completate=grad) (adica daca avem un graf de 6 noduri de grad 2, nodul 1 va avea muchie cu nodul 2 si 3)

pentru ca este neorientat, completam matricea si sub diagonala principala (mai explicit daca exista muchie i,j atunci exista si muchia j,i)
Cum cateva completari se fac inainte, am verificat pana a ajunge la coloana i (corespunzatoare nodului i)
cate adiacente (ce grad are acesta) si nu am mai completat grad-pozitii dupa i, ci doar cate lipsesc pentru a obtine gradul specificat)

Daca la un moment dat, mai avem nevoie de x adiacente (pentru a forma gradul) dar nu putem sa le mai obtinem (nu mai exista suficiente poziitii, adica noduri disponibile), afisam mesajul "nu exista un astfel de graf regulat" si dam exit din program;

In main:
* am validat numarul de argumente;

* am introdus doua variabile: vertices si vertex care retin informatiile preluate de la linia de comanda

* am introdus o noua matrice care primeste valorile (matricea) returnata de metoda exemplificata mai sus

* am afisat matricea
