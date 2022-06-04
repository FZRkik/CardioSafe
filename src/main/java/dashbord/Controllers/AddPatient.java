package dashbord.Controllers;

import dashbord.DAO.DAOFactory;
import dashbord.models.Patient;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.sql.Date;


public class AddPatient {

    @FXML
    private TextField filed_address;

    @FXML
    private DatePicker zone_birthdate;

    @FXML
    private TextField filed_cin;

    @FXML
    private TextField filed_nom;

    @FXML
    private TextField filed_prenom;

    @FXML
    private TextField filed_sexe;

    @FXML
    private TextField filed_tele;

    @FXML
    private TextField filed_ville;

    @FXML
    private Button btn_ajouter;

    @FXML
    private Button btn_anuler;

    @FXML
    private Label msg;

    @FXML
    void ajouter(ActionEvent event) {

        Patient p =new Patient(filed_prenom.getText(),filed_nom.getText(),filed_tele.getText(), Date.valueOf(zone_birthdate.getValue()),filed_address.getText(),filed_ville.getText(),filed_sexe.getText(),filed_cin.getText());

        if(DAOFactory.getPatientDAO().create(p))
        {
            UpdateStatus.setIsPatientAdded(true);
            msg.setText("Patient ajouté");
            delayWindowClose(event);
        }

    }


    @FXML
    private void closeWindow(ActionEvent event) {
        Stage stage = (Stage) btn_anuler.getScene().getWindow();
        stage.close();
    }

    private void delayWindowClose(ActionEvent event) {
        PauseTransition delay = new PauseTransition(Duration.seconds(1));
        delay.setOnFinished(event2 -> closeWindow(event));
        delay.play();
    }



}
