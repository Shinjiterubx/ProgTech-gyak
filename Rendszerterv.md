## 1. Rendszer célja

A rendszer elsődleges célja, olyan ételrendelést segítő alkalmazás fejlesztése, mely a rendelések nyomonkövetésének és létrehozásának megkönnyítésére szolgál. Lehetővé teszi az étel megrendelését, és elkészítési állapotának nyomonkövetését. 
Az alkalmazást Java programnyelven - Swing GUI – segítségével lesz elkészítve. 


## 2. Projektterv

### Projektszerepkörök:
  * Termék tulajdonosok: Szegedi Tamás, Kiss BArnabás 
### Projektmunkások és felelősségek:
  * Backend munkálatok: Kiss Barnabás, Szegedi Tamás
  * Frontend munkálatok: Szegedi Tamás, Kiss Barnabás

### Feladatuk: 
- adatbázis létrehozása az adatok tárolásához
- megfelelő funkciók elkészítése az oldal megfelelő működésének érdekében
- felhasználói felület kialakítása
- tesztelés

### Ütemterv:
|Funkció                  | Feladat                                | Prioritás | Becslés (nap) | Aktuális becslés (nap) | Eltelt idő (nap) | Becsült idő (nap) |
|-------------------------|----------------------------------------|-----------|---------------|------------------------|------------------|---------------------|
|Rendszerterv|Megírás                                 |         1 |             1 |                      1 |                1 |                   1
|Program                  |Prototípus elkészítése	                |         2 |             5 |                      5 |                5 |                   5 |
|Program                  |Alapfunkciók elkészítése                |         3 |             8 |                      8 |                8 |                   8 |
|Program                  |Tesztelés                |         4 |             2 |                      2 |                2 |                   2 |

### 2.4 Mérföldkövek:
   * Dokumentációk
   * Programírás kezdete
   * Program alapvető funkcióinak befejezése
   * Fejlesztés befejezése

## 3. Üzleti folyamatok modellje
![Üzleti folyamatok](../docs/pics/uzlet.png)

## 4. Követelmények

**Funkcionális követelmények**
  - **Felhasználó rendelés, állapot tárolása**

  **Nem funkcionális követelmények**

  **Törvényi előírások, szabványok:**
  - **GDPR-nek való megfelelés**

## 5. Funkcionális terv

**Rendszerszereplők:**
  - **Felhasználó**


  **Rendszerhasználati esetek és lefutásaik:**
  - **Felhasználó**
    - **Rendelés rögzítés**
    - **Állapot rögzítés, módosítás, törlés** 
## 6. Fizikai környezet
- **Az alkalmazás csak asztali platformra készül, XAMPP segítségével, MySQL adatbázissal lesz futtatva.**
  - **Windows 64 bites operációs rendszeren futtatható.**
  - **Fejlesztői eszközök:**
    - **IintelliJ**
    - **Microsoft Visual Code**
    - **XAMPP**


## 7. Architekturális terv

A rendszer működéséhez szükség van egy adatbázis szerverre, ebben az esetben MySQL-re esett a választás. A Swing GUI,  felel a reszponzív megjelenésért. A backend Java alapú.


## 8. Adatbázis terv

### **Táblák**
- **table01:** User tábla
- **table02:** Orders

## 9. Implementációs terv

A GUI felület Swing  nyelven fog elkészülni,A BackEnd Java nyelven. Az adatokat MySQL adatbázisban lesznek tárolva, tervek szerint külső helyen.


## 10. Tesztterv
Alapvető funkciók tesztelése Unit teszteléssel.


## 11. Telepítési terv

A szoftver  felületéhez JDK és XAMMP telepítése szükséges.

**Windows**

A weboldalt közvetlenül a böngészőn keresztül elérhetik a kliensek. A weboldal URL címét szükséges ismerni és ezt beírni a böngésző címsorába.

## 12. Karbantartási terv

A kliens felhasználók a README-ben leírt elérhetőségeken jelenthetik az esetlegesen felmerülő problémákat, hibákat, melyeket fejlesztőink javítanak.



