package dashbord.models;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class Consultation {
    private int consultationId;
    private String type;
    private String description;
    private String diagnostics;
    private Timestamp consultationDate;
    private String status;
    private int prix;
    private Patient patient;
    private String patient_FullName ;
    private List<PatientInfo> patientInfoList;
    private List<Drug> drugList;
    private List<Allergy> allergyList;

    public Consultation(){}
    public Consultation( String type, String description, String diagnostics, Timestamp consultationDate, String status, int prix, Patient patient, String patient_FullName, List<PatientInfo> patientInfoList, List<Drug> drugList, List<Allergy> allergyList) {

        this.type = type;
        this.description = description;
        this.diagnostics = diagnostics;
        this.consultationDate = consultationDate;
        this.status = status;
        this.prix = prix;
        this.patient = patient;
        this.patient_FullName = patient_FullName;
        this.patientInfoList = patientInfoList;
        this.drugList = drugList;
        this.allergyList = allergyList;
    }



    public String getPatient_FullName() {
        return patient_FullName;
    }

    public void setPatient_FullName(String patient_FullName) {
        this.patient_FullName = patient_FullName;
    }

    public int getConsultationId() {
        return consultationId;
    }

    public void setConsultationId(int consultationId) {
        this.consultationId = consultationId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDiagnostics() {
        return diagnostics;
    }

    public void setDiagnostics(String diagnostics) {
        this.diagnostics = diagnostics;
    }

    public Timestamp getConsultationDate() {
        return consultationDate;
    }

    public void setConsultationDate(Timestamp consultationDate) {
        this.consultationDate = consultationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<PatientInfo> getPatientInfoList() {
        return patientInfoList;
    }

    public void setPatientInfoList(List<PatientInfo> patientInfoList) {
        this.patientInfoList = patientInfoList;
    }

    public List<Drug> getDrugList() {
        return drugList;
    }

    public void setDrugList(List<Drug> drugList) {
        this.drugList = drugList;
    }

    public List<Allergy> getAllergyList() {
        return allergyList;
    }

    public void setAllergyList(List<Allergy> allergyList) {
        this.allergyList = allergyList;
    }



    @Override
    public String toString() {
        String str = "Consultation(" + "consultationId=" + consultationId + ", desc=" + description + ", date=" + consultationDate + ", status=" + status + ", prix=" + prix + ", \npatient= (" + patient + ")"
                + "\ndrugList:[ ";
        for(Drug drug: drugList) {
            str += "_ " + drug + "\n";
        }

        str += "]\npatientInfoList:[ ";

        for(PatientInfo pInfo: patientInfoList) {
            str += "_ " + pInfo + "\n";
        }

        str += "]\nallergyList:[ ";

        for(Allergy allergy: allergyList) {
            str += "_ " + allergy + "\n";
        }
        str += "])";

        return str;
    }


}
