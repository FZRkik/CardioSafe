package dashbord.DAO;

import dashbord.models.Allergy;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AllergyDAO {

    public Allergy find(String id) {

        Allergy allergy = new Allergy();

        String findQuery = "SELECT * FROM allergies"
                + " WHERE id_allergie =" + id + ";";

        ResultSet rs = Database.getInstance().query(findQuery);

        try {
            rs.next();
            allergy.setAllergyId(rs.getInt("id_allergie"));
            allergy.setAllergyName(rs.getString("nom_allergie"));

        } catch (Exception ex) {
            System.out.println("Error : AllergyDAO.find() " + ex);
        }

        return allergy;
    }

    public List<Allergy> all() {

        List<Allergy> allergies = new ArrayList<>();

        String findQuery = "SELECT * FROM allergies";

        ResultSet rs = Database.getInstance().query(findQuery);

        try {
            while(rs.next())
            {
                Allergy allergy= new Allergy();

                allergy.setAllergyId(rs.getInt("Id_allergie"));
                allergy.setAllergyName(rs.getString("nom_allergie"));
                allergies.add(allergy);
            }

        } catch (Exception ex) {
            System.out.println("Error : AllergyDAO.all() " + ex);
        }

        return allergies;
    }

    public boolean create(Allergy allergy) {

        String insertQuery = "INSERT INTO allergies(nom_allergie) VALUES("
                + "'" + allergy.getAllergyName() + "'); ";

        return (Database.getInstance().dmlQuery(insertQuery) != 0);
    }



    public boolean update(Allergy allergy) {

        String insertQuery = "UPDATE allergies "
                + "SET nom_allergie = '" + allergy.getAllergyName() + "' "
                + "WHERE id_allergie = " + allergy.getAllergyId() + ";";

        return (Database.getInstance().dmlQuery(insertQuery) != 0);
    }



    public boolean delete(Allergy allergy) {

        String deleteQuery = "DELETE FROM allergies "
                + "WHERE id_allergie = " +  allergy.getAllergyId() + ";";

        return (Database.getInstance().dmlQuery(deleteQuery) != 0);
    }


    public List<Allergy> all(int consultationId) {

        List<Allergy> allergies = new ArrayList<>();

        String findQuery = "SELECT  allergies.id_allergie, allergies.nom_allergie ,renseigne.id_consultation "
                + " from allergies inner join renseigne "
                + " on allergies.id_allergie= renseigne.id_allergie"
                + " where renseigne.id_consultation="+consultationId+";";

        ResultSet rs = Database.getInstance().query(findQuery);

        try {
            while(rs.next())
            {
                Allergy allergy= new Allergy();

                allergy.setAllergyId(rs.getInt("Id_allergie"));
                allergy.setAllergyName(rs.getString("nom_allergie"));
                allergies.add(allergy);
            }

        } catch (Exception ex) {
            System.out.println("Error : AllergyDAO.all(int ) " + ex);
        }

        return allergies;
    }

}
