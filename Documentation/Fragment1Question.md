## Que se passe-t-il si l’utilisateur appuie sur « back » lorsqu’il se trouve sur la seconde Activité ?

L'activité EditActivityPart1 se ferme sans sauvegarder les modifications; le résultat retourné à MainActivityPart1 est RESULT_CANCELED (pas RESULT_OK) et donc le username devient null.
Pour y remédier on sauvegarder dans la classe le dernier username enregistré.

![Description](imgs/Part1UML.png) 
*L’utilisateur ouvre l’application, clique sur le bouton éditer, renseigne son prénom et sauve*

![Description](imgs/Part1UMLRotation.png) 
*L’utilisateur ouvre l’application en mode portrait, clique sur le bouton éditer, bascule en mode paysage, renseigne son prénom et sauve*

## Que faut-il mettre en place pour que vos Activités supportent la rotation de l’écran ? Est-ce nécessaire de le réaliser pour les deux Activités, quelle est la différence ?

Pour Sauvegarder l'état il faut implémenter : "onSaveInstanceState".
Pour La réstauration de l'état il faut implémenter : "onRestoreInstanceState".

Pour MainActivityPart1 - Nécessaire :
* La donnée username est stockée dans une variable membre
* Sans sauvegarde manuelle, la variable est réinitialisée à null après rotation
* Perte de données : le nom d'utilisateur disparaît

Pour EditActivityPart1 - Non Nécessaire :
* Le texte dans l'EditText est automatiquement sauvegardé par Android
* Les vues comme EditText implémentent leur propre onSaveInstanceState()

### BaseActivityPart1
Classe abstraite fournissant une base commune pour toutes les activités de la partie 1 implémentant les Log demandés.

### MainActivityPart1
Activité principale affichant le message de bienvenue et gérant l'édition du nom d'utilisateur.

Sauvegarde d'état manuelle pour la rotation:
* Justification : La donnée username est stockée dans une variable membre
* Nécessite onSaveInstanceState()/onRestoreInstanceState() pour survivre aux rotations
* Clé namespacée (@part1Welcome/username) pour éviter les conflits

Gestion des états null/vide :
* Justification : UX cohérente pour les cas nominaux et anonymes
* Affichage conditionnel selon la présence du nom d'utilisateur

### EditActivityPart1
Activité d'édition permettant la saisie et modification du nom d'utilisateur.

Pas de sauvegarde d'état manuelle :
* Justification : Les données sont stockées dans l'EditText qui gère automatiquement son état
* Android sauvegarde automatiquement le contenu des vues avec ID

Communication via Intent extras :
* Justification : Passage simple du nom existant à éditer
* Retour du résultat via setResult() avec Intent dédié
* Clé namespacée pour éviter les collisions

Nettoyage automatique des données :
* Justification : .trim() supprime les espaces superflus
* Évite les noms d'utilisateur avec espaces accidentels

### UsernameEditContract
Contrat définissant le format d'échange entre MainActivityPart1 et EditActivityPart1.

Types nullable (String?) :
* Justification : Support des cas nominaux (nom existant) et anonymes (null)
* Gestion propre des annulations (RESULT_CANCELED)

Encapsulation de la logique Intent :
* Justification : Centralise la création et l'analyse des Intent
* Les activités n'ont pas à connaître les clés et formats