package dashbord.DAO;

import dashbord.models.Patient;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO {


    public Patient find(String id) {
        Patient p = new Patient();

        String findQuery = "SELECT * FROM patients"
                + " WHERE id_patient =" + id + ";";

        ResultSet rs = Database.getInstance().query(findQuery);

        try {
            rs.next();
            p.setPatientId(rs.getInt("id_patient"));
            p.setLastName(rs.getString("nom_patient"));
            p.setName(rs.getString("prenom_patient"));
            p.setBirthDate(rs.getDate("date_naissance"));
            p.setAddress(rs.getString("adresse"));
            p.setCity(rs.getString("ville"));
            p.setCin(rs.getString("cin"));
            p.setSexe(rs.getString("sexe"));
            p.setTelephone(rs.getString("telephone"));
            p.setCredit(rs.getDouble("credit"));

        } catch (Exception ex) {
            System.out.println("Problem in find - PatientDAO" + ex);
        }

        return p;

    }


    public List<Patient> all() {
        List<Patient> patients = new ArrayList<>();

        String findAllQuery = "SELECT * FROM patients;";
        ResultSet rs = Database.getInstance().query(findAllQuery);

        try {

            while(rs.next()) {

                Patient p = new Patient();

                p.setPatientId(rs.getInt("id_patient"));
                p.setLastName(rs.getString("nom_patient"));
                p.setName(rs.getString("prenom_patient"));
                p.setBirthDate(rs.getDate("date_naissance"));
                p.setAddress(rs.getString("adresse"));
                p.setCity(rs.getString("ville"));
                p.setSexe(rs.getString("sexe"));
                p.setCin(rs.getString("cin"));
                p.setTelephone(rs.getString("telephone"));
                p.setCredit(rs.getDouble("credit"));

                patients.add(p);
            }

        } catch (Exception ex) {
            System.out.println("Problem in all - PatientDAO" + ex);
        }

        return patients;
    }

    public List<Patient> like(String like) {

        List<Patient> patients = new ArrayList<>();

        String findLikeQuery = "SELECT * FROM patients " +
                "WHERE nom_patient LIKE '%" + like + "%' OR prenom_patient LIKE '%" + like + "%';";
        ResultSet rs = Database.getInstance().query(findLikeQuery);

        try {

            while(rs.next()) {

                Patient p = new Patient();

                p.setPatientId(rs.getInt("id_patient"));
                p.setLastName(rs.getString("nom_patient"));
                p.setName(rs.getString("prenom_patient"));
                p.setBirthDate(rs.getDate("date_naissance"));
                p.setAddress(rs.getString("adresse"));
                p.setCity(rs.getString("ville"));
                p.setSexe(rs.getString("sexe"));
                p.setCin(rs.getString("cin"));
                p.setTelephone(rs.getString("telephone"));
                p.setCredit(rs.getDouble("credit"));

                patients.add(p);
            }

        } catch (Exception ex) {
            System.out.println("Problem in all - PatientDAO" + ex);
        }

        return patients;
    }


    public boolean create(Patient p) {
        String insertQuery = "INSERT INTO patients(nom_patient, prenom_patient, "
                + "date_naissance, telephone, adresse,ville, sexe,cin, credit) VALUES("
                + "'" + p.getLastName()      + "', "
                + "'" + p.getName()          + "', "
                + "'" + p.getBirthDate()     + "', "
                + "'" + p.getTelephone()     + "', "
                + "'" + p.getAddress()       + "', "
                + "'" + p.getCity()          + "', "
                + "'" + p.getSexe()          + "', "
                + "'" + p.getCin()           + "', "
                + p.getCredit()              + ");";

        p.setPatientId(Database.getInstance().dmlQuery2(insertQuery));
        return (p.getPatientId()!=0);
    }



    public int update(Patient p) {

        String updateQuery = "UPDATE patients "
                + "SET nom_patient = " + "'" + p.getName()+ "', "
                + "prenom_patient = '" + p.getLastName()+ "', "
                + "date_naissance = '" + p.getBirthDate()+ "', "
                + "telephone = '" + p.getTelephone()+ "', "
                + "adresse = '" + p.getAddress()+ "', "
                + "ville = '" + p.getCity()+ "', "
                + "sexe = '" + p.getSexe()+ "', "
                + "cin = '" + p.getCin()+ "', "
                + "credit = '" + p.getCredit()+ "' "
                + "WHERE id_patient = '" + p.getPatientId()+ "';";

        return (Database.getInstance().dmlQuery(updateQuery));
    }



    public boolean delete(Patient p) {
        String deleteQuery = "DELETE FROM patients "
                + "WHERE id_patient = " + p.getPatientId()+ ";";

        return (Database.getInstance().dmlQuery(deleteQuery) != 0);
    }



}
