package dashbord.Controllers;

import dashbord.DAO.DAOFactory;
import dashbord.models.Patient;
import dashbord.models.Payment;
import javafx.animation.PauseTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AjouterPaiement implements Initializable {

    @FXML
    private ComboBox<String> box;

    @FXML
    private DatePicker date;

    @FXML
    private TextField montant_filed;

    @FXML
    private Label msg;

    @FXML
    private Button btn_annuler;


    @FXML
    void ajouter(ActionEvent event) {

        msg.setText("Ajout de Paiement est effectué ");
        delayWindowClose(event);

    }

    @FXML
    void closeWindow(ActionEvent event) {
        Stage stage = (Stage) btn_annuler.getScene().getWindow();
        stage.close();
    }
    private void delayWindowClose(ActionEvent event) {
        PauseTransition delay = new PauseTransition(Duration.seconds(1));
        delay.setOnFinished(event2 -> closeWindow(event));
        delay.play();
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Payment> patients_db =DAOFactory.getPaymentDAO().all();

        List<String> patients_name = new ArrayList<>();
        for(Payment p :patients_db){

        }
        ObservableList<String> patients= FXCollections.observableArrayList(
                "AhmedBakkali",
                "Younes Alami" ,
                "NadaAlaoui" ,
                "Mohammed Temsamani" ,
                "Salwa Taibi " ,
                "Yassir Jebari" ,
                "Mouhssin Naciri" ,
                "BadrBenjelloun" ,
                "mabrouk khadija " ,
                "elkhiri hajar " ,
                "RKIK Abdollah " ,
                "Nadi Sokaina") ;
        box.setItems(patients);

    }
}
