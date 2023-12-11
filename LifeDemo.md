# Infrastruktur
* Zeigen [docker-compose.yml](docker-compose.yml)
* Starten Infrastruktur `docker-compose up`
* Zugriff UI http://localhost:8983/solr

# Java-Code
* Zeigen Controller [GameController.java](src/main/java/site/gutschi/solrexample/transport/GameController.java) und [InitializerController.java](src/main/java/site/gutschi/solrexample/transport/InitializerController.java)
* Starten der Applikation 
* Initialisieren http://localhost:8080/api/initialize
* Öffnen UI http://localhost:8080


# Solr Einbauen
* In [pom.xml](pom.xml) SolrJ hinzufügen (siehe kommentierter Code)
* In [InitializerController.java](src/main/java/site/gutschi/solrexample/transport/InitializerController.java) Solr-Index abfüllen (siehe kommentierter Code)
* In [GameController.java](src/main/java/site/gutschi/solrexample/transport/GameController.java) in Solr suchen (siehe kommentierter Code)
* Applikation neu starten
* Initialisieren http://localhost:8080/api/initialize
* Öffnen UI http://localhost:8080
