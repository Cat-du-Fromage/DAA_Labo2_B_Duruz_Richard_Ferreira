##Que se passe-t-il si l’utilisateur appuie sur « back » lorsqu’il se trouve sur la seconde Activité ?

L'activité EditActivityPart1 se ferme sans sauvegarder les modifications; le résultat retourné à MainActivityPart1 est RESULT_CANCELED (pas RESULT_OK) et donc le username devient null.

![Description](imgs/Part1UML.png) 
*L’utilisateur ouvre l’application, clique sur le bouton éditer, renseigne son prénom et sauve*

![Description](imgs/Part1UMLRotation.png) 
*L’utilisateur ouvre l’application en mode portrait, clique sur le bouton éditer, bascule en mode paysage, renseigne son prénom et sauve*

##Que faut-il mettre en place pour que vos Activités supportent la rotation de l’écran ? Est-ce nécessaire de le réaliser pour les deux Activités, quelle est la différence ?

Pour Sauvegarder l'état il faut implémenter : "onSaveInstanceState".
Pour La réstauration de l'état il faut implémenter : "onRestoreInstanceState".

Pour MainActivityPart1 - Nécessaire :

*La donnée username est stockée dans une variable membre

*Sans sauvegarde manuelle, la variable est réinitialisée à null après rotation

*Perte de données : le nom d'utilisateur disparaît


Pour EditActivityPart1 - Non Nécessaire :
*Le texte dans l'EditText est automatiquement sauvegardé par Android

*Les vues comme EditText implémentent leur propre onSaveInstanceState()