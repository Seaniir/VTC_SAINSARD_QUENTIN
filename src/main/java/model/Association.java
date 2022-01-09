package model;

public class Association {
    private int id;
    private int id_conducteur;
    private int id_vehicule;
    private String nomConducteur;
    private String prenomConducteur;
    private String marqueVehicule;
    private String modeleVehicule;

    public Association(int id_conducteur, int id_vehicule)
    {
        this.id_conducteur = id_conducteur;
        this.id_vehicule = id_vehicule;
    }

    public Association(int id, int id_conducteur, int id_vehicule)
    {
        this.id = id;
        this.id_conducteur = id_conducteur;
        this.id_vehicule = id_vehicule;
    }
    public Association(int id, int id_conducteur, int id_vehicule, String nomConducteur, String prenomConducteur, String marqueVehicule, String modeleVehicule)
    {
        this.id = id;
        this.id_conducteur = id_conducteur;
        this.id_vehicule = id_vehicule;
        this.nomConducteur = nomConducteur;
        this.prenomConducteur = prenomConducteur;
        this.marqueVehicule = marqueVehicule;
        this.modeleVehicule = modeleVehicule;
    }

    public int getId() {
        return id;
    }

    public int getId_conducteur() {
        return id_conducteur;
    }

    public int getId_vehicule() {
        return id_vehicule;
    }

    public String getNomConducteur() {
        return nomConducteur;
    }

    public String getPrenomConducteur() {
        return prenomConducteur;
    }

    public String getMarqueVehicule() {
        return marqueVehicule;
    }

    public String getModeleVehicule() {
        return modeleVehicule;
    }
}
