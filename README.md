# TP-ANGULARJS

TP ANGULARJS+REST SERVER WITH JPA
===================

Groupe : Anne-Sophie Balestra et Jérémy Viallatte.

Ce TP comprend : 
> - Une partie frontend avec AngularJs
> - Une partie backend avec un serveur REST et JPA

**Configuration**
-------------------------

> - Cloner le projet depuis github.
> - Modifier le fichier **persistence.xml** afin d'adapter les informations à votre base de données MySQL.


**Peuplement de la BDD** 
-------------------------

> - Run **JpaTest.java** pour alimenter la base de données.


**Lancement de l'application** 
-------------------------
***Partie Server***
> - Lancer le serveur Tomcat 7 avec maven : ``` mvn tomcat7:run```
> - Rendez vous sur ```http://localhost:8080/ ```

***Partie Client***
> - Lancer le serveur grunt en ligne de commande : ``` grunt serve```
> - Rendez vous sur ```http://localhost:9000/ ```


**API REST Jersey** 
-----------

Le path de base pour Jersey est **/**.

| Method     | URL | Action   |
| :------- | ----: | :---: |
| GET    | /homes  |  créer une maison   |
| GET    | /homes/{id}  |  créer une maison   |
| DELETE    | /homes/{id}  |  créer une maison   |
| POST    | /homes  |  créer une maison   |
| GET    | /persons  |  créer une maison   |
| GET    | /devices  |  créer une maison   |
