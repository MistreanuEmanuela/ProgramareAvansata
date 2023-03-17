 Interfata Node cu metodele abstracte:
 -getName
 -getNumberOfRelationships -returneaza numarul de relatii a unui nod (size de hashMap-ul nodului)
 -AddRelationship-adauga o noua relatie (de la nodul care o apeleaza catre nodul cu care este apelata metoda)
 
 Clasa Person
 -are un constructor;
 -are zi de nastere, o luna si un an;
 -are o mapa de tip HashMap in care retine relatiile
 -implementeaza toate metodele din interfata
 
 Clasa Company
  -are un constructor;
 -are zi de nastere, o luna si un an;
 -are o mapa de tip HashMap in care retine relatiile
 -implementeaza toate metodele din interfata
 
 Clasele Programmer si Designer
 -subclasele a clasei Person
 -au cate o proprietate in plus (Limbajul si experienta)
 
 Clasa Network
 -implementeaza o retea formata din Noduri
 -are o lista cu elemente de tip nod
 -are o metoda print()- prin care mai intai sorteaza elementele dupa numarul de relatii iar apoi le printeaza
 
 In main:
 * am adaugat noduri si relatii intre acestea si le am printat
 
