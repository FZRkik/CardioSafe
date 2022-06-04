package dashbord.Controllers;


import dashbord.DAO.DAOFactory;
import dashbord.models.Abonne;
import dashbord.models.Patient;
import dashbord.models.information;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Dashbord implements Initializable {

    private Patients p = new Patients() ;



    @FXML
    private TableColumn<Abonne,String> col_id;

    @FXML
    private TableColumn<Abonne,String> col_date;
    @FXML
    private TableColumn<Abonne,String> col_nom;

    @FXML
    private TableColumn<Abonne,String> col_prenom;



    @FXML
    private TableView<Abonne> table;


    @FXML
    private Button btnSignout;



    @FXML
    void logout(ActionEvent event) {
        btnSignout.setOnAction(SceneController::close);
    }

    @FXML
    void showAcceuil(ActionEvent event) throws IOException {
        SceneController.getAceuilScene(event);
    }

    @FXML
    void showConsultation(ActionEvent event) throws IOException {
        SceneController.getConsultationsScene(event);
    }

    @FXML
    void showPaiementsControlleur(ActionEvent event) throws IOException {
        SceneController.getPaiementsScene(event);
    }

    @FXML
    void showPatients(ActionEvent event) throws IOException {
        SceneController.getPatientsScene(event);

    }

    ObservableList<Abonne> oblist = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        col_prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        col_date.setCellValueFactory(new PropertyValueFactory<>("date"));

        oblist.addAll(DAOFactory.getAbonneDAO().all());

        table.setItems(oblist);

    }

    @FXML
    void afficher(ActionEvent event) throws IOException {
        Abonne a= table.getSelectionModel().getSelectedItem();

        NewWindowController.getinfoWin();
    }



    @FXML
    void show_patient_form(ActionEvent event) throws IOException {


        p.show_patient_form(event);
    }



}