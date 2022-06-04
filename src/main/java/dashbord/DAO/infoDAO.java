package dashbord.DAO;

import dashbord.models.Abonne;
import dashbord.models.information;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class infoDAO {

    public List<information> all() {
        List<information> abonnes = new ArrayList<>();

        String findAllQuery = "SELECT * FROM informations;";
        ResultSet rs = Database.getInstance().query(findAllQuery);

        try {

            while(rs.next()) {

                information p = new information();

                p.setPression(rs.getString("pression"));
                p.setBC(rs.getString("BC"));
                p.setMouvement(rs.getString("mouvement"));

                abonnes.add(p);
            }

        } catch (Exception ex) {
            System.out.println("Problem in all - PatientDAO" + ex);
        }
        System.out.println( );


        return abonnes;
    }
}
