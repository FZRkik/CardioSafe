package dashbord.Controllers;

import javafx.animation.PauseTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class Reserver  implements Initializable {

    @FXML
    private Button btn_anuler;

    @FXML
    private Button btn_reserver;

    @FXML
    private ComboBox<String> heure_box;

    @FXML
    private TextField nom_filed;

    @FXML
    private TextField prenom_filed;

    @FXML
    private ComboBox<String> type_box;
    @FXML
    private Label msg;

    @FXML
    void reserver(ActionEvent event) {

        msg.setText("Reservation effectuée...");
        delayWindowClose(event);
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> heures= FXCollections.observableArrayList(
                "08:00","08:30","09:30","10,30","11:00","11:30","12:30","13:30","14:00","14:30","15:00","15:30","16:00");
        heure_box.setItems(heures);

        ObservableList<String> types= FXCollections.observableArrayList("visit","control");
        type_box.setItems(types);
    }
}
