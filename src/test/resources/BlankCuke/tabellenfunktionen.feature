# language: de

Funktionalität: Tabellenfunktionen
  man muss den Durchschnitt und Summe der Tabelleninhalte bestimmen können

  Szenario: Durchschnitt
    Angenommen die Seite "http://localhost/mockapp/table.php" wurde geöffnet
    Wenn ich auf das Element "avgBtn" klicke
    Dann sollte das Ergebnis 7 sein

  Szenario: Summe
    Angenommen die Seite "http://localhost/mockapp/table.php" wurde geöffnet
    Wenn ich auf das Element "sumBtn" klicke
    Dann sollte das Ergebnis 21 sein

