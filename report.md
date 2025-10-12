### Exercice 3

#### A l’initialisation de l’Activité, comment peut-on faire en sorte que la première étape s’affiche automatiquement ?

Dans la méthode onCreate, on peut programmativement initialiser du code, dont la création du premier fragment.

#### Comment pouvez-vous faire en sorte que votre implémentation supporte la rotation de l’écran ? Nous nous intéressons en particulier au maintien de l’état de la pile de Fragments et de l’étape en cours lors de la rotation.

Grâce aux méthodes onSaveInstanceState et onViewStateRestored, on peut restaurer l'état des fragments lors de la rotation de l'écran.
Cependant, à cause de l'ordonnancement d'exécution des différentes méthodes (onCreate, onStart, onRestoreInstanceState...), et à l'instanciation assez rapide du premier fragment (lors de onCreate), il a été nécessaire de récupérer dans le paramètre savedInstanceState de onCreate la valeur sauvegardée du stepper, ceci afin d'éviter d'avoir le tout premier fragment instancié sur rotation.

#### Dans une transaction sur le Fragment, quelle est la différence entre les méthodes add et replace ?

Add va simplement instancier un nouveau fragment par-dessus (en partant du principe qu'on instancie dans la même view) celui déjà existant, ce qui doit nécessiter des travaux supplémentaires notamment en termes d'affichage.
Replace va supprimer le fragment courant et instancier le nouveau en lieu et place.