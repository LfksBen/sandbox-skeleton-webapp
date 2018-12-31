# disponibilite-gestionnaires

Backend de disponibilite-gestionnaires-web

# Pré-requis

## Variable d'environnement

* Vous devez déclarer la variable d'environnement "DEV_CDCG".  
* Sa valeur correspond à vos fichiers de configuration sous 01-CONFIG/{env.DEV_CDCG}.  
* Pensez à activer le profil poste-de-dev dans IntelliJ (Menu "Maven Projects" puis "Profiles") si ce n'est pas déjà fait..

## PostGreSQL 

* Installer PostGreSQL en local.
* Démarrer via pgAdmin
    * Si ça ne marche pas, réinstaller PostGreSQL en mettant le port 5439 (ou retrouver le port dans le fichier de conf <kbd>→</kbd> pas tester)
* Mettre les bonnes infos de connection dans le fichier de conf de votre profil 
    * ou utiliser la base I1 mais il faut lancer le tunnel SSH vers AWS.
    
**Liquibase**
* Il se lance tout seul au démarrage de l'application si vous avez une variable ``updateDatabase=true`` à true dans votre fichier de conf.
* Sinon vous pouvez utiliser la classe ``LiquibaseRunner.java`` pour lancer les mises à jour sur votre base de données.