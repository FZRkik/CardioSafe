package dashbord.DAO;

import dashbord.models.Abonne;
import dashbord.models.Patient;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AbonneDAO {
    public List<Abonne> all() {
        List<Abonne> abonnes = new ArrayList<>();

        String findAllQuery = "SELECT * FROM abonne;";
        ResultSet rs = Database.getInstance().query(findAllQuery);

        try {

            while(rs.next()) {

                Abonne p = new Abonne();

                p.setId(rs.getInt("id_abonne"));
                p.setNom(rs.getString("nom"));
                p.setPrenom(rs.getString("prenom"));
                p.setDate(rs.getString("Date"));
                p.setType(rs.getString("type"));

                abonnes.add(p);
            }

        } catch (Exception ex) {
            System.out.println("Problem in all - PatientDAO" + ex);
        }
        System.out.println( );


        return abonnes;
    }
}
