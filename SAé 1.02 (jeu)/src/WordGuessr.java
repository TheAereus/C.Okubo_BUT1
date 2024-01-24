import extensions.File;
class WordGuessr extends Program {

    Joueur NewJoueur(String nomJ){
        Joueur J = new Joueur();
        J.nom = nomJ;
        J.score = 0;
        J.nbJokerUtilise = 0;
        return J;
    }

    String dernieresLettres(String mot, int nbLettres){
        return substring(mot,length(mot)-nbLettres, length(mot));
    }

    boolean comparerPremieresLettres(String mot, String lettres){
        return equals(lettres, substring(mot, 0, length(lettres)));
    }

    void afficherInterface(String ecranActuel){
        //Largeur: 104 charactères
        //Hauteur: 39 charactères
        final File fichierMenu = new File("./ressources/menu.txt");
        final File fichierParam = new File("./ressources/param.txt");
        final File fichierInitJeu = new File("./ressources/initJeu.txt");
        if(ecranActuel.equals("initJeu")){
            int compteur = 1;
            while(ready(fichierInitJeu)){
                if(compteur == 16){
                    println(readLine(fichierInitJeu) + joueur1.nom + readLine(fichierInitJeu) + joueur2.nom + readLine(fichierInitJeu));
                } else
                if(compteur == 20){
                    println(readLine(fichierInitJeu) + nbParamJoker + readLine(fichierInitJeu));
                } else
                if(compteur == 25){
                    println(readLine(fichierInitJeu) + nbParamLettres + readLine(fichierInitJeu));
                }
                else {
                    println(readLine(fichierInitJeu));
                    
                }
                compteur ++;
            }
        } else
        if(ecranActuel.equals("menu")){
            while(ready(fichierMenu)){
                println(readLine(fichierMenu));
            }
        } else
        if(ecranActuel.equals("param")){
            int compteur = 1;
            String affValeurParam = "";
            while(ready(fichierParam)){
                if(compteur == 17){
                    println(readLine(fichierParam) + nbParamLettres + readLine(fichierParam));
                } else
                if(compteur == 20){
                    println(readLine(fichierParam) + nbParamJoker + readLine(fichierParam));
                }
                else {
                    println(readLine(fichierParam));
                }
                compteur ++;
            }
        }
    }

    boolean checkEntreeNumerique(String entree){
        boolean resultat = true;
        if(length(entree) != 1){
            resultat = false;
        } else 
        if(charAt(entree, 0) < '0' || charAt(entree, 0) > '9'){
            resultat = false;
        }    
        return resultat;
    }

    int StringToInt(String chaine){
        int resultat = -1;
        if(checkEntreeNumerique(chaine)){
            resultat = charAt(chaine,0) - '0';
        }
        return resultat;
    }

    int boucleEntree(String ecran, int entree, int entreeMin, int entreeMax){
        entree = StringToInt(readString());
        while(entree < entreeMin || entree > entreeMax){
            afficherInterface(ecran);
            print("                         Votre entrée n'est pas valide! : ");
            entree = StringToInt(readString());
        }
        return entree;
    }

    void decalage(String[] liste, String chaine){
        for(int i = length(liste)-1; i >= 1; i--){
            liste[i] = liste[i-1];
        }
        liste[0] = chaine;
    }

    boolean checkMotFr(String mot){
        File fichierMots = new File("./ressources/ListeMots.txt");
        mot = toLowerCase(mot);
        boolean resultat = false;
        while(ready(fichierMots) && !resultat){
            if(equals(readLine(fichierMots), mot)){
                resultat = true;
            }
        }
        return resultat;
    }

