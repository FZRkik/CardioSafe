package dashbord.Controllers;

import dashbord.DAO.DAOFactory;
import dashbord.models.Allergy;
import dashbord.models.Consultation;
import javafx.animation.PauseTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class CommencerConsult implements Initializable {

    @FXML
    private Label msg;

    @FXML
    private TextArea Desc_area;

    @FXML
    private Button allergie_add;

    @FXML
    private ComboBox<String> allergie_box;

    @FXML
    private Label allergies;

    @FXML
    private Button btn_anuler;

    @FXML
    private Button btn_effectuer;

    @FXML
    private DatePicker consult_date;

    @FXML
    private TextArea diagnostic_area;

    @FXML
    private Button info_add;

    @FXML
    private ComboBox<String> information_box;

    @FXML
    private Label infos;

    @FXML
    private Button medicament_add;

    @FXML
    private ComboBox<String> medicament_box;

    @FXML
    private Label medicaments;

    @FXML
    private TextField valeur_filed;

    @FXML
    private TextField type_filed;

    @FXML
    private ComboBox<String> type_box;


    @FXML
    void allergie_add(ActionEvent event) {
            String a = allergie_box.getSelectionModel().getSelectedItem().toString() ;
            allergies.setText(a);
    }

    @FXML
    void closeWindow(ActionEvent event) {
        Stage stage = (Stage) btn_anuler.getScene().getWindow();
        stage.close();
    }

    private void delayWindowClose(ActionEvent event) {
        PauseTransition delay = new PauseTransition(Duration.seconds(1));
        delay.setOnFinished(event2 -> closeWindow(event));
        delay.play();
    }



    @FXML
    void effectuer(ActionEvent event) {

            msg.setText("Consultation effectuée");
            delayWindowClose(event);

    }

    @FXML
    void info_add(ActionEvent event) {
        String a = information_box.getSelectionModel().getSelectedItem().toString() ;
        infos.setText(a);

    }

    @FXML
    void medicament_add(ActionEvent event) {

        String a = medicament_box.getSelectionModel().getSelectedItem().toString() ;
        medicaments.setText(a);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> Allergies= FXCollections.observableArrayList("Boeuf","Noisette","Poils de chat","Ombellifières");
        allergie_box.setItems(Allergies);

        ObservableList<String> info= FXCollections.observableArrayList("Fièvre","Fréquence", "cardiaque", "Pression", "artérielle", "Poids", "Taille", "Groupe" ,"sanguin" ," Cholestérol", "Glycémie", "Créatinine", "IMC");
        information_box.setItems(info);

        ObservableList<String> medica= FXCollections.observableArrayList("ADVATE 1000 UI/2", "AESCULUS COMPOSE suppos", "AFTOSIUM cp subling",
                "ALEVETABS 220 mg cp pellic",
                "AZZALURE 10 U Speywood/0,05 ml",
                "Metonia, Co. 5 mg");

        medicament_box.setItems(medica);

        ObservableList<String> types= FXCollections.observableArrayList("visit","control");
        type_box.setItems(types);



    }


}
