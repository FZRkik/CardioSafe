package dashbord.DAO;

import dashbord.models.PatientInfo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PatientInfoDAO {
    public PatientInfo find(String id) {

        PatientInfo patientInfo = new PatientInfo();
        ConsultationDAO consultationDAO = DAOFactory.getConsultationDAO();


        String findQuery = "SELECT infos.id_info, propriete, valeur, date_info "
                + "FROM infos INNER JOIN contient ON infos.id_info=contient.id_info "
                + "WHERE infos.id_info = " + id + ";";

        ResultSet rs = Database.getInstance().query(findQuery);

        try {

            rs.first();
            patientInfo.setId(Integer.parseInt(id));
            patientInfo.setProperty(rs.getString("propriete"));
            patientInfo.setValue(rs.getString("valeur"));
            patientInfo.setDateAdded(rs.getDate("date_info"));

        } catch (SQLException ex) {
            System.out.println("Error : PatientInfo.find()" + ex);
        }

        return patientInfo;
    }

    public PatientInfo findAlone(String id) {

        PatientInfo patientInfo = new PatientInfo();



        String findQuery = "select * from infos  "
                + "WHERE id_info = " + id + ";";

        ResultSet rs = Database.getInstance().query(findQuery);

        try {

            rs.first();
            patientInfo.setId(Integer.parseInt(id));
            patientInfo.setProperty(rs.getString("propriete"));


        } catch (SQLException ex) {
            System.out.println("Error : PatientInfo.find()" + ex);
        }

        return patientInfo;
    }


    public boolean create(PatientInfo p) {

        String insertQuery = "INSERT INTO infos(propriete) VALUES('"
                + p.getProperty() + "');";

        p.setId(Database.getInstance().dmlQuery2(insertQuery));

        return p.getId() !=0;
    }


    public boolean update(PatientInfo p) {

        String updateQuery = "UPDATE infos "
                + "SET propriete = '" + p.getProperty() + "' "
                + "WHERE id_info = " + p.getId() + ";";

        return (Database.getInstance().dmlQuery(updateQuery) != 0);
    }


    public boolean delete(PatientInfo p) {

        String deleteQuery = "DELETE FROM infos "
                + "WHERE id_info = " + p.getId() + ";";

        return (Database.getInstance().dmlQuery(deleteQuery) != 0);
    }


    public List<PatientInfo> all() {

        List<PatientInfo> patientInfos = new ArrayList<>();

        String findQuery = "SELECT id_info, propriete "
                + "FROM infos;";

        ResultSet rs = Database.getInstance().query(findQuery);

        try {

            while(rs.next()) {

                PatientInfo p = new PatientInfo();

                p.setId(rs.getInt("id_info"));
                p.setProperty(rs.getString("propriete"));

                patientInfos.add(p);
            }

        } catch (SQLException ex) {
            System.out.println("Error : PatientInfo.all()" + ex);
        }

        return patientInfos;
    }


    public List<PatientInfo> all(int consultationId) {

        List<PatientInfo> patientInfos = new ArrayList<>();

        String findQuery = "SELECT infos.id_info, propriete, valeur, date_info "
                + "FROM infos INNER JOIN contient ON infos.id_info=contient.id_info "
                + "WHERE contient.id_consultation = " + consultationId +";";

        ResultSet rs = Database.getInstance().query(findQuery);

        try {

            while(rs.next()) {

                PatientInfo p = new PatientInfo();

                p.setId(rs.getInt("id_info"));
                p.setProperty(rs.getString("propriete"));
                p.setValue(rs.getString("valeur"));
                p.setDateAdded(rs.getDate("date_info"));

                patientInfos.add(p);
            }

        } catch (SQLException ex) {
            System.out.println("Error : PatientInfo.all(int)" + ex);
        }

        return patientInfos;
    }
}
