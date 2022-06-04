package dashbord.DAO;

import dashbord.models.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ConsultationDAO {
    public Consultation find(String id) {

        Consultation con = new Consultation();

        PatientDAO patientDAO = DAOFactory.getPatientDAO();
        PatientInfoDAO patientInfoDAO = DAOFactory.getPatientInfoDAO();

        String findQuery = "SELECT * FROM consultations"
                + " WHERE id_consultation =" + id + ";";

        ResultSet rs = Database.getInstance().query(findQuery);

        try {
            rs.next();
            con.setConsultationId(rs.getInt("id_consultation"));
            con.setType(rs.getString("type_consultation"));
            con.setDescription(rs.getString("desc_consultation"));
            con.setConsultationDate(rs.getTimestamp("date_consultation"));
            con.setStatus(rs.getString("status"));
            con.setPrix(rs.getInt("prix"));
            con.setDiagnostics(rs.getString("diagnostics"));
            con.setPatient(patientDAO.find(rs.getString("id_patient")));
            con.setDrugList(DAOFactory.getDrugDAO().all(rs.getInt("id_consultation")));
            con.setPatientInfoList(patientInfoDAO.all(rs.getInt("id_consultation")));
            con.setAllergyList(DAOFactory.getAllergyDAO().all(rs.getInt("id_consultation")));
        } catch (Exception ex) {
            System.out.println("Problem in find - ConsultationDAO" + ex);
        }

        return con;
    }



    public List<Consultation> all() {

        List<Consultation> consultations = new ArrayList<>();
        PatientDAO patientDAO = DAOFactory.getPatientDAO();
        PatientInfoDAO patientInfoDAO = DAOFactory.getPatientInfoDAO();

        String findAllQuery = "SELECT * FROM consultations;";
        ResultSet rs = Database.getInstance().query(findAllQuery);

        try {

            while(rs.next()) {

                Consultation con = new Consultation();

                con.setConsultationId(rs.getInt("id_consultation"));
                con.setType(rs.getString("type_consultation"));
                con.setDescription(rs.getString("desc_consultation"));
                con.setConsultationDate(rs.getTimestamp("date_consultation"));
                con.setStatus(rs.getString("status"));
                con.setPrix(rs.getInt("prix"));
                con.setDiagnostics(rs.getString("diagnostics"));
                con.setPatient(patientDAO.find(rs.getString("id_patient")));
                con.setPatient_FullName(con.getPatient().getName()+" "+ con.getPatient().getLastName());
                con.setDrugList(DAOFactory.getDrugDAO().all(rs.getInt("id_consultation")));
                con.setPatientInfoList(patientInfoDAO.all(rs.getInt("id_consultation")));
                con.setAllergyList(DAOFactory.getAllergyDAO().all(rs.getInt("id_consultation")));
                consultations.add(con);
            }

        } catch (Exception ex) {
            System.out.println("Problem in all - ConsultationDAO" + ex);
        }

        return consultations;
    }



    public boolean create(Consultation con) {
        String insertQuery = "INSERT INTO consultations(type_consultation, desc_consultation, "
                + "diagnostics, date_consultation, status, prix, id_patient) VALUES("
                + "'" + con.getType()               + "', "
                + "'" + con.getDescription()        + "', "
                + "'" + con.getDiagnostics()        + "', "
                + "'" + con.getConsultationDate()   + "', "
                + "'" + con.getStatus()             + "', "
                + con.getPrix()                     + ", "
                + con.getPatient().getPatientId()   + ");";

        con.setConsultationId(Database.getInstance().dmlQuery2(insertQuery));
        return (con.getConsultationId()!=0);
    }



    public boolean update(Consultation con) {
        String updateQuery = "UPDATE consultations "
                + "SET type_consultation = " + "'" + con.getType() + "', "
                + "desc_consultation = '" + con.getDescription().replaceAll("'","\"") + "', "
                + "diagnostics = '" + con.getDiagnostics().replaceAll("'","\"")+ "', "
                + "date_consultation = '" + con.getConsultationDate()+ "', "
                + "status = '" + con.getStatus() + "', "
                + "prix = '" + con.getPrix() + "', "
                + "id_patient = '" + con.getPatient().getPatientId() + "' "
                + "WHERE id_consultation = '" + con.getConsultationId() + "';";

        return (Database.getInstance().dmlQuery(updateQuery) != 0);
    }



    public boolean delete(Consultation con) {
        String deleteQuery = "DELETE FROM consultations "
                + "WHERE id_consultation = " + con.getConsultationId()+ ";";

        return Database.getInstance().dmlQuery(deleteQuery) != 0;
    }


    public boolean introduit(Consultation con, Drug drug) {
        String introduceQuery = "INSERT INTO introduit VALUES("
                + con.getConsultationId() + ", " + drug.getDrugId() + ", '" + drug.getDrugDescription()
                + "');";

        return (Database.getInstance().dmlQuery(introduceQuery) != 0);
    }


    public boolean contient(Consultation con, PatientInfo pInfo) {
        String insertQuery = "INSERT INTO contient VALUES("
                + con.getConsultationId() + ", " + pInfo.getId() + ", '" + pInfo.getValue()
                + "', '" + pInfo.getDateAdded() + "');";

        return (Database.getInstance().dmlQuery(insertQuery) != 0);
    }

    public boolean renseigne(Consultation con, Allergy allergy) {
        String insertQuery = "INSERT INTO renseigne VALUES("
                +"'"+con.getConsultationId()+"'"
                + ", '"+allergy.getAllergyId()+"');";

        return (Database.getInstance().dmlQuery(insertQuery) != 0);
    }


    public List<Consultation> pendingConsultations() {

        List<Consultation> consultations = new ArrayList<>();
        PatientDAO patientDAO = DAOFactory.getPatientDAO();
        PatientInfoDAO patientInfoDAO = DAOFactory.getPatientInfoDAO();

        String DayStart = new SimpleDateFormat("yyyy-MM-dd 00:00:00").format(Calendar.getInstance().getTime());
        String DayEnd = new SimpleDateFormat("yyyy-MM-dd 23:59:59").format(Calendar.getInstance().getTime());

        String findAllQuery = "SELECT * "
                + "FROM consultations "
                + "WHERE date_consultation "
                + "BETWEEN '" + DayStart + "' AND '"+ DayEnd + "' ";

        ResultSet rs = Database.getInstance().query(findAllQuery);

        try {

            while(rs.next()) {

                Consultation con = new Consultation();
                con.setConsultationId(rs.getInt("id_consultation"));
                con.setType(rs.getString("type_consultation"));
                con.setDescription(rs.getString("desc_consultation"));
                con.setConsultationDate(rs.getTimestamp("date_consultation"));
                con.setStatus(rs.getString("status"));
                con.setPrix(rs.getInt("prix"));
                con.setDiagnostics(rs.getString("diagnostics"));
                con.setPatient(patientDAO.find(rs.getString("id_patient")));
                con.setPatient_FullName(con.getPatient().getName()+" "+ con.getPatient().getLastName());
                con.setDrugList(DAOFactory.getDrugDAO().all(rs.getInt("id_consultation")));
                con.setPatientInfoList(patientInfoDAO.all(rs.getInt("id_consultation")));
                con.setAllergyList(DAOFactory.getAllergyDAO().all(rs.getInt("id_consultation")));
                consultations.add(con);
            }

        } catch (Exception ex) {
            System.out.println("Problem in pendingConsultations - ConsultationDAO " + ex);
        }

        return consultations;
    }

    public List<Consultation> byDate(Timestamp date) {

        List<Consultation> consultations = new ArrayList<>();
        PatientDAO patientDAO = DAOFactory.getPatientDAO();
        PatientInfoDAO patientInfoDAO = DAOFactory.getPatientInfoDAO();

        String DayStart = new SimpleDateFormat("yyyy-MM-dd 00:00:00").format(date);
        String DayEnd = new SimpleDateFormat("yyyy-MM-dd 23:59:59").format(date);


        String findAllQuery = "SELECT * "
                + "FROM consultations "
                + "WHERE date_consultation "
                + "BETWEEN '" + DayStart + "' AND '"+ DayEnd + "' ";

        ResultSet rs = Database.getInstance().query(findAllQuery);

        try {

            while(rs.next()) {

                Consultation con = new Consultation();
                con.setConsultationId(rs.getInt("id_consultation"));
                con.setType(rs.getString("type_consultation"));
                con.setDescription(rs.getString("desc_consultation"));
                con.setConsultationDate(rs.getTimestamp("date_consultation"));
                con.setStatus(rs.getString("status"));
                con.setPrix(rs.getInt("prix"));
                con.setDiagnostics(rs.getString("diagnostics"));
                con.setPatient(patientDAO.find(rs.getString("id_patient")));
                con.setPatient_FullName(con.getPatient().getName()+" "+ con.getPatient().getLastName());
                con.setDrugList(DAOFactory.getDrugDAO().all(rs.getInt("id_consultation")));
                con.setPatientInfoList(patientInfoDAO.all(rs.getInt("id_consultation")));
                con.setAllergyList(DAOFactory.getAllergyDAO().all(rs.getInt("id_consultation")));
                consultations.add(con);
            }

        } catch (Exception ex) {
            System.out.println("Problem in byDate - ConsultationDAO " + ex);
        }

        return consultations;
    }

    public List<Consultation> byHour(String date) {

        List<Consultation> consultations = new ArrayList<>();
        PatientDAO patientDAO = DAOFactory.getPatientDAO();
        PatientInfoDAO patientInfoDAO = DAOFactory.getPatientInfoDAO();

//        String hour = new SimpleDateFormat("yyyy-MM-dd 00:00:00").format(date);


        String findAllQuery = "SELECT * "
                + "FROM consultations "
                + "WHERE date_consultation = '" + date +"' ";

        ResultSet rs = Database.getInstance().query(findAllQuery);

        try {

            while(rs.next()) {

                Consultation con = new Consultation();
                con.setConsultationId(rs.getInt("id_consultation"));
                con.setType(rs.getString("type_consultation"));
                con.setDescription(rs.getString("desc_consultation"));
                con.setConsultationDate(rs.getTimestamp("date_consultation"));
                con.setStatus(rs.getString("status"));
                con.setPrix(rs.getInt("prix"));
                con.setDiagnostics(rs.getString("diagnostics"));
                con.setPatient(patientDAO.find(rs.getString("id_patient")));
                con.setPatient_FullName(con.getPatient().getName()+" "+ con.getPatient().getLastName());
                con.setDrugList(DAOFactory.getDrugDAO().all(rs.getInt("id_consultation")));
                con.setPatientInfoList(patientInfoDAO.all(rs.getInt("id_consultation")));
                con.setAllergyList(DAOFactory.getAllergyDAO().all(rs.getInt("id_consultation")));
                consultations.add(con);
            }

        } catch (Exception ex) {
            System.out.println("Problem in byHour ConsultationDAO " + ex);
        }

        return consultations;
    }

    public List<Consultation> byDate(String date) {

        List<Consultation> consultations = new ArrayList<>();
        PatientDAO patientDAO = DAOFactory.getPatientDAO();
        PatientInfoDAO patientInfoDAO = DAOFactory.getPatientInfoDAO();

        String DayStart = date + " 00:00:00";
        String DayEnd = date + " 23:59:59";

        String findAllQuery = "SELECT * "
                + "FROM consultations "
                + "WHERE date_consultation "
                + "BETWEEN '" + DayStart + "' AND '"+ DayEnd + "' ";

        ResultSet rs = Database.getInstance().query(findAllQuery);

        try {

            while(rs.next()) {

                Consultation con = new Consultation();
                con.setConsultationId(rs.getInt("id_consultation"));
                con.setType(rs.getString("type_consultation"));
                con.setDescription(rs.getString("desc_consultation"));
                con.setConsultationDate(rs.getTimestamp("date_consultation"));
                con.setStatus(rs.getString("status"));
                con.setPrix(rs.getInt("prix"));
                con.setDiagnostics(rs.getString("diagnostics"));
                con.setPatient(patientDAO.find(rs.getString("id_patient")));
                con.setPatient_FullName(con.getPatient().getName()+" "+ con.getPatient().getLastName());
                con.setDrugList(DAOFactory.getDrugDAO().all(rs.getInt("id_consultation")));
                con.setPatientInfoList(patientInfoDAO.all(rs.getInt("id_consultation")));
                con.setAllergyList(DAOFactory.getAllergyDAO().all(rs.getInt("id_consultation")));
                consultations.add(con);
            }

        } catch (Exception ex) {
            System.out.println("Problem in byDate - ConsultationDAO " + ex);
        }

        return consultations;
    }

    public List<Consultation> byDateAndStatus(Timestamp date, String status) {

        List<Consultation> consultations = new ArrayList<>();
        PatientDAO patientDAO = DAOFactory.getPatientDAO();
        PatientInfoDAO patientInfoDAO = DAOFactory.getPatientInfoDAO();

        String DayStart = new SimpleDateFormat("yyyy-MM-dd 00:00:00").format(date);
        String DayEnd = new SimpleDateFormat("yyyy-MM-dd 23:59:59").format(date);


        String findAllQuery = "SELECT * "
                + "FROM consultations "
                + "WHERE status = '" + status + "' "
                + "AND date_consultation "
                + "BETWEEN '" + DayStart + "' AND '"+ DayEnd + "' ORDER BY date_consultation DESC";

        ResultSet rs = Database.getInstance().query(findAllQuery);

        try {

            while(rs.next()) {

                Consultation con = new Consultation();
                con.setConsultationId(rs.getInt("id_consultation"));
                con.setType(rs.getString("type_consultation"));
                con.setDescription(rs.getString("desc_consultation"));
                con.setConsultationDate(rs.getTimestamp("date_consultation"));
                con.setStatus(rs.getString("status"));
                con.setPrix(rs.getInt("prix"));
                con.setDiagnostics(rs.getString("diagnostics"));
                con.setPatient(patientDAO.find(rs.getString("id_patient")));
                con.setPatient_FullName(con.getPatient().getName()+" "+ con.getPatient().getLastName());
                con.setDrugList(DAOFactory.getDrugDAO().all(rs.getInt("id_consultation")));
                con.setPatientInfoList(patientInfoDAO.all(rs.getInt("id_consultation")));
                con.setAllergyList(DAOFactory.getAllergyDAO().all(rs.getInt("id_consultation")));
                consultations.add(con);
            }

        } catch (Exception ex) {
            System.out.println("Problem in byDate - ConsultationDAO " + ex);
        }

        return consultations;
    }


    //finishedConsultations
    public List<Consultation> byStatus(String status) {

        List<Consultation> consultations = new ArrayList<>();

        PatientDAO patientDAO = DAOFactory.getPatientDAO();
        PatientInfoDAO patientInfoDAO = DAOFactory.getPatientInfoDAO();

        String findAllQuery = "SELECT * FROM consultations "
                + "WHERE status ='" + status + "';";

        ResultSet rs = Database.getInstance().query(findAllQuery);

        try {

            while(rs.next()) {

                Consultation con = new Consultation();
                con.setConsultationId(rs.getInt("id_consultation"));
                con.setType(rs.getString("type_consultation"));
                con.setDescription(rs.getString("desc_consultation"));
                con.setConsultationDate(rs.getTimestamp("date_consultation"));
                con.setStatus(rs.getString("status"));
                con.setPrix(rs.getInt("prix"));
                con.setDiagnostics(rs.getString("diagnostics"));
                con.setPatient(patientDAO.find(rs.getString("id_patient")));
                con.setPatient_FullName(con.getPatient().getName()+" "+ con.getPatient().getLastName());
                con.setDrugList(DAOFactory.getDrugDAO().all(rs.getInt("id_consultation")));
                con.setPatientInfoList(patientInfoDAO.all(rs.getInt("id_consultation")));
                con.setAllergyList(DAOFactory.getAllergyDAO().all(rs.getInt("id_consultation")));
                consultations.add(con);
            }

        } catch (Exception ex) {
            System.out.println("Problem in pendingConsultations - ConsultationDAO " + ex);
        }

        return consultations;
    }


    public List<Consultation> all(int patientId) {

        List<Consultation> consultations = new ArrayList<>();

        String findQuery = "SELECT * FROM consultations"
                + " WHERE id_patient =" + patientId + ";";

        ResultSet rs = Database.getInstance().query(findQuery);

        try {

            while(rs.next()) {

                Consultation con = new Consultation();

                con.setConsultationId(rs.getInt("id_consultation"));
                con.setType(rs.getString("type_consultation"));
                con.setDiagnostics(rs.getString("diagnostics"));
                con.setDescription(rs.getString("desc_consultation"));
                con.setConsultationDate(rs.getTimestamp("date_consultation"));
                con.setStatus(rs.getString("status"));
                con.setPrix(rs.getInt("prix"));
                con.setPatient(DAOFactory.getPatientDAO().find(rs.getString("id_patient")));
                con.setPatient_FullName(con.getPatient().getName()+" "+ con.getPatient().getLastName());
                con.setDrugList(DAOFactory.getDrugDAO().all(rs.getInt("id_consultation")));
                con.setPatientInfoList(DAOFactory.getPatientInfoDAO().all(rs.getInt("id_consultation")));
                con.setAllergyList(DAOFactory.getAllergyDAO().all(rs.getInt("id_consultation")));

                consultations.add(con);
            }

        } catch (SQLException ex) {
            System.out.println("Error : Consultation.all(int)" + ex);
        }

        return consultations;
    }



    public List<Consultation> like(String like) {

        List<Consultation> consultations = new ArrayList<>();

        String findLikeQuery = "  SELECT id_consultation,type_consultation,diagnostics,desc_consultation, date_consultation,status,prix,a.id_patient"+
        " FROM patients a, consultations b"+
       " where a.id_patient=b.id_patient and (prenom_patient like '%" + like + "%' or nom_patient like '%" + like + "%');" ;
        ResultSet rs = Database.getInstance().query(findLikeQuery);

        try {

            while(rs.next()) {
                Consultation con = new Consultation();

                con.setConsultationId(rs.getInt("id_consultation"));
                con.setType(rs.getString("type_consultation"));
                con.setDiagnostics(rs.getString("diagnostics"));
                con.setDescription(rs.getString("desc_consultation"));
                con.setConsultationDate(rs.getTimestamp("date_consultation"));
                con.setStatus(rs.getString("status"));
                con.setPrix(rs.getInt("prix"));
                con.setPatient(DAOFactory.getPatientDAO().find(rs.getString("id_patient")));
                con.setPatient_FullName(con.getPatient().getName()+" "+ con.getPatient().getLastName());
                con.setDrugList(DAOFactory.getDrugDAO().all(rs.getInt("id_consultation")));
                con.setPatientInfoList(DAOFactory.getPatientInfoDAO().all(rs.getInt("id_consultation")));
                con.setAllergyList(DAOFactory.getAllergyDAO().all(rs.getInt("id_consultation")));

                consultations.add(con);
            }

        } catch (SQLException ex) {
            System.out.println("Error : Consultation.like(String )" + ex);
        }

        return consultations;
    }



}
