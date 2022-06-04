package dashbord.DAO;

public class DAOFactory {

    public static PatientDAO getPatientDAO(){
        return new PatientDAO();
    }


    public static ConsultationDAO getConsultationDAO(){
        return new ConsultationDAO();
    }


    public static PatientInfoDAO getPatientInfoDAO(){
        return new PatientInfoDAO();
    }


    public static PaymentDAO getPaymentDAO(){
        return new PaymentDAO();
    }


    public static ReminderDAO getReminderDAO(){
        return new ReminderDAO();
    }


    public static AbonneDAO getAbonneDAO(){
        return new AbonneDAO();
    }

    public static infoDAO getInfo(){
        return new infoDAO();
    }


    public static ReservationDAO getReservation(){
        return new ReservationDAO();
    }


    public static DrugDAO getDrugDAO(){
        return new DrugDAO();
    }


    public static AllergyDAO getAllergyDAO(){
        return new AllergyDAO();
    }

}
