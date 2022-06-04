package dashbord.Controllers;
import dashbord.DAO.DAOFactory;
import dashbord.DAO.PatientDAO;
import dashbord.models.Patient;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Patients implements Initializable {

    public static Patient patient=new Patient();

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

/*    void logout(ActionEvent event) {
        btnSignout.setOnAction(SceneController::close);
    }*/

    @FXML
    void showAcceuil(ActionEvent event) throws IOException {
        SceneController.getAceuilScene(event);

    }

    @FXML
    void showConsultation(ActionEvent event) throws IOException {
        SceneController.getConsultationsScene( event );

    }

    @FXML
    void showDashController(ActionEvent event) throws IOException {
        SceneController.getDashbordScene( event );

    }

    @FXML
    void showPaiementsControlleur(ActionEvent event) throws IOException {
        SceneController.getPaiementsScene(event);

    }



    @FXML
    private TableView<Patient> table;
    @FXML
    private TableColumn<Patient,String> col_cin;

    @FXML
    private TableColumn<Patient,String> col_id;

    @FXML
    private TableColumn<Patient,String> col_nom;

    @FXML
    private TableColumn<Patient,String> col_option;

    @FXML
    private TableColumn<Patient,String> col_prenom;
    @FXML
    private TableColumn<Patient,String> col_BirthDate;

    @FXML
    private TableColumn<Patient,String> col_sexe;
    @FXML
    private TableColumn<Patient,String> col_tele;

    ObservableList<Patient> oblist = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

      setTable();
        btnSignout.setOnAction(SceneController::close);
    }

    public void setTable()
    {
        col_id.setCellValueFactory(new PropertyValueFactory<>("patientId"));
        col_cin.setCellValueFactory(new PropertyValueFactory<>("cin"));
        col_nom.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_prenom.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        col_sexe.setCellValueFactory(new PropertyValueFactory<>("sexe"));
        col_tele.setCellValueFactory(new PropertyValueFactory<>("telephone"));
        col_BirthDate.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        oblist.addAll(DAOFactory.getPatientDAO().all());

        table.setItems(oblist);
    }

    @FXML
    private Button btn_add;
    @FXML
    private Button btn_find;
    @FXML
    private TextField txt_filed;
    @FXML
    void rechercher(ActionEvent event) {
        oblist.clear();

        col_id.setCellValueFactory(new PropertyValueFactory<>("patientId"));
        col_cin.setCellValueFactory(new PropertyValueFactory<>("cin"));
        col_nom.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_prenom.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        col_sexe.setCellValueFactory(new PropertyValueFactory<>("sexe"));
        col_tele.setCellValueFactory(new PropertyValueFactory<>("telephone"));
        col_BirthDate.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
        oblist.addAll(DAOFactory.getPatientDAO().like(txt_filed.getText()));

        table.setItems(oblist);
    }
      @FXML
  void show_patient_form(ActionEvent event) throws IOException {
        NewWindowController.getAddPatient_Window();
        if(UpdateStatus.IsPatientAdded()) {
            refreshScreen(event);
            UpdateStatus.setIsPatientAdded(false);
        }

    }

    private void refreshScreen(ActionEvent event)  throws IOException
    {
        SceneController.getPatientsScene(event);
    }



    @FXML
    void refresh_table(ActionEvent event) {

        oblist.clear();

        setTable();
    }


    @FXML
    void delete_patient(ActionEvent event) throws IOException {

        ObservableList<Patient> selectedRows = table.getSelectionModel().getSelectedItems();
        for (Patient p : selectedRows)
        {
            DAOFactory.getPatientDAO().delete(p);
        }
        refreshScreen(event);
    }


    @FXML
      void modify_patient(ActionEvent event) throws IOException {
        Patient p= table.getSelectionModel().getSelectedItem();
        patient=p;

        NewWindowController.getUpdate_Window();
        if(UpdateStatus.IsPatientUpdated()) {
            refreshScreen(event);
            UpdateStatus.setIsPatientUpdated(false);
        }
        return ;
    }


}