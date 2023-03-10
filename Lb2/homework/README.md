Clase:

Location- clasa de baza pentru cele 3 tipuri de locatii: AirPort, GasStation and City
metode: Constructorul ce se apeleaza cu nume, coordonata x si coordonata y
Setters and getteres pentru fiecare specificatie a unei locatii
o metoda statica validateCoordonate- care se apeleaza cu x si y, coordonatele unei locatii si verifica sa fie in sistemul cartezian
Clasele AirPort, GasStation and City, extind clasa Location dar au in plus cate o specificatie
metode: Constructorul care apeleaza constructorul Location si inca un parametru este setat si anume tipul

Road-clasa de baza pentru cele 3 tipuri de drumuri: express, highway si contry
metode: constructorul se apeleaza cu lungime, limita, locatia 1, si locatia 2
Setters and getteres pentru fiecare specificatie a unui drum
o metoda statica: calculateDistance- care este apelata cu 4 parametri, mai exact cate doua coordonate a 2 locatii si calculeaza distanta euclidiana intre acestea pentru a putea valida lungimea unui drum;
Clasele express, highway si contry extind clasa Road
metode: Constructorul care apeleaza constructorul Road si inca un parametru este setat si anume tipul

Aceste doua clase mai suprascriu metoda equals pentru obiecte de tipul lor, 2 obiecte fiind egale daca au toate specifiicatiile exact la fel

Problem

Este o instanta ce are 2 liste principale una cu drumuri si una cu locatiii (in care sunt retinute locatiile si drumuri ce apar in problema)
Metode:
*checkLocation- se apeleaza cu o locatie si verifica sa nu fie introdusa din nou cu ajutorul metodei equals.
*addLocation- apelata cu o locatie, introduce o locatie in lista daca este valabila
*check Road-verifica ca un frum sa nu fie introdus din nou in lista
*add road- adauga un drum doar daca nu este deja in lista
*Dfs- se apeleaza cu 2 locatii si dupa cum ii spune si numele face o parcurgere in adancime a locatiilor , in cazul in care gaseste un drum intre prima si a doua locatie, returneaza 1 altfel ramane 0
*checkRoadBeetween- se apeleaza cu doua locatii, foloseste metoda Dfs pentru a verifica existenta unui drum intre cele doua locatii;
*metoda statica cleanDfsArrrayList()- cum introducem o lista statica de locatii parcurse, la fiecare checkRoadBetween trebuie sa curatam lista pentru a avea o solutie la urmatorul check- aceasta metoda curata acea lista



In main- am adaugat locatii si drumuri si am verificat pe aceasta instanta a problemei cateva drumuri intre anumite locatii
