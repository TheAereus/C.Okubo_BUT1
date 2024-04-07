README du Projet I.S.R S2.03
Par : Hugo DESMONS
      Camille Okubo

-----------------------------------
Ce dossier contient:
-Les rapports de chaques partie en format .md
-Le rapport final contenant toute les parties en .md , .pdf , .html
-Les images neccessaires a ces rapport
-Le pandoc.css permetant la géneration d'un beau rapport en .html


-----------------------------------
Compilation:
Ligne compilation html :pandoc --toc --toc-depth=2 --standalone Rapport.md -o rapport.html -c rapport.css --metadata title="Rapports S2.03 I.S.R"
Ligne compilation pdf :pandoc --toc --toc-depth=2 --standalone Rapport.md -o rapport.pdf --metadata title="Rapports S2.03 I.S.R"

Explication des options :
--toc = Génere une table des matières en haut du rapport
--toc-depth = Definie la taille de la table des matières
--standalone = Permet le fonctionnemant de certaines options
Rapport.md = Fichier d'entrée
-o sortie = Fichier de sortie
-c css = Css utilisé pour l'html
--metadata title = Titre du rapport

-----------------------------------
Notes:

Ce rapport final n'as été produit uniquement par 2 étudiants, car le troisième a arreté le cursus au milieu de la Saé.
Ce qui fait que le premier rapport a été refait entiérement, ce qui a entrainé du retard.
