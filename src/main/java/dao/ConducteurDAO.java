package dao;

import model.Conducteur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConducteurDAO implements  IDAO<Conducteur>{
    Connection connect = Connect.getConnection();
    ResultSet rs = null;

    @Override
    public boolean create(Conducteur object) {
        boolean msg = false;
        try {
            PreparedStatement req = connect.prepareStatement("INSERT INTO conducteur (nom, prenom)"
                    + "VALUES (?,?)");
            req.setString(1, object.getNom());
            req.setString(2, object.getPrenom());

            System.out.println(req);

            req.executeUpdate();

            System.out.println(object.getPrenom() + " " + object.getNom() + " à bien été ajouté en BDD");
            msg = true;

        }catch (Exception e) {
            System.out.println("Insertion KO");
        }
        return msg;
    }

    @Override
    public List<Conducteur> read() {
        List<Conducteur> liste = new ArrayList<>();
        try {
            PreparedStatement req = connect.prepareStatement("SELECT * FROM conducteur");

            rs = req.executeQuery();

            while(rs.next()) {
                Conducteur conducteur = new Conducteur(rs.getInt("id_conducteur"), rs.getString("nom"), rs.getString("prenom"));
                liste.add(conducteur);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return liste;
    }

    @Override
    public void update(Conducteur object) {

    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement req = connect.prepareStatement("DELETE FROM conducteur WHERE id_conducteur=?");
            req.setInt(1, id);
            //System.out.println(req);
            req.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public Conducteur findById(int id) {

        Conducteur conduById = null;

        try {
            PreparedStatement req = connect.prepareStatement("SELECT * FROM conducteur WHERE id_conducteur=?");
            req.setInt(1, id);
            rs = req.executeQuery();
            while(rs.next()) {
                conduById = new Conducteur(rs.getInt("id_conducteur"),rs.getString("nom"), rs.getString("prenom"));
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return conduById;
    }

    @Override
    public List<Conducteur> findByName(String nom) {
        return null;
    }
}
