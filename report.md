### Exercice 3

#### A l’initialisation de l’Activité, comment peut-on faire en sorte que la première étape s’affiche automatiquement ?

Dans la méthode onCreate, on peut programmativement initialiser du code, dont la création du premier fragment.

#### Comment pouvez-vous faire en sorte que votre implémentation supporte la rotation de l’écran ? Nous nous intéressons en particulier au maintien de l’état de la pile de Fragments et de l’étape en cours lors de la rotation.

Grâce aux méthodes onSaveInstanceState et onViewStateRestored, on peut restaurer l'état des fragments lors de la rotation de l'écran.
Cependant, à cause de l'ordonnancement d'exécution des différentes méthodes (onCreate, onStart, onRestoreInstanceState...), et à l'instanciation assez rapide du premier fragment (lors de onCreate), il a été nécessaire de récupérer dans le paramètre savedInstanceState de onCreate la valeur sauvegardée du stepper, ceci afin d'éviter d'avoir le tout premier fragment instancié sur rotation.

#### Dans une transaction sur le Fragment, quelle est la différence entre les méthodes add et replace ?

Add va simplement instancier un nouveau fragment par-dessus (en partant du principe qu'on instancie dans la même view) celui déjà existant, ce qui doit nécessiter des travaux supplémentaires notamment en termes d'affichage.
Replace va supprimer le fragment courant et instancier le nouveau en lieu et place.
### Exercice 2
#### Les deux Fragments fournis implémentent la restauration de leur état. Si on enlève la sauvegarde de l’état sur le ColorFragment sa couleur sera tout de même restaurée, comment pouvons-nous expliquer cela ?
On peut l'expliquer car certes la couleur n'est plus sauvegardée mais les états (position) des seekbars le sont automatiquement. Donc quand la vue est recrée le progress des seekbars est restauré, ce qui va trigger le `OnSeekBarChangeListener` et donc changer la couleur à celle définie par les seekbars. Restaurant ainsi la couleur sans l'avoir sauvegardée.

#### Si nous plaçons deux fois le CounterFragment dans l’Activité, nous aurons deux instances indépendantes de celui-ci. Comment est-ce que la restauration de l’état se passe en cas de rotation de l’écran ?
Comme pour un seul fragment. Ils sont certes de la même classe mais ces fragments sont bien 2 objets/entités distinctes. Le `FragmentManager` va sauvegarder et restaurer l'état de chacun de manière séparée.
