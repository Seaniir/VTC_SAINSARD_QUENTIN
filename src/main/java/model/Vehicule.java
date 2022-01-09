package model;

public class Vehicule {

    private int id;
    private String marque = "";
    private String modele = "";
    private String couleur  = "";
    private String immatriculation = "";

    public Vehicule(String marque, String modele, String couleur, String immatriculation)
    {
        this.marque = marque;
        this.modele = modele;
        this.couleur = couleur;
        this.immatriculation = immatriculation;
    }

    public Vehicule(int id, String marque, String modele, String couleur, String immatriculation)
    {
        this.id = id;
        this.marque = marque;
        this.modele = modele;
        this.couleur = couleur;
        this.immatriculation = immatriculation;
    }

    public int getId() {
        return id;
    }

    public String getMarque() {
        return marque;
    }

    public String getModele() {
        return modele;
    }

    public String getCouleur() {
        return couleur;
    }

    public String getImmatriculation() {
        return immatriculation;
    }
}
