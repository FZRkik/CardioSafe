package dashbord.DAO;

import dashbord.models.Reminder;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReminderDAO {

    public Reminder find(String id) {

        Reminder reminder = new Reminder();
        PatientDAO patientDAO = DAOFactory.getPatientDAO();


        String findQuery = "SELECT * "
                + "FROM rappels "
                + "WHERE id_rappel = " + Integer.parseInt(id) + ";";

        ResultSet rs = Database.getInstance().query(findQuery);

        try {

            rs.first();
            reminder.setId(Integer.parseInt(id));
            reminder.setDescription(rs.getString("desc_rappel"));
            reminder.setPatient(patientDAO.find(id));
            reminder.setDate(rs.getDate("date_rappel"));

        } catch (SQLException ex) {
            System.out.println("Error : ReminderDAO.find()" + ex);
        }

        return reminder;
    }



    public boolean create(Reminder r) {

        String insertQuery = "INSERT INTO rappels VALUES("
                + r.getId()+ ", "
                + "'" + r.getDescription()+ "', "
                + "'" + r.getDate()+ "', "
                + r.getPatient().getPatientId() + ");";

        return (Database.getInstance().dmlQuery(insertQuery) != 0);
    }


    public boolean update(Reminder r) {

        String updateQuery = "UPDATE rappels "
                + "SET desc_rappel = " + "'" + r.getDescription()+ "', "
                + "date_rappel = '" + r.getDate() + "', "
                + "id_patient = " + r.getPatient().getPatientId() + " "
                + "WHERE id_rappel = " + r.getId() + ";";

        return (Database.getInstance().dmlQuery(updateQuery) != 0);
    }



    public boolean delete(Reminder r) {

        String deleteQuery = "DELETE FROM rappels "
                + "WHERE id_rappel = " + r.getId() + ";";

        return (Database.getInstance().dmlQuery(deleteQuery) != 0);
    }



    public List<Reminder> all() {

        List<Reminder> reminders = new ArrayList<>();
        PatientDAO patientDAO = DAOFactory.getPatientDAO();

        String findQuery = "SELECT * "
                + "FROM rappels;";

        ResultSet rs = Database.getInstance().query(findQuery);

        try {

            while(rs.next()) {

                Reminder reminder = new Reminder();

                reminder.setId(rs.getInt("id_rappel"));
                reminder.setDescription(rs.getString("desc_rappel"));
                reminder.setPatient(patientDAO.find(rs.getString("id_patient")));
                reminder.setDate(rs.getDate("date_rappel"));

                reminders.add(reminder);
            }

        } catch (SQLException ex) {
            System.out.println("Error : ReminderDAO.all()" + ex);
        }

        return reminders;
    }


    public List<Reminder> allByDate(String date) {

        List<Reminder> reminders = new ArrayList<>();
        PatientDAO patientDAO = DAOFactory.getPatientDAO();

        String findQuery = "SELECT * "
                + "FROM rappels "
                + "WHERE date_rappel "
                + "BETWEEN '"+ date +" 00:00:00' AND '" + date + " 23:59:59';";

        ResultSet rs = Database.getInstance().query(findQuery);

        try {

            while(rs.next()) {

                Reminder reminder = new Reminder();

                reminder.setId(rs.getInt("id_rappel"));
                reminder.setDescription(rs.getString("desc_rappel"));
                reminder.setPatient(patientDAO.find(rs.getString("id_patient")));
                reminder.setDate(rs.getDate("date_rappel"));
                reminders.add(reminder);
            }

        } catch (SQLException ex) {
            System.out.println("Error : ReminderDAO.all()" + ex);
        }

        return reminders;
    }


}
