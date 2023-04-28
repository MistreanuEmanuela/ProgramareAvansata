 * Cell-reprezinta o celula din matricea ce trebuie compleata
 
 -are o lista de token-uri
 
 -o variabila vizited (default 0 si devine 1 la vizitare)
 
 -settere si gettere pt token-uri, constructorii seteaza vizited 0, iar prin setVizited poate fi setat 1
 
 * SharedMemory
 
-o lista de token-uri pe care ii creaza si ii pune intr-o ordine aleatorie cu shuffle

-metada extractTokens (care e synchronized pt ca doar un robot sa poate extrage o data sa nu apara erori) care extrage n token-uri din lista de tokens

* Token

-are un numar (care reprezinta de fapt ce stocheaza

-constructor, gettter si metoda toString

* ExploarationMap
-are o matrice formata din celule

-metoda vizited (care implementeaza de asemenea synchronized ca 2 roboti sa nu poate fi in aceeasi celula in acelasi timp)  care permite unui robot sa viziteze o celula daca nu a fost vizitata si sa seteze token-ii in acea celula

-existPosition() -verifica daca mai exista pozitii neocupate in matrice

* Robot -implementeaza runnable
-are un nr de celule pe care le-a vizitat

-un nume

-running

-metoda run- cat timp running e true acesta alege rendom un nr si o coloana si incearca sa o viziteze daca mai exista pozitii in matrice

-stop -opreste robotul setand runnig false

-stopTime- opreste robotul pentru o perioada de timp seteaza runngin false, iar dupa un timp il seteaza true

-isRun -verifica daca robotul is running

* Exploration
-are niste roboti, o memorie pe care lucreaza si o matrice de explorat

-metoda start -porneste toti robotii

-metoda stopCommand -opreste toti robotii

-metada startCommand-porneste toti robotii

-metoda stopTimeCommand(int n)-opreste robotii pt un timp n secunde

-is Stop- verifica care roboti sunt opriti

* In main
-am facut tri roboti si am inceput o explorare , am mapat prin switch comenzile

* ThreadPlayer- un thread ca un daemon care ruleaza in acelasi timp cat pleyerul se joaca ce are o anumita perioada limita de timp iar cand este depasite opreste programul

Daca programul nu s a oprit si explorarea a luat sfarsit fiecare robot afiseaza cate celule a completat
