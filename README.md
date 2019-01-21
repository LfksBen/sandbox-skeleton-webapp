# Squelette d'une web app

Squelette d'une web app avec les technos suivantes:
- java 8
- tomcat 8
- maven
- spring
- hibernate
- liquibase
- swagger
- postgresql
- logback

Implémentant les notions suivantes:
- conf par développeura
- exception handlers
- CSP Filter
- i18n

# Lancement en local

### Pré-requis

Faire un ``mvn clean install`` afin de générer des fichiers dans le target/ dont aura besoin l'application une fois démarrée (filtering maven par exemple)

## Configuration du profil dans le fichier de "settings.xml" Maven

(Ceci est en complément de la conf de base pour tout projet: nexus, github etc...)
* Vous devez ajouter dans votre settings.xml la propriété "dev.cdcg"
  * Personnellement je l'ai ajouté au profil activé par défaut: "cbp".  
* Sa valeur correspond à vos fichiers de configuration sous 01-CONFIG/{dev.cdcg}.

## PostGreSQL 

* Installer PostGreSQL en local.
* Démarrer via pgAdmin
    * Si ça ne marche pas, réinstaller PostGreSQL en mettant le port 5439 (ou retrouver le port dans le fichier de conf <kbd>→</kbd> pas tester)
* Mettre les bonnes infos de connection dans le fichier de conf de votre profil
    
**Liquibase**
* Il se lance tout seul au démarrage de l'application si vous avez une variable ``updateDatabase=true`` à true dans votre fichier de conf.
* Sinon vous pouvez utiliser la classe ``LiquibaseRunner.java`` pour lancer les mises à jour sur votre base de données.
