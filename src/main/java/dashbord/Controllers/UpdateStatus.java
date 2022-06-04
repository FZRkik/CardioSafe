package dashbord.Controllers;

public final class UpdateStatus 
{
    private static boolean isPatientAdded;
    private static boolean isPatientUpdated;


    public static boolean IsPatientAdded() {
        return isPatientAdded;
    }

    public static void setIsPatientAdded(boolean b) {
        UpdateStatus.isPatientAdded = b;
    }


    public static boolean IsPatientUpdated() {
        return isPatientUpdated;
    }

    public static void setIsPatientUpdated(boolean b) {
        UpdateStatus.isPatientUpdated = b;
    }

}
