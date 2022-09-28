# AbschlussProjekt Modul 223

Dies ist eine API in welcher User erstellt werden können und diese können sich
dann registrieren in einem CoWorkingSpace.

## Programm starten und Aufsetzten

1. Das Projekt in Visual Studio Code öffnen
1. Das Projekt im DevContainer Öffnen
1. Das Projekt mit dem Command `Quarkus: Debug current Quarkus Project`
1. Das Projekt ist auf http://localhost:8080 erreichbar


## Datenbankadministration

Über http://localhost:5050 ist PgAdmin4 erreichbar. Damit kann man die Datenbank verwalten. Der Benutzername lautet `zli@example.com` und das Passwort `zli*123`. Die Verbindung zu der Datenbank muss zuerst mit den Folgenden Daten aufgebaut werden.
 - Host name/address: `db`
 - Port: `5432`
 - Maintenance database: `postgres`
 - Username: `postgres`
 - Password: `postgres`

## Automatische Tests

Die automatischen Tests können mit `./mvnw quarkus:test` ausgeführt werden. Für die automatischen Tests wird nicht die PostgreSQL-Datenbank verwendet, sondern eine H2-Datenbank, welche sich im Arbeitsspeicher während der Ausführung befindet.

## Testdaten

Die Testdaten werden hinzugefügt sobald das Programm gestartet wird


