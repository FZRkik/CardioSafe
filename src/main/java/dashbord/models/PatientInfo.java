package dashbord.models;

import java.sql.Date;

public class PatientInfo {
    int id;
    String property;
    String value;
    Date dateAdded;


    public int getId() {
        return id;
    }

    public String getProperty() {
        return property;
    }

    public String getValue() {
        return value;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }


    @Override
    public String toString() {
        return "PatientInfo{" + "id=" + id + ", property=" + property + ", value=" + value + ", dateAdded=" + dateAdded + '}';
    }


}
