package dashbord.models;

import java.sql.Date;

public class Patient
{
    private int patientId;
    private String name;
    private String lastName;
    private String telephone;
    private Date birthDate;
    private String address;
    private String city;
    private String sexe;
    private String cin;
    private double credit;

    public Patient(){}

    public Patient(String name, String lastName, String telephone, Date birthDate, String address, String city, String sexe, String cin) {
        this.name = name;
        this.lastName = lastName;
        this.telephone = telephone;
        this.birthDate = birthDate;
        this.address = address;
        this.city = city;
        this.sexe = sexe;
        this.cin = cin;
        credit=0;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientId=" + patientId +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", telephone='" + telephone + '\'' +
                ", birthDate=" + birthDate +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", sexe='" + sexe + '\'' +
                ", cin='" + cin + '\'' +
                ", credit=" + credit +
                '}';
    }
}
