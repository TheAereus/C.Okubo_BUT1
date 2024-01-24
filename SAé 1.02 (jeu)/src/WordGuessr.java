import extensions.File;
class WordGuessr extends Program {

    final File fichierMenu = new File("./ressources/menu.txt");
    final File fichierParam = new File("./ressources/param.txt");

    Joueur NewJoueur(String nomJ){
        Joueur J = new Joueur();
        J.nom = nomJ;
        J.score = 0;
        J.nbJokerUtilise = 0;
        return J;
    }

    String convMaj(String mot){
        String resultat = "";
        for(int i=0; i<length(mot); i++){
            if(charAt(mot, i) >= 'a' && charAt(mot, i) <= 'z'){
                resultat += (char)(charAt(mot, i) - ('a' - 'A'));
            } else {
                resultat += charAt(mot, i);
            }
        }
        return resultat;
    }

    String dernieresLettres(String mot, int nbLettres){
        return substring(mot,length(mot)-nbLettres, length(mot));
    }

    boolean comparerPremieresLettres(String mot, String lettres){
        return equals(lettres, substring(mot, 0, length(lettres)));
    }

    void attendre(int tpsAttente){
        long t1 = getTime();
        while((getTime() - t1) != tpsAttente){
        }
    }


    void afficherInterface(String ecranActuel){
        //Largeur: 104 charactères
        //Hauteur: 39 charactères
        if(ecranActuel.equals("menu")){
            while(ready(fichierMenu)){
                println(readLine(fichierMenu));
            }
        } else
        if(ecranActuel.equals("param")){
            while(ready(fichierParam)){
                println(readLine(fichierParam));
            }
        } //else
        // if(ecranActuel.equals("lb")){
        // }
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

    int boucleEntreeNav(String entree, int )

    final String[] listeEcrans = new String[]{"quitter","menu","param","lb","jeu"};

    void algorithm(){
        int nbJoker
        boolean execution = true;
        while(execution){
            afficherInterface(listeEcrans[1]);
            print("                                                Entrée : ");
            String entreeJoueur = readString();
            int entreeInt = StringToInt(entreeJoueur);
            while(entreeInt == -1 || entreeInt > 3){
                afficherInterface(listeEcrans[1]);
                print("                         Votre entrée n'est pas valide! : ");
                entreeJoueur = readString();
                entreeInt = StringToInt(entreeJoueur);
            }
            if(entreeInt == 0){
                execution = false;
            }
            afficherInterface(listeEcrans[entreeInt]);
        }
        

        //boolean fini = false;
        //print("Entrez le nombre de lettres à prendre a chaque fin de mot : ");
        //int nbLettres = readInt();
        //attendre(5000);
        //print("\nJoueur 1, entrez votre mot : ");
        //String EntreeJoueur = convMaj(readString());
        //while(!fini){
        //    String syl = dernieresLettres(EntreeJoueur, nbLettres);
        //    print("Joueur 2, entrez un mot commençant en \"" + syl + "\" : ");
        //    EntreeJoueur = convMaj(readString());
        //    if(!comparerPremieresLettres(EntreeJoueur, syl)){
        //        fini = true;
        //        println("Joueur 2 a perdu!");
        //    } else {
        //        syl = dernieresLettres(EntreeJoueur, nbLettres);
        //        print("Joueur 1, entrez un mot commençant en \"" + syl + "\" : ");
        //        EntreeJoueur = convMaj(readString());
        //        if(!comparerPremieresLettres(EntreeJoueur, syl)){
        //            fini = true;
        //            println("Joueur 1 a perdu!");
        //        }
        //    }
        //}
    }
}


//Nom joueurs, points, leaderboard, comparaison de mots français (peut etre autres langues), graphiques, pas de doublons, idée de mot sur perte, forcément une terminaison/alternative, joker
//Si joker > 2 alors le joueur ne peut pas apparaitre sur le leaderboard
//PEUT ETRE: countdown, mode syllabes