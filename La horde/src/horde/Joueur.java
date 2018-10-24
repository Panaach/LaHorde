package horde;

public class Joueur {
  int pointsDeVie = 100;
  int pointsAction = 6;
  String nom;
  boolean enVie = true;
  Case caseActuelle;
  
  public Joueur(String n, int pdv, int pa){
    this.nom = n;
    this.pointsDeVie = pdv;
    this.pointsAction = pa;
  }
}