    void foncJeu(){
        int entreeInt = -1;
        while (entreeInt!=0){
            afficherInterface("initJeu");
            print("                                                Entrée : ");
            entreeInt = boucleEntree("menu", entreeInt, 0, 3);
            if(entreeInt == 1 || entreeInt == 2){
                afficherInterface("initJeu");
                print("             Entrez le nom du joueur " + entreeInt + " (5 charactères) : ");
                String nom = readString();
                while(length(nom) != 5){
                    afficherInterface("initJeu");
                    print("                   Le nom doit faire 5 charactères : ");
                    nom = readString();
                }
                if(entreeInt == 1){
                    joueur1.nom = toUpperCase(nom);
                } else
                if(entreeInt == 2){
                    joueur2.nom = toUpperCase(nom);
                }
            } else
            if(entreeInt == 3){
                boolean fini = false;
                String[] listeMots = new String[18];
                int tourJoueur = 1;
                while(!fini){
                    final File fichierBasJeu = new File("./ressources/partieBasseJeu.txt");
                    for(int i = 0; i < 104; i++){
                        print("⎯");
                    }
                    println();
                    for(int i = 17; i >= 0; i--){
                        int nbEspaces = 102;
                        if(listeMots[i] == null){
                            print("│");
                            for(int l = 0; l < nbEspaces; l++){
                                print(" ");
                            }
                            print("│");
                        } else {
                            nbEspaces -= length(listeMots[i]);
                            print("│");
                            for(int l = 0; l < nbEspaces/2; l++){
                                print(" ");
                            }
                            print(listeMots[i]);
                            if(length(listeMots[i])%2==1){
                                nbEspaces ++;
                            }
                            for(int l = 0; l < nbEspaces/2; l++){
                                print(" ");
                            }
                            print("│");
                        }
                        println();
                    }
                    int compteur = 1;
                    while(ready(fichierBasJeu)){
                        println(readLine(fichierBasJeu));
                        if(tourJoueur == 1 && compteur == 1){
                            println(readLine(fichierBasJeu) + joueur1.nom + readLine(fichierBasJeu));
                        } else
                        if(tourJoueur == 2 && compteur == 1){
                            println(readLine(fichierBasJeu) + joueur2.nom + readLine(fichierBasJeu));
                        }
                        compteur ++;
                    }
                    if(syl == ""){
                        print("                                      Entrez votre mot : ");
                    }
                    else{
                        print("                         Entrez un mot commenceant en " + syl + " : ");
                    }
                    String mot = readString();
                    if(equals(toLowerCase(mot), "joker")){
                        if(tourJoueur == 1){
                            if(joueur1.nbJokerUtilise >= nbParamJoker){
                                println("                                Pas de joker disponible !");
                                mot = "";
                            } 
                            else{
                                joueur1.nbJokerUtilise ++;
                                boolean motAleatoireTrouve = false;
                                while(!motAleatoireTrouve){
                                    File motsTemp = new File("./ressources/ListeMots.txt");
                                    while(ready(motsTemp) && !motAleatoireTrouve){
                                        mot = readLine(motsTemp);
                                        double chiffreAleatoire = random();
                                        if(chiffreAleatoire <= 0.0001){
                                            motAleatoireTrouve = true;
                                        }
                                    }
                                }
                            }
                        } else
                        if(tourJoueur == 2){
                            if(joueur2.nbJokerUtilise >= nbParamJoker){
                                println("                                     Pas de joker disponible !");
                                mot = "";
                            } 
                            else{
                                joueur2.nbJokerUtilise ++;
                                boolean motAleatoireTrouve = false;
                                while(!motAleatoireTrouve){
                                    File motsTemp = new File("./ressources/ListeMots.txt");
                                    while(ready(motsTemp) && !motAleatoireTrouve){
                                        mot = readLine(motsTemp);
                                        double chiffreAleatoire = random();
                                        if(chiffreAleatoire <= 0.01){
                                            motAleatoireTrouve = true;
                                        }
                                    }
                                }
                            }
                        }
                    } else 
                    if(length(mot) < nbParamLettres || !checkMotFr(mot) || !comparerPremieresLettres(mot, syl)){
                        if(tourJoueur == 1){
                            println("\n\n                                   Mot invalide, " + joueur1.nom + " a perdu");
                        } else
                        if(tourJoueur == 2){
                            println("\n\n                                   Mot invalide, " + joueur2.nom + " a perdu");
                        }
                        fini = true;
                    }
                    if(!fini && !equals(mot, "")){
                        decalage(listeMots, mot);
                        if(tourJoueur == 1){
                            joueur1.score += length(mot);
                            tourJoueur = 2;
                        } else
                        if(tourJoueur == 2){
                            joueur2.score += length(mot);
                            tourJoueur = 1;
                        }
                    }
                    syl = dernieresLettres(mot, nbParamLettres);
                }
            }
        }
    }

    int foncMenu(){
        int entreeInt = 0;
        afficherInterface("menu");
        print("                                                Entrée : ");
        entreeInt = boucleEntree("menu", entreeInt, 0, 2);
        return entreeInt;
    }

    void foncParam(){
        int entreeInt = -1;
        while(entreeInt != 3){
            afficherInterface("param");
            print("                                                Entrée : ");
            entreeInt = boucleEntree("param", entreeInt, 1, 3);
            if(entreeInt == 1){
                afficherInterface("param");
                print("           Entrez la valeur que vous souhaitez choisir : ");
                entreeInt = boucleEntree("param", entreeInt, 1, 9);
                nbParamLettres = entreeInt;
            } else
            if(entreeInt == 2){
                afficherInterface("param");
                print("           Entrez la valeur que vous souhaitez choisir : ");
                entreeInt = boucleEntree("param", entreeInt, 1, 9);
                nbParamJoker = entreeInt;
            }
        }
    }

    int nbParamJoker = 2;
    int nbParamLettres = 2;
    Joueur joueur1 = NewJoueur("XXXXX");
    Joueur joueur2 = NewJoueur("XXXXX");
    String syl = "";

    void algorithm(){
        boolean execution = true;
        while(execution){
            int prochainEcran = foncMenu();
            if(prochainEcran == 0){
                execution = false;
            } else
            if(prochainEcran == 1){
                foncJeu();
            } else
            if(prochainEcran == 2){
                foncParam();
            }
        }
    }
}