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
| GET    | /homes  |  affiche toutes les maisons   |
| GET    | /homes/{id}  |  affiche une maison   |
| DELETE    | /homes/{id}  |  supprime une maison   |
| POST    | /homes  |  créer une maison   |
| GET    | /persons  |  affiche toutes les personnes   |
| GET    | /persons/{id}  |  affiche une personne   |
| DELETE    | /persons/{id}  |  supprime une personne   |
| POST    | /persons  |  créer une personne   |
| GET    | /devices  |  affiche toutes les devices   |
| GET    | /devices/{id}  |  affiche une devices   |
| DELETE    | /devices/{id}  |  supprime une devices   |
| POST    | /devices  |  créer une devices   |
