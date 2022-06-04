package dashbord.Controllers;

import dashbord.DAO.DAOFactory;
import dashbord.models.Patient;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

public class UpdatePatient implements Initializable {
    @FXML
    private Button btn_annuler;

    @FXML
    private Button btn_modifier;

    @FXML
    private TextField filed_address;

    @FXML
    private DatePicker filed_birthdate;

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
    void modifier(ActionEvent event) {

        Patient p =new Patient(filed_prenom.getText(),filed_nom.getText(),filed_tele.getText(), Date.valueOf(filed_birthdate.getValue()),filed_address.getText(),filed_ville.getText(),filed_sexe.getText(),filed_cin.getText());

      /*  System.out.println(p.toString());

        DAOFactory.getPatientDAO().update(p);

        System.out.println(p.getName());*/


        if(DAOFactory.getPatientDAO().update(p)!=0)

            System.out.println(p.getName());

            UpdateStatus.setIsPatientUpdated(true);
            msg.setText("Patient modifié");
            delayWindowClose(event);

    }

    @FXML
    private TextField filed_ville;

    @FXML
    private Label msg;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Patient p = Patients.patient;

        filed_prenom.setText(p.getName());
        filed_nom.setText(p.getLastName());
        filed_tele.setText(p.getTelephone());
       filed_birthdate.setValue(p.getBirthDate().toLocalDate());
        filed_address.setText(p.getAddress());
        filed_ville.setText(p.getCity());
        filed_sexe.setText(p.getSexe());
        filed_cin.setText(p.getCin());

    }

    @FXML
    private void closeWindow(ActionEvent event) {
        Stage stage = (Stage) btn_annuler.getScene().getWindow();
        stage.close();
    }

    private void delayWindowClose(ActionEvent event) {
        PauseTransition delay = new PauseTransition(Duration.seconds(1));
        delay.setOnFinished(event2 -> closeWindow(event));
        delay.play();
    }

}


