package dashbord.Controllers;

import dashbord.DAO.DAOFactory;
import dashbord.models.Consultation;
import dashbord.models.Payment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Paiements implements Initializable {


    @FXML
    private Button btnConsultations;

    @FXML
    private Button btnDashbord;

    @FXML
    private Button btnPaiements;

    @FXML
    private Button btnSignout;

    @FXML
    private Button btnpatients;

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
    void showDashController(ActionEvent event) throws IOException {
        SceneController.getDashbordScene(event);
    }

    @FXML
    void showPatients(ActionEvent event) throws IOException {
        SceneController.getPatientsScene(event);
    }


    @FXML
    private Button btn_effectuer;

    @FXML
    private Button btn_find;
    @FXML
    private TableColumn<Payment, String> col_DatePaiement;


    @FXML
    private TableView<Payment> table;

    @FXML
    private TableColumn<Payment, String> col_id;

    @FXML
    private TableColumn<Payment, String> col_montant;

    @FXML
    private TableColumn<Payment, String> col_patient;

    @FXML
    private TableColumn<Payment, String> col_credit;

    @FXML
    private TextField txt_filed;


    ObservableList<Payment> oblist = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_montant.setCellValueFactory(new PropertyValueFactory<>("amount"));
        col_patient.setCellValueFactory(new PropertyValueFactory<>("patient_FullName"));
        col_DatePaiement.setCellValueFactory(new PropertyValueFactory<>("date"));
        col_credit.setCellValueFactory(new PropertyValueFactory<>("credit"));


        oblist.addAll(DAOFactory.getPaymentDAO().all());

        table.setItems(oblist);
    }

    @FXML
    void effectuer_paiement(ActionEvent event) throws IOException {

        NewWindowController.getAjouterPaiement_Window();

    }


    @FXML
    void rechercher(ActionEvent event) {

        oblist.clear();

        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_montant.setCellValueFactory(new PropertyValueFactory<>("amount"));
        col_patient.setCellValueFactory(new PropertyValueFactory<>("patient_FullName"));
        col_credit.setCellValueFactory(new PropertyValueFactory<>("credit"));
        col_DatePaiement.setCellValueFactory(new PropertyValueFactory<>("date"));

        oblist.addAll(DAOFactory.getPaymentDAO().like(txt_filed.getText()));
        table.setItems(oblist);

    }


    @FXML
    private void refreshScreen(ActionEvent event) throws IOException {
        SceneController.getPaiementsScene(event);
    }
}
