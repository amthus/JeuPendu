
### **Projet : Jeu du Pendu**

#### **Objectif :**
Développer un jeu du pendu en Java avec une gestion des dix meilleurs scores, une interface graphique interactive, et un système de points basé sur la réussite des mots trouvés et des erreurs commises.

---

### **Structure du Projet :**

```plaintext
PenduGame/
│
├── src/
│   ├── main/
│   │   ├── jeu/
│   │   │   ├── HangmanGame.java           // Classe principale du jeu
│   │   │   ├── MenuBar.java               // Menu principal et sous-menus
│   │   │   ├── ScoreManager.java          // Gestion des scores
│   │   │   ├── GameOverDialog.java        // Boîte de dialogue de fin de jeu
│   │   │   ├── AboutDialog.java           // Fenêtre "À propos"
│   │   │   ├── MainPage.java              // Page d'accueil
│   │   │   └── Player.java                // Classe pour gérer les joueurs
│   │   ├── resources/
│   │   │   ├── dictionnaire.txt          // Dictionnaire des mots pour le jeu
│   │   │   ├── scores.txt                // Fichier de sauvegarde des scores
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
│   │   
├── README.md                                // Description du projet
└── .gitignore                               // Fichiers à ignorer par Git
```

---

### **Fonctionnalités :**

#### 1. **Interface d'accueil :**
   - **Onglets principaux :** *Fichier* et *À propos*.
   - **Sous-menus du menu Fichier :**
     - *Nouveau* : Démarre une nouvelle partie.
     - *Scores* : Affiche les meilleurs scores enregistrés.
     - *Règles* : Affiche les règles du jeu.
   
   - **Page d'accueil :**
     - Présentation des menus *Fichier* et *À propos*. En cliquant sur *Fichier*, les sous-menus (Nouveau, Scores, Règles) apparaissent.

#### 2. **Calcul des Points :**
   - **Calcul des points en fonction des mots trouvés et des erreurs :**
     - Mot trouvé sans erreur : **100 pts**
     - Mot trouvé avec 1 erreur : **50 pts**
     - Mot trouvé avec 2 erreurs : **35 pts**
     - Mot trouvé avec 3 erreurs : **25 pts**
     - Mot trouvé avec 4 erreurs : **15 pts**
     - Mot trouvé avec 5 erreurs : **10 pts**
     - Mot trouvé avec 6 erreurs : **5 pts**
   - Les points sont cumulés à chaque mot trouvé, en fonction des erreurs commises.

#### 3. **Gestion des Scores :**
   - Vérification si le score du joueur fait partie du top 10 :
     - Si le score du joueur entre dans le top 10, il est invité à entrer son pseudo pour enregistrer ses points.
     - Si le score ne figure pas dans le top 10, le joueur est redirigé vers la page d'accueil.

#### 4. **Démarrer une Partie :**
   - À chaque mot trouvé, une nouvelle partie commence avec un mot caché différent.
   - Si le joueur atteint la limite des 7 erreurs sans trouver le mot, une boîte de dialogue *Game Over* apparaît.

#### 5. **Fenêtre "À propos" :**
   - Le menu *À propos* affiche les informations suivantes :
     - **Le jeu du Pendu :** "Vous avez 7 coups pour trouver le mot caché! Et si vous réussissez, on recommence! Plus vous avez trouvé de mots, plus votre score grandira!!"
     - **Le système de points :** Détaille la manière dont les points sont calculés en fonction des erreurs.
     - **Dictionnaire :** Le jeu utilise un dictionnaire de plus de **336 000 mots**, donc bonne chance pour trouver un mot en un coup!

#### 6. **Nom du joueur :**
   - Avant chaque partie, le jeu demande le nom du joueur pour enregistrer ses scores au fur et à mesure de la journée.

---

### **Répartition des Classes :**

#### 1. **MainPage.java** - Page d'accueil
   Cette classe gère l'écran principal du jeu, qui s'affiche au lancement. Elle comprend un bouton pour démarrer une nouvelle partie et des options pour accéder à d'autres fenêtres (classement des scores, "À propos").

#### 2. **HangmanGame.java** - Classe principale du jeu
   Cette classe contient la logique du jeu du pendu : chargement des mots, gestion des tentatives, mise à jour du mot caché, affichage des erreurs, et fin de la partie. Elle gère aussi l'interface utilisateur.

#### 3. **MenuBar.java** - Menu principal et sous-menus
   Cette classe affiche le menu principal avec les sous-menus permettant de démarrer une nouvelle partie, afficher les scores et accéder à d'autres fonctionnalités comme "À propos".

#### 4. **ScoreManager.java** - Gestion des scores
   Cette classe gère les scores des joueurs, leur enregistrement à la fin de chaque partie, et l'affichage des classements. Elle permet aussi de sauvegarder et de charger les scores dans un fichier.

#### 5. **GameOverDialog.java** - Boîte de dialogue de fin de jeu
   Cette classe affiche une fenêtre de dialogue à la fin du jeu pour annoncer la victoire ou la défaite, avec des options pour recommencer ou quitter.

#### 6. **AboutDialog.java** - Fenêtre "À propos"
   Cette classe affiche les informations du jeu, incluant la version, le créateur, une brève description et des crédits.

#### 7. **Player.java** - Classe représentant un joueur
   Cette classe représente un joueur, stocke son nom, son score actuel, et éventuellement des statistiques telles que le nombre de parties gagnées.

---

### **Conclusion :**
Ce projet offre une architecture bien définie et modulaire, facilitant la gestion des fonctionnalités du jeu et des scores. L'expérience utilisateur est enrichie par la gestion des erreurs, la présentation des règles, et un système de sauvegarde des scores. Ce jeu du pendu est un projet complet et stimulant à développer avec une interface graphique interactive.

