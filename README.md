# solr-jfs2023
Folien, Code-Beispiele etc. für den Vortag an der Java User Group 2023

# Folien
Eine aktuelle Version der Folien findet ihr unter [folien.pdf](folien.pdf)

# Beispiel
In diesem Repo findet ihr ein SpringBoot Beispielprojekt. Es kann mittels
```
./mvnw spring-boot:run
```

gestartet werden. Die notwendige Infrastruktur (Solr, Datenbank) kann mittels docker compose gestartet werden
```
docker-compose up
```

Das Example bietet eine UI, auf die unter http://localhost:8080 zugegriffen werden kann. Die Applikation implementiert eine Datenbank von Computer-Games inkl. Hersteller-Studio, Gerne und Bewertungen.
Beim ersten Starten muss die Datenbank mit den Daten aus [games.csv](src/main/resources/games.csv) initialisiert werden. Dies kann mit der URL http://localhost:8080/api/initialize gemacht werden.


# Links

* https://github.com/lizzyTheLizard/solr-example
Erweitertes Example mit eigenem Schema etc.

* https://solr.apache.org/guide/solr/latest/getting-started/solr-tutorial.html
Offizielle Solr Dokumentation; Tutorials, Guides für Deployment und Konfiguration, Dokumentation der Query-Parser und vieles mehr

* https://hub.docker.com/_/solr
Offizielles Docker-Image von Solr

* https://www.baeldung.com/apache-solrj
baeldung.com/apache-solrj