# climax
# Application de Rapports Clients

Cette application Java permet de lire des données clients à partir de fichiers texte, CSV, XML ou JSON, et génère des rapports statistiques.

## Fonctionnalités

1. **Importation de Fichiers :** L'application peut lire des fichiers texte, CSV, XML ou JSON pour extraire les informations des clients.
2. **Liste des Clients :** Les clients importés sont affichés dans une liste.
3. **Moyenne des Salaires par Profession :** La moyenne des salaires est calculée pour chaque profession et affichée dans une table.
4. **Interface Utilisateur Simple :** L'interface utilisateur est conçue de manière intuitive avec des boutons pour importer des fichiers et quitter l'application.

## Comment Utiliser

### Prérequis

- Java 11 ou supérieur
- Maven
- Docker (pour exécuter l'application dans un conteneur)

### Construction et Exécution Locales

1. Clonez le dépôt : `git clone https://github.com/votre-utilisateur/client-report-app.git`
2. Accédez au répertoire du projet : `cd client-report-app`
3. Compilez le projet : `mvn clean install`
4. Exécutez l'application : `java -jar target/client-report-app.jar`

### Utilisation avec Docker

1. Construisez l'image Docker : `docker build -t client-report-app .`
2. Exécutez l'image dans un conteneur : `docker run -p 8080:8080 client-report-app`

L'application sera accessible à l'adresse http://localhost:8080.

---

