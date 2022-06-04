package dashbord.DAO;

import dashbord.models.Abonne;
import dashbord.models.Reservasion;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ReservationDAO {

    public List<Reservasion> all() {
        List<Reservasion> abonnes = new ArrayList<>();

        String findAllQuery = "SELECT * FROM reservation;";
        ResultSet rs = Database.getInstance().query(findAllQuery);

        try {

            while(rs.next()) {

                Reservasion p = new Reservasion();

                p.setId(rs.getInt("id"));
                p.setNom(rs.getString("nom"));
                p.setPrenom(rs.getString("prenom"));
                p.setHeure(rs.getString("heure"));
                p.setType(rs.getString("type"));

                abonnes.add(p);
            }

        } catch (Exception ex) {
            System.out.println("Problem in all - ReservationDAO" + ex);
        }
        System.out.println( );


        return abonnes;
    }

}
