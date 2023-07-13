# Videothek
### Diese App simuliert eine Videothek.
###### Abschlussprojekt für Syntax GmbH
 
#### Was wurde implementiert?

- Login
- Registration
- Interaktives Menü
- Verfügbare Filme anschauen
- Top 3 Bewertete & Top 3 billigste Filme ausgeben
- Guthaben aufstocken
- Filme kaufen
- Eigene Bibliothek begutachten
- Usernamen setzen
- Logout

<br>

Der Programmfluss findet in `Menu.kt` statt und endet auch dort.
Alle Funktionen wurden in Klassen aufgeteilt. 
> Dieses Programm läuft über die Konsole und wird mit vollen Zahlen navigiert.


### Bedienung 
1. Beim Start der `Menü.kt` wird direkt das `Login/Register` Interface gestartet.
2. Da keine Dummy Accounts bestehen, **MUSS** man sich logischerweise als Erstes registrieren. (Bei der Registrierung mit einer Email, besteht kein Regex/Filterung o.ä)
3. Falls die Registrierung fehlschlägt oder auch erfolgreich war, wird das `Login/Register` Interface aufs neuste aufgerufen.
4. Nach einem `Login` wird das `Hauptmenü` eingeblendet.
5. Nun kann man alle Funktionen, die zur Verfügung stehen, nutzen.
6. Das Guthaben kann, zwecks Simulation, beliebig oft selber aufgestockt werden. Muss größer als $1 sein.
7. Programmfluss läuft so lange weiter, auch nach dem `Logout`, bis das Programm terminiert wird.

<br>

### Klassen
Bestehend aus:

- User
> Beinhaltet die Eigenschaften eines Users wie **Kontostand, Bibliothek** usw. User eigene Funktionen sind ebenfalls in dieser Klasse.
- UserDatabase
> Beinhaltet die erstellte Objekte von **User**
- Movie
> Beinhaltet die Eigenschaften eines Filmes wie **Name, Id, Preis, Bewertungen** etc. Movie eigene Funktionen sind ebenfalls in dieser Klasse.
- MovieDatabase
> Beinhaltet die erstellte Objekte von **Movie**
