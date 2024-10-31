package org.example.tp.s.tp1;
/*

Dans ce fichier, vous trouverez une violation du Principe de Responsabilité Unique (Single Responsibility Principle). 
Vous devez refactoriser ce fichier. 
Vous pouvez supprimer ce fichier complètement, car il ne sera pas utilisé lors de l'évaluation de la solution.


Titre de l'exercice : Exercice de Refactorisation du Principe de Responsabilité Unique (SRP)

Objectif : Dans cet exercice, vous allez vous entraîner à appliquer le Principe de Responsabilité Unique (SRP) pour refactoriser une base de code donnée. Le SRP stipule qu'une classe ne doit avoir qu'une seule raison de changer, ce qui signifie que chaque classe doit avoir une responsabilité unique et bien définie. Vous allez améliorer la modularité, la lisibilité et la maintenabilité du code en séparant les responsabilités distinctes dans des classes séparées.

Instructions :

1. **Examinez le code fourni** : Commencez par examiner le code original fourni - la classe `UserDataManager`. Identifiez les parties où le code viole le Principe de Responsabilité Unique en ayant des classes responsables de plusieurs tâches.
#la classe gère 3 responsabilités et viole donc le principe de responsabilité unique à ces endroits.

2. **Identifiez les responsabilités** : Analysez le code pour identifier les responsabilités ou fonctionnalités distinctes qui peuvent être séparées dans des classes individuelles. Concentrez-vous sur des domaines tels que l'enregistrement d'utilisateurs, la connexion, la manipulation des données, ou toute autre tâche distincte.
#la classe gère 3 responsabilités : validation des données utilisateur, enregistrement et connexion de l'utilisateur et gestion de la base de données.

3. **Refactorisez le code** : Refactorisez le code pour créer des classes séparées pour chaque responsabilité identifiée (`UserValidator`, `UserRegistration`, `UserAuthenticator`). Assurez-vous que chaque classe a un objectif clair et unique, tel que l'enregistrement d'utilisateur, l'authentification ou la manipulation des données.

4. **Testez votre solution** : Il existe des tests pour des scénarios positifs et négatifs qui doivent réussir.

5. **Vérifiez la qualité du code** : Révisez votre code refactorisé pour vous assurer qu'il adhère aux principes du SRP. Vérifiez que chaque classe a une responsabilité unique et que le code est modulaire, lisible et maintenable.

Note : Pour l'enregistrement et la connexion, nous n'utiliserons aucun stockage en mémoire ou externe. N'hésitez pas à réutiliser la logique métier de la classe `UserDataManager` autant que possible. L'objectif principal n'est pas la logique métier mais la refactorisation.

*/


public class UserDataManager {
    private String username;
    private String password;
    private UserRegistration registration;
    private UserAuthenticator authenticator;

    public UserDataManager(String username, String password) {
        this.username = username;
        this.password = password;
        UserValidator validator = new UserValidator();
        this.registration = new UserRegistration(validator);
        this.authenticator = new UserAuthenticator(validator);
    }

    public void registerUser() {
        registration.register(username, password);
    }

    public void loginUser() {
        authenticator.authenticate(username, password);
    }

    public static void main(String[] args) {
        UserDataManager userManager = new UserDataManager("john_doe", "Password123");
        userManager.registerUser();
        userManager.loginUser();
    }
}