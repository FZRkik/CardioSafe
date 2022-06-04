package dashbord.DAO;

import dashbord.models.Payment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaymentDAO {

    public Payment find(String id) {
        Payment payment = new Payment();
        PatientDAO patientDAO = DAOFactory.getPatientDAO();

        String findQuery = "SELECT * "
                + "FROM paiements "
                + "WHERE id_paiement = " + Integer.parseInt(id) + ";";

        ResultSet rs = Database.getInstance().query(findQuery);

        try {

            rs.first();
            payment.setId(Integer.parseInt(id));
            payment.setAmount(rs.getDouble("montant"));
            payment.setDate(rs.getDate("date_paiement"));
            payment.setPatient(patientDAO.find(rs.getString(id)));
            payment.setCredit(String.valueOf(payment.getPatient().getCredit()));


        } catch (SQLException ex) {
            System.out.println("Error : PaymentDAO.find()" + ex);
        }

        return payment;
    }


    public boolean create(Payment p) {

        String insertQuery = "INSERT INTO paiements(montant, date_paiement, id_patient) VALUES("
                + p.getAmount() + ", "
                + "now(), "
                + p.getPatient().getPatientId() + ");";

        p.setId(Database.getInstance().dmlQuery2(insertQuery));
        return (p.getId()!=0);
    }


    public boolean update(Payment p) {

        String updateQuery = "UPDATE paiements "
                + "SET montant = " + p.getAmount()+ ", "
                + "date_paiement = '" + p.getDate()+ "', "
                + "id_patient = " + p.getPatient().getPatientId() + " "
                + "WHERE id_paiement = " + p.getId() + ";";

        return (Database.getInstance().dmlQuery(updateQuery) != 0);
    }


    public boolean delete(Payment p) {

        String deleteQuery = "DELETE FROM paiements "
                + "WHERE id_paiement = " + p.getId() + ";";

        return (Database.getInstance().dmlQuery(deleteQuery) != 0);
    }



    public List<Payment> all() {

        List<Payment> payments = new ArrayList<>();
        PatientDAO patientDAO = DAOFactory.getPatientDAO();


        String findQuery = "SELECT * "
                + "FROM paiements order by date_paiement desc;";

        ResultSet rs = Database.getInstance().query(findQuery);

        try {

            while(rs.next()) {

                Payment p = new Payment();

                p.setId(rs.getInt("id_paiement"));
                p.setAmount(rs.getDouble("montant"));
                p.setDate(rs.getDate("date_paiement"));
                p.setPatient(patientDAO.find(rs.getString("id_patient")));
                p.setPatient_FullName(p.getPatient().getName()+" "+ p.getPatient().getLastName());
                p.setCredit(String.valueOf(p.getPatient().getCredit()));


                payments.add(p);
            }

        } catch (SQLException ex) {
            System.out.println("Error : PaymentDAO.all()" + ex);
        }

        return payments;
    }


    public List<Payment> like(String like ) {

        List<Payment> payments = new ArrayList<>();
        PatientDAO patientDAO = DAOFactory.getPatientDAO();


        String findQuery = "select id_paiement , montant , date_paiement , b.id_patient , nom_patient, prenom_patient from patients a , paiements b " +
                "where a.id_patient=b.id_patient and (prenom_patient like '%" + like + "%' or nom_patient like '%" + like + "%' ) " +
                ";";

        ResultSet rs = Database.getInstance().query(findQuery);

        try {

            while(rs.next()) {

                Payment p = new Payment();

                p.setId(rs.getInt("id_paiement"));
                p.setAmount(rs.getDouble("montant"));
                p.setDate(rs.getDate("date_paiement"));
                p.setPatient(patientDAO.find(rs.getString("id_patient")));
               p.setPatient_FullName(p.getPatient().getName()+" "+ p.getPatient().getLastName());
                p.setCredit(String.valueOf(p.getPatient().getCredit()));


                payments.add(p);
            }

        } catch (SQLException ex) {
            System.out.println("Error : PaymentDAO.all()" + ex);
        }

        return payments;
    }


}
