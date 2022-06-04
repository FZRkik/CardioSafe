package dashbord.models;

import java.util.List;

public class Allergy {
    private int allergyId;
    private String allergyName;

    public void setAllergyId(int allergyId) {
        this.allergyId = allergyId;
    }

    public void setAllergyName(String allergyName) {
        this.allergyName = allergyName;
    }



    public int getAllergyId() {
        return allergyId;
    }

    public String getAllergyName() {
        return allergyName;
    }


    @Override
    public String toString() {
        return "Allergy{" + "allergyId=" + allergyId + ", allergyName=" + allergyName + '}';
    }


}
