package dashbord.DAO;

import dashbord.models.Drug;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DrugDAO {

    public Drug find(String id) {

        Drug drug = new Drug();

        String findQuery = "SELECT * FROM medicaments"
                + " WHERE id_medicament =" + id + ";";

        ResultSet rs = Database.getInstance().query(findQuery);

        try {
            rs.next();
            drug.setDrugId(rs.getInt("id_medicament"));
            drug.setDrugName(rs.getString("nom_medicament"));

        } catch (Exception ex) {
            System.out.println("Error : DrugDAO.find() " + ex);
        }

        return drug;
    }



    public List<Drug> all() {

        List<Drug> medicaments = new ArrayList<>();

        String findQuery = "SELECT * FROM medicaments";

        ResultSet rs = Database.getInstance().query(findQuery);

        try {

            while(rs.next()) {
                Drug drug= new Drug();
                drug.setDrugId(rs.getInt("id_medicament"));
                drug.setDrugName(rs.getString("nom_medicament"));
                medicaments.add(drug);
            }

        } catch (Exception ex) {
            System.out.println("Error : DrugDAO.all() " + ex);
        }

        return medicaments;
    }



    public boolean create(Drug drug) {

        String insertQuery = "INSERT INTO medicaments(nom_medicament) "
                + "VALUES("
                + "'" + drug.getDrugName()
                + "'); ";

        return (Database.getInstance().dmlQuery(insertQuery) != 0);
    }


    public boolean update(Drug drug) {

        String insertQuery = "UPDATE medicaments "
                + " set nom_medicament = '" + drug.getDrugName()+"' "
                + " WHERE id_medicament = " + drug.getDrugId() + ";";

        return (Database.getInstance().dmlQuery(insertQuery) != 0);
    }


    public boolean delete(Drug drug) {

        String deleteQuery = "DELETE FROM medicaments "
                + "WHERE id_medicament = " + drug.getDrugId() + ";";

        return (Database.getInstance().dmlQuery(deleteQuery) != 0);
    }


    public List<Drug> all(int consultationID) {

        List<Drug> medicaments = new ArrayList<>();

        String findQuery =  "SELECT  medicaments.id_medicament, medicaments.nom_medicament,introduit.desc_medicament "
                + "from medicaments inner join introduit on  medicaments.id_medicament = introduit.id_medicament "
                + "where introduit.id_consultation ="+consultationID+";";

        ResultSet rs = Database.getInstance().query(findQuery);

        try {

            while(rs.next()) {
                Drug drug= new Drug();
                drug.setDrugId(rs.getInt("id_medicament"));
                drug.setDrugName(rs.getString("nom_medicament"));
                drug.setDrugDescription(rs.getString("desc_medicament"));
                medicaments.add(drug);
            }

        } catch (Exception ex) {
            System.out.println("Error : DrugDAO.all() " + ex);
        }

        return medicaments;
    }

}
