# disponibilite-gestionnaires

Backend de disponibilite-gestionnaires-web

# Pré-requis

## Configuration du profil dans le fichier de "settings.xml" Maven

(Ceci est en complément de la conf de base pour tout projet: nexus, github etc...)
* Vous devez ajouter dans votre settings.xml la propriété "dev.cdcg"
  * Personnellement je l'ai ajouté au profil activé par défaut: "cbp".  
* Sa valeur correspond à vos fichiers de configuration sous 01-CONFIG/{dev.cdcg}.
* Vous pouvez vous connecter aux environnements i1 r1 etc en changeant cette valeur, update de votre projet puis en le redémarrant.

Attention il faut penser à tenir à jour les fichiers de propriétés des environnements i1 r1 etc vis-à-vis de ceux déposés sur le gitlab-aws qui sont réellement utilisés au déploiement de l'application.

## PostGreSQL 

* Installer PostGreSQL en local.
* Démarrer via pgAdmin
    * Si ça ne marche pas, réinstaller PostGreSQL en mettant le port 5439 (ou retrouver le port dans le fichier de conf <kbd>→</kbd> pas tester)
* Mettre les bonnes infos de connection dans le fichier de conf de votre profil 
    * ou utiliser la base I1 mais il faut lancer le tunnel SSH vers AWS.
    
**Liquibase**
* Il se lance tout seul au démarrage de l'application si vous avez une variable ``updateDatabase=true`` à true dans votre fichier de conf.
* Sinon vous pouvez utiliser la classe ``LiquibaseRunner.java`` pour lancer les mises à jour sur votre base de données.