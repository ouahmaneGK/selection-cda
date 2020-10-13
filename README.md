# selection-cda
Réalisation d'un service web REST java avec jersy pour gérer les données.
il permet de mettre à disposition les ressources vis des URLs.
Les fonctionnalités, developpées en java, permettent des action CRUD sur les deux entités Post et Topic. 
La connexion à la base de données est assurée par JDBC en java, et les résultats sont affichés au format JSON ou XML .
examples d'url:
*afficher la list des posts pour un topic donné -->
http://localhost:8080/CDA_Rest/webService/postsByTopic?id=1

*afficher la liste des topics-->
http://localhost:8080/CDA_Rest/webService/topics

