 Clasa Catalog
 -are o lista de documente
 -getter pt documente
 
 Clasa CatalogManeger
 -are doar metoda execute() - ce reprezinta executarea unei comenzi
 -constructor

Clasa Document
-cu un is, nume, patg, o mapa de tag uri
-settere
-gettere
-metoda toString

Clasa abstracta Command cu metoda execute()

Clase pt fiecare comanda :AddCommand, ListCommand, RaportCommand, ViewCommand, are au ca costructori parametrii necesari executarii comenxii
de exemplu Catalogul si documentul de introdus, catalogul si path-ul pt save, un simplu catalog pt List (listarea documentelor)
aceste clase, executa comenzile respectivve prin metoda execute() care poate fi apelata din clasa CalogManeger (care trimite la clasa abstracta Command)

Am definit 3 exceptii : InvalidCatalog- nu are documente
InvalidDocument -nu are un path setat
InvalidComand -cand primeste o comanda ce nu este cunoscuta
Aceste sunt aruncate si prinse in clasele ce executa comenzile, de exemplu Add- arunca o exeptie de tipul invalid doc daca primeste ca parametru un document ce nu are un path;
