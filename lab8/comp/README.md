 * Clasa Database:
 
 
 -are un URL, USER, PARSSWORD si o conexiune, primele trei atribute fiind folosite la stabilirea conexiunii
 
getConnection()-metoda ce returneaza conexiunea la baza de date

createConnection- metoda ce creaza o coneexiune folosind URL USER PASSWORD si o salveaza in connection

closeConnection - inchide conexiunea cu baza de date

-Sunt aruncate si prinse erorile de tip SQL ce pot aparea (nu ne putem connecta sau nu putem inchide conexiunea)


 * script.sql 


-scriptul de creare a tabelelor din baza de date 

albums: id, release year, title, artist, genre (retine id-ul/id-urile genului )

artists: id, name

genres: id, name 


 * AlbumDAO, ArtistDAO, GenreDAO

-clasele dao ce implementeaza metodele de creare a unei noi instante a unui tabele (aceasta primeste atributele ce trebui trecute in tabel)

-findById -gaseste o instanta dupa un id dat

-findByName- gaseste o instanta dupa un nume


 * In main


-am scris cateva exemple, un test simplu de verificare a introducerii de date in baza de date si de extragere de date din aceasta


