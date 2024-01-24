class test extends Program{
    void algorithm(){
        for(int i = 1; i <= 104 ; i++){
            print("⎯");
        }
        println();
        
        for(int i = 1; i <= 38 ; i++){
            print("│");
            if(i==14){
                for(int l = 1; l <= 45 ; l++){
                    print(" ");
                }
                print("1- Commencer");
                for(int l = 1; l <= 45 ; l++){
                    print(" ");
                }
            } else
            if(i == 18){
                for(int l = 1; l <= 45 ; l++){
                    print(" ");
                }
                print("2- Paramètres");
                for(int l = 1; l <= 44 ; l++){
                    print(" ");
                }
            } else
            if(i == 23){
                for(int l = 1; l <= 44 ; l++){
                    print(" ");
                }
                print("3- Leaderboard");
                for(int l = 1; l <= 44 ; l++){
                    print(" ");
                }
            } else
            if(i == 27){
                for(int l = 1; l <= 46 ; l++){
                    print(" ");
                }
                print("4- Quitter");
                for(int l = 1; l <= 46 ; l++){
                    print(" ");
                }
            } else {
                for(int l = 1; l <= 102 ; l++){
                    print(" ");
                }
            }
            println("│");
        }

        for(int i = 1; i <= 104 ; i++){
            print("⎺");
        }
        println();
        for(int i = 1; i <= 48 ; i++){
            print(" ");
        }
        print("Entrée : ");
        println();
    }
}