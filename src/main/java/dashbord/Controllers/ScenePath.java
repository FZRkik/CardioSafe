package dashbord.Controllers;

public enum ScenePath
{

    Acceuil("/dashbord/view/Acceuil.fxml"),
    Consultations("/dashbord/view/Consultations.fxml"),
    LOGIN("/dashbord/view/login.fxml"),
    Dashbord("/dashbord/view/Dashbord.fxml"),
    Patients("/dashbord/view/Patients.fxml"),
    Paiements("/dashbord/view/Paiements.fxml"),
    Ajouter ("/dashbord/view/AddPatient.fxml"),
    Update ("/dashbord/view/UpdatePatient.fxml"),
    commencer_Consult("/dashbord/view/CommencerConsult.fxml"),
    AjouterPaiement("/dashbord/view/AjouterPaiement.fxml"),
    Reserver ("/dashbord/view/Reserver.fxml"),
    info("/dashbord/view/patient_infos.fxml");



    private final String path;

    private ScenePath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
