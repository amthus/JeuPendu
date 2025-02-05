Commande ECHO activ�e.
Voici une version optimisée et améliorée de votre description du jeu du pendu avec l'architecture suggérée :

---

### Projet : Jeu du Pendu

#### Objectif :
Vous devez développer un jeu du pendu en Java qui gère la sauvegarde des dix meilleurs scores, avec une interface graphique interactive et un système de gestion des points basé sur la réussite des mots trouvés et des erreurs commises.

### Structure du projet :

```plaintext
PenduGame/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/
│   │   │   │   ├── jeu/
│   │   │   │   │   ├── HangmanGame.java           // Classe principale du jeu
│   │   │   │   │   ├── MenuBar.java               // Menu principal et sous-menus
│   │   │   │   │   ├── ScoreManager.java          // Gestion des scores
│   │   │   │   │   ├── GameOverDialog.java        // Boîte de dialogue de fin de jeu
│   │   │   │   │   ├── AboutDialog.java           // Fenêtre "À propos"
│   │   │   │   │   ├── MainPage.java              // Page d'accueil
│   │   │   │   │   └── Player.java                // Classe pour gérer les joueurs
│   │   ├── resources/
│   │   │   ├── dictionnaire.txt                  // Dictionnaire des mots pour le jeu
│   │   │   ├── scores.txt                        // Fichier de sauvegarde des scores
│   │   │   ├── images/
│   │   │   │   ├── pendu-0.png
│   │   │   │   ├── pendu-1.png
│   │   │   │   ├── pendu-2.png
│   │   │   │   ├── pendu-3.png
│   │   │   │   ├── pendu-4.png
│   │   │   │   ├── pendu-5.png
│   │   │   │   ├── pendu-6.png
│   │   │   │   ├── victory.png
│   │   │   │   └── defeat.png
│   │   └── web/
│   │       └── (autres ressources si besoin)
├── README.md                                      // Description du projet
└── .gitignore                                     // Fichiers à ignorer par Git
```

### Fonctionnalités :

#### 1. **Interface d'accueil :**
   - **Onglets principaux :** *Fichier* et *À propos*.
   - **Sous-menus du menu Fichier :**
     - *Nouveau* : Démarre une nouvelle partie.
     - *Scores* : Affiche les meilleurs scores enregistrés.
     - *Règles* : Affiche les règles du jeu.
   
   - **Page d'accueil :**
     - La page d’accueil présente les deux menus *Fichier* et *À propos*. En cliquant sur le menu *Fichier*, les sous-menus (Nouveau, Scores, Règles) apparaissent.
   
#### 2. **Calcul des Points :**
   - Les points sont calculés en fonction des mots trouvés et des erreurs commises :
     - Mot trouvé sans erreur : **100 pts**
     - Mot trouvé avec 1 erreur : **50 pts**
     - Mot trouvé avec 2 erreurs : **35 pts**
     - Mot trouvé avec 3 erreurs : **25 pts**
     - Mot trouvé avec 4 erreurs : **15 pts**
     - Mot trouvé avec 5 erreurs : **10 pts**
     - Mot trouvé avec 6 erreurs : **5 pts**
   
   - Le score est cumulé à chaque mot trouvé, en tenant compte des erreurs.

#### 3. **Gestion des Scores :**
   - Le système vérifie si le joueur est dans le top 10 des meilleurs scores :
     - Si le score du joueur le place dans le top 10, il est invité à entrer son pseudo pour enregistrer ses points.
     - Si le score ne figure pas dans le top 10, le joueur est redirigé vers la page d'accueil.
   
#### 4. **Démarrer une Partie :**
   - À chaque fois qu’un joueur trouve un mot, le jeu recommence avec un nouveau mot caché.
   - Si le joueur atteint la limite des 7 erreurs sans avoir trouvé le mot, une boîte de dialogue *Game Over* s’affiche.
   
#### 5. **Fenêtre "À propos" :**
   - Le menu *À propos* affiche les informations suivantes :
     - **Le jeu du Pendu :** "Vous avez 7 coups pour trouver le mot caché! Et si vous réussissez, on recommence! Plus vous avez trouvé de mots, plus votre score grandira!!"
     - **Le système de points :** Détaille la façon dont les points sont calculés selon les erreurs commises.
     - **Dictionnaire :** Le jeu utilise un dictionnaire de plus de **336 000 mots**, donc bonne chance pour trouver un mot en un coup!

#### 6. **Nom du joueur :**
   - Avant chaque partie, le jeu demande le nom du joueur pour enregistrer ses scores au fur et à mesure de la journée.
   
---

### Répartition des classes :

Voici un aperçu détaillé de chaque fichier mentionné dans la structure de votre projet :

### 1. **HangmanGame.java** - Classe principale du jeu
   Cette classe gère l'ensemble du jeu du pendu. Elle contient la logique de jeu, y compris le chargement des mots, la gestion des tentatives, la mise à jour du mot à deviner, l'affichage de l'image du pendu, et la fin de la partie. Elle se charge également de l'interface utilisateur, en affichant des informations telles que le mot caché et les tentatives restantes.

### 2. **MenuBar.java** - Menu principal et sous-menus
   Cette classe est responsable de l'affichage du menu en haut de l'application. Elle gère les interactions avec l'utilisateur pour lancer une nouvelle partie, afficher les scores, et accéder à d'autres fonctionnalités comme "À propos". Elle peut également inclure des sous-menus pour des fonctionnalités supplémentaires, comme un menu de configuration.

### 3. **ScoreManager.java** - Gestion des scores
   Cette classe gère les scores des joueurs. Elle peut enregistrer les scores des joueurs à chaque fin de partie et les afficher sous forme de classement. Cela peut inclure la lecture/écriture des scores dans un fichier pour qu'ils persistent entre les sessions de jeu, ainsi que des méthodes pour obtenir et mettre à jour les scores.

### 4. **GameOverDialog.java** - Boîte de dialogue de fin de jeu
   Cette classe affiche une fenêtre de dialogue lorsque la partie est terminée. Elle peut afficher un message de victoire ou de défaite, selon le résultat du jeu, ainsi que des options pour recommencer ou quitter le jeu.

### 5. **AboutDialog.java** - Fenêtre "À propos"
   Cette classe gère l'affichage d'une fenêtre d'information sur le jeu. Elle peut contenir des informations telles que la version du jeu, le nom du créateur, une brève description du jeu, et éventuellement des crédits.

### 6. **MainPage.java** - Page d'accueil
   Cette classe est responsable de l'écran principal du jeu, qui est affiché au lancement. Elle peut inclure un bouton pour commencer une nouvelle partie, afficher des informations sur le jeu, ou proposer des options pour accéder à d'autres fenêtres comme le classement des scores ou "À propos".

### 7. **Player.java** - Classe représentant un joueur
   Cette classe représente un joueur dans le jeu. Elle pourrait contenir des informations comme le nom du joueur, le score actuel, et éventuellement des statistiques de jeu, comme le nombre de parties gagnées, les tentatives restantes, etc. Cela peut aussi inclure des méthodes pour modifier ou récupérer ces informations.

---


### Conclusion :

Ce projet utilise une architecture claire et bien définie, permettant une gestion facile du jeu et de ses fonctionnalités. Le stockage des scores, la gestion des erreurs et la présentation des règles offrent une expérience utilisateur agréable et stimulante.