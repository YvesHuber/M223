# AbschlussProjekt Modul 223

Dies ist eine Programm zur registrierung von Buchungen in einem CoWorkingSpace

## Programm starten

1. Das Projekt in Visual Studio Code öffnen
1. Das Projekt im DevContainer Öffnen
1. Das Projekt mit dem Command `Quarkus: Debug current Quarkus Project`
1. Das Projekt ist auf http://localhost:8080 erreichbar


### Datenbankadministration

Über http://localhost:5050 ist PgAdmin4 erreichbar. Damit lässt sich die Datenbank komfortabel verwalten. Der Benutzername lautet `zli@example.com` und das Passwort `zli*123`. Die Verbindung zur PostgreSQL-Datenbank muss zuerst mit folgenden Daten konfiguriert werden:
 - Host name/address: `db`
 - Port: `5432`
 - Maintenance database: `postgres`
 - Username: `postgres`
 - Password: `postgres`

## Automatische Tests

Die automatischen Tests können mit `./mvnw quarkus:test` ausgeführt werden. Für die automatischen Tests wird nicht die PostgreSQL-Datenbank verwendet, sondern eine H2-Datenbank, welche sich im Arbeitsspeicher während der Ausführung befindet.

## Testdaten

Die testdaten werden hinzugefügt sobald das Programm gestartet wird