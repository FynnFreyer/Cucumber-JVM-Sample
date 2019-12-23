# language: de

Funktionalität: Titelanzeige
  Um sich orientieren zu können müssen die Nutzer den richtigen Titel sehen

  Szenariogrundriss:
    Angenommen die Seite "<site>" wurde geöffnet
    Wenn ich auf das Element "<id>" klicke
    Dann sollte der Titel der Seite "<title>" lauten


    Beispiele:
      | site                                | id            | title |
      | http://localhost/mockapp/           | bar           | Bar   |
      | http://localhost/mockapp/bar.php    | foo           | Foo   |
      | http://localhost/mockapp/           | baz           | Baz   |