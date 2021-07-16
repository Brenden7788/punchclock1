# M223: Punchclock Erweiterung (Zahnarztpraxis)
Dies ist eine Applikation für die LB_C des Moduls 223.

## Loslegen
Folgende Schritte befolgen um loszulegen:
1. Sicherstellen, dass JDK 12 installiert und in der Umgebungsvariable `path` definiert ist.
1. Ins Verzeichnis der Applikation wechseln und über die Kommandozeile mit `./gradlew bootRun` oder `./gradlew.bat bootRun` starten
1. Unittest mit `./gradlew test` oder `./gradlew.bat test` ausführen.
1. Ein ausführbares JAR kann mit `./gradlew bootJar` oder `./gradlew.bat bootJar` erstellt werden.

Folgende Dienste stehen während der Ausführung im Profil `dev` zur Verfügung:
- REST-Schnittstelle der Applikation: http://localhost:8081
- Dashboard der H2 Datenbank: http://localhost:8081/h2-console

Diese Applikation ist ein Planungstool für eine Zahnarztpraxis. 
-Es gibt ein Admin, welcher einen Namen und einen Passwort hat,und dieser kann mehrere Zahnärzte erstellen. 
-Die Zahnärzte haben einen Namen, einen Passwort und eine Fähigkeit. Die Fähigkeit beschreibt, was für eine Art Zahnartzt der Artzt ist. 
-Der Admin und der Zahnarzt kann Besucher erstellen. Der Besucher hat nur einen Namen und einen Passwort.
-Der Admin, Zahnärzte und die Besucher können die Termine verwalten--> Anschauen, erstellen, löschen und verändern.

