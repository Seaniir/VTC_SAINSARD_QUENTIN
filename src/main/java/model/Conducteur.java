package model;

public class Conducteur {
    private int id;
    private String nom = "";
    private String prenom = "";

    public Conducteur(String nom, String prenom)
    {
        this.nom = nom;
        this.prenom = prenom;
    }
    public Conducteur(int id, String nom, String prenom)
    {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
