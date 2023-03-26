 Clasa Student cu urmatoarele:
-un nume (atribut privat)
-constuctorul cu parametru nume;
-implementeaza Cpmarable (pentru sortare)
-metoda toString

Clasa Project cu urmatoarele:
-un nume (atribut privat)
-constuctorul cu parametru nume;
-implementeaza Cpmarable (pentru sortare)
-metoda toString

Clasa Problem cu urmatoarele:

-o lista de studenti
-o lista de probleme
-o mapa de tipul Student Lista proiecte (fiecare student are o lista de proiecte pe care le prefere)

Metodele:
-addProjectList cu parametri un student si o lista de proiecte, adauga in mapa un element cu cheia studentul primit si valoarea lista de proiecte
-nrPref ce primeste ca parametru un student si returneaza nr de proiecte prefereate (size de lista sa de proiecte din mapa)
-getMedia ( cuu ajutorul stream urilor calculam media preferintelor in lista de studenti)
-sort - soram studentii dupa nr de preferinte, aceasta metoda ne ajuta la implementarea alg Greedy
-printStudentsWithFewPref- aceasta medoda foloseste stream urile pt a parcurge lista de studenti si ii filtreaza dupa nr de preferinte ( trebuie sa fie mai mare decat media)
-algorithmGreedy- acesta metoda, mai intai foloseste functia sort - a pastra studentii in aceasta ordine face sa optinem o potrivire cat mai buna, un student cu putine preferinte are sanse mai mici sa primeasca un proiect decat unul cu mai multe preferinte
Apoi in aceasta ordine, pt fiecare student ii alege primul proiect ce nu a fost dat din lista sa, si il adauga in mapa artMap (mapa de atribuiri) 
-resolve()- metoda ce apeleaza algorithmGreedy sa rezolve problema


In main: 
-am adaugat studenti si proiecte (le-am dat nume random folosind biblioteca faker) si am i-am adaugat intr-o problema pe care am rezolvat-o obtinand aceleasi rezultate ca cele evidentiate in enunt

