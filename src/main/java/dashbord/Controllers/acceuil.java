package dashbord.Controllers;

import dashbord.DAO.DAOFactory;
import dashbord.models.Abonne;
import dashbord.models.Reservasion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class acceuil implements Initializable
{

    @FXML
    private Button btnSignout;
    @FXML
    private TableColumn<Reservasion, String> col_heure;

    @FXML
    private TableColumn<Reservasion, String> col_id;

    @FXML
    private TableColumn<Reservasion, String> col_nom;

    @FXML
    private TableColumn<Reservasion, String> col_prenom;

    @FXML
    private TableColumn<Reservasion, String> col_type;

    @FXML
    private TableView<Reservasion> table;

    public void showConsultation(ActionEvent actionEvent) throws IOException
    {
        SceneController.getConsultationsScene(actionEvent);
    }

    public void showDashController(ActionEvent actionEvent)  throws IOException{
        SceneController.getDashbordScene(actionEvent);
    }

    public void showPaiementsControlleur(ActionEvent actionEvent)  throws IOException{
        SceneController.getPaiementsScene(actionEvent);
    }

    public void logout(ActionEvent actionEvent)  throws IOException
    {
        btnSignout.setOnAction(SceneController::close);
    }

    public void showPatients(ActionEvent actionEvent)  throws IOException
    {
        SceneController.getPatientsScene(actionEvent);
    }

    @FXML
    void commencer_Consultation(ActionEvent event) throws IOException {

        NewWindowController.getCom_Consult_Window();

    }

    ObservableList<Reservasion> oblist = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        col_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        col_heure.setCellValueFactory(new PropertyValueFactory<>("heure"));
        col_type.setCellValueFactory(new PropertyValueFactory<>("type"));

        oblist.addAll(DAOFactory.getReservation().all());

        table.setItems(oblist);
    }


    @FXML
    void show_reserver_window(ActionEvent event) throws IOException {

        NewWindowController.getReservationindow();
    }
}

