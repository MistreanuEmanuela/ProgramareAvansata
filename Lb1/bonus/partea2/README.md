Metode:

* createAdjacencyMatrixOfCycleGraph(n)- dupa cum spune si numele creaza matricea de adiacenta de dimensiune n a unui graf circular
- un graf circular este un graf in care fiecare muchie are grad 2 (asemenator cu un cerc)

- asadar matricea are pe linia i 1 la coloana i+1 si i-1 (fiecare nod este adiacent cu 2 vecini, nodul precedent si cel ce urmeaza)

- pentru pozitia 0 (nodul 1) - acesta este adiacent cu nodul 2 (i+1=1) si cu ultimul (n-1)

- pentru pozitia n-1 (nodul n)- acesta este adiacent cu nodul precedent (n-2) si cu primul (0)

* matrixMultiplication(matrix1, matrix2) - face inmultirea clasica a doua matrici primite ca argument, element cu element si returneaza matricea rezultat

* matrixOnPowerN(matrix, power)- ridica matricea la puterea n, mai exact se foloseste de metoda precendenta pentru a inmulti cu ajutorul unei matrici rezultat, o tot inmultiste pe aceasta cu patricea principala de n ori

In Main:
* am introdus dimensiunea grafului/matricei (3 dar poate fi inlocui cu orice)
* am facu o matrice de dimensiunea specificata;
* i-am atribuit matricea obtinuta in urma metodei createAdjacencyMatrixOfCycleGraph;
* am afisat matricea;
* am adaugat o noua matrice de aceleasi dimensiuni; 
* am afisat matricea respectiva la puterea 3 (poate fi inlocuit cu orice );
