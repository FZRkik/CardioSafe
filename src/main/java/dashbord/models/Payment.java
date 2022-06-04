package dashbord.models;

import java.util.Date;

public class Payment {

 private int id;
 private double amount;
 private String patient_FullName ;
 private String credit ;
 private Date date;
 private Patient patient;


 public String getCredit() {
  return credit;
 }

 public void setCredit(String credit) {
  this.credit = credit;
 }

 public String getPatient_FullName() {
  return patient_FullName;
 }

 public void setPatient_FullName(String patient_FullName) {
  this.patient_FullName = patient_FullName;
 }

 public int getId() {
  return id;
 }

 public void setId(int id) {
  this.id = id;
 }

 public double getAmount() {
  return amount;
 }

 public void setAmount(double amount) {
  this.amount = amount;
 }

 public Date getDate() {
  return date;
 }

 public void setDate(Date date) {
  this.date = date;
 }

 public Patient getPatient() {
  return patient;
 }

 public void setPatient(Patient patient) {
  this.patient = patient;
 }
}
