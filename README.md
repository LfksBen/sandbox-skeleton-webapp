# disponibilite-gestionnaires

Backend de disponibilite-gestionnaires-web

# Pré-requis

## Variable d'environnement

* Vous devez ajouter dans votre settings.xml de maven la propriété "dev.cdcg"
  * Personnellement je l'ai ajouté au profil activté par défaut "cbp".  
* Sa valeur correspond à vos fichiers de configuration sous 01-CONFIG/{dev.cdcg}.
* Vous pouvez vous connecter à la base de données i1 r1 etc en changeant cette valeur, update de votre projet puis en le redémarrant.

## PostGreSQL 

* Installer PostGreSQL en local.
* Démarrer via pgAdmin
    * Si ça ne marche pas, réinstaller PostGreSQL en mettant le port 5439 (ou retrouver le port dans le fichier de conf <kbd>→</kbd> pas tester)
* Mettre les bonnes infos de connection dans le fichier de conf de votre profil 
    * ou utiliser la base I1 mais il faut lancer le tunnel SSH vers AWS.
    
**Liquibase**
* Il se lance tout seul au démarrage de l'application si vous avez une variable ``updateDatabase=true`` à true dans votre fichier de conf.
* Sinon vous pouvez utiliser la classe ``LiquibaseRunner.java`` pour lancer les mises à jour sur votre base de données.