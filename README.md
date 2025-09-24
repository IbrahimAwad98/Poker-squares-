**♠️ Poker Squares (Pokerpatiens)**

Ett kortspel där målet är att placera ut kort i en 5x5-grid för att skapa bästa möjliga pokerhänder i varje rad.
Spelet är implementerat i Java med tydlig uppdelning mellan modell (data + logik) och användargränssnitt.

**Beskrivning: **

Projektet är skrivet enligt objektorienterade principer (inkapsling, kohesion, låg koppling).
Modellklasser
Card → Representerar ett spelkort (enum Rank och Suit).
Deck → Hanterar en kortlek på 52 kort (blandning, dra kort).
Pile → Representerar en samling kort (t.ex. en rad i spelet).
PsLogic → Huvudlogiken för spelet Poker Squares: hanterar drag, placering av kort och poängberäkning.
PokerHands → Statisk hjälparklass som avgör vilken pokerhand en given samling kort utgör.

Användargränssnitt
PsUserInterface → Textbaserat UI som låter spelaren starta spel, dra kort och placera dem i rader.

**Krav**: 
Java 17 eller senare
Kompilator (javac) och JVM (java)
