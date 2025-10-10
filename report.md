### Exercice 2
#### Les deux Fragments fournis implémentent la restauration de leur état. Si on enlève la sauvegarde de l’état sur le ColorFragment sa couleur sera tout de même restaurée, comment pouvons-nous expliquer cela ?
On peut l'expliquer car certes la couleur n'est plus sauvegardée mais les états (position) des seekbars le sont automatiquement. Donc quand la vue est recrée le progress des seekbars est restauré, ce qui va trigger le `OnSeekBarChangeListener` et donc changer la couleur à celle définie par les seekbars. Restaurant ainsi la couleur sans l'avoir sauvegardée.

#### Si nous plaçons deux fois le CounterFragment dans l’Activité, nous aurons deux instances indépendantes de celui-ci. Comment est-ce que la restauration de l’état se passe en cas de rotation de l’écran ?
Comme pour un seul fragment. Ils sont certes de la même classe mais ces fragments sont bien 2 objets/entités distinctes. Le `FragmentManager` va sauvegarder et restaurer l'état de chacun de manière séparée.