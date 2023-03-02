Metoda validateArgv- valideaza argumentul primit in linia de comanda; metoda are ca argument un double, verifica sa fie pozitiv, apoi face un cast la int, daca acesta este egal cu argumentul primit( de tip double) atunci sigur este de tip int si argumentul este valid

Metoda createStringFromLine- asa cum ii zice si numele, creaza un string din elementele de pe linia i, primita ca argument, prin concatenarea acestora;

Metoda createStringFromColumn-idem cu metoda precedenta, doar ca de data aceasta folosim coloana i;

Metoda desplayMatrix- foloseste cele doua metode prezentate mai sus pentru a afisa pentru fiecare coloana respectiv linie elementele sub forma unui String;

In main:
-am adaugat o variabila de timp long care retine timpul sistemului in nanosecunde (tiimpul la care incepe executia);
-am validat existenta argumentului la linia de comanda
-am validat tipul argumentului folosind metoda validateArgv
-am creat o nou matrice de dimensiunea data la linia de comanda
-am dat valori cu ajutorul functiei createMatrixLatinSquare
-daca avem un argument mai mic (pana in 100 de exemplu) afisam matricea cu ajutorul metodei desplayMatrix
-la final am adaugat o noua variabila de timp long care retine starea sistemului in nanosecunde (starea de final)
-variabila time este diferenta dintre timpul de final si cel de inceput, altfel spus timpul de rulare in nanosecunde, pe care il si afisez;
