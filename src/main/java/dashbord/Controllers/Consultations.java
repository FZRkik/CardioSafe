package dashbord.Controllers;

import dashbord.DAO.DAOFactory;
import dashbord.models.Consultation;
import dashbord.models.Patient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Consultations  implements Initializable {

  public static Consultation consult =new Consultation();

    @FXML
    private Button btnSignout;

    @FXML
    void ShowAcceuil(ActionEvent event) throws IOException {
        SceneController.getAceuilScene(event);

    }

    @FXML
    void logout(ActionEvent event) throws IOException {
        btnSignout.setOnAction(SceneController::close);

    }

    @FXML
    void showDashbord(ActionEvent event) throws IOException {
        SceneController.getDashbordScene( event );
    }

    @FXML
    void showPaiements(ActionEvent event) throws IOException {
        SceneController.getPaiementsScene(event);
    }

    @FXML
    void showPatients(ActionEvent event) throws IOException {
        SceneController.getPatientsScene(event);

    }




    @FXML
    private TableColumn<Consultation,String> col_cons;

    @FXML
    private TableColumn<Consultation,String> col_date;

    @FXML
    private TableColumn<Consultation,String> col_id;


    @FXML
    private TableColumn<Consultation,String> col_option;

    @FXML
    private TableColumn<Consultation,String> col_patient;

    @FXML
    private TableColumn<Consultation,String> col_type;

    @FXML
    private TableView<Consultation> table;

    @FXML
    private TextField txt_filed;


    ObservableList<Consultation> oblist = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        setTable();

    }

 public void setTable(){
     col_id.setCellValueFactory(new PropertyValueFactory<>("consultationId"));
     col_cons.setCellValueFactory(new PropertyValueFactory<>("description"));
     col_patient.setCellValueFactory(new PropertyValueFactory<>("patient_FullName"));
     col_type.setCellValueFactory(new PropertyValueFactory<>("type"));
     col_date.setCellValueFactory(new PropertyValueFactory<>("consultationDate"));
     table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

     oblist.addAll(DAOFactory.getConsultationDAO().all());

     table.setItems(oblist);
 }

    @FXML
    private Button btn_find;


    @FXML
    void rechercher(ActionEvent event) {
        oblist.clear();

        col_id.setCellValueFactory(new PropertyValueFactory<>("consultationId"));
        col_cons.setCellValueFactory(new PropertyValueFactory<>("description"));
        col_patient.setCellValueFactory(new PropertyValueFactory<>("patient_FullName"));
        col_type.setCellValueFactory(new PropertyValueFactory<>("type"));
        col_date.setCellValueFactory(new PropertyValueFactory<>("consultationDate"));
        oblist.addAll(DAOFactory.getConsultationDAO().like(txt_filed.getText()));
        table.setItems(oblist);

    }


    @FXML
    void refresh_table(ActionEvent event) throws IOException {

        oblist.clear();

        setTable();
    }

    @FXML
    void modify(ActionEvent event) throws IOException {
        Consultation con = table.getSelectionModel().getSelectedItem();
        consult = con ;
        NewWindowController.getUpdate_Window();
        if(UpdateStatus.IsPatientUpdated()) {
            refreshScreen(event);
            UpdateStatus.setIsPatientUpdated(false);
        }
        return ;
    }

    private void refreshScreen(ActionEvent event) throws IOException {
        SceneController.getConsultationsScene(event);
    }


    @FXML
    void delete(ActionEvent event) throws IOException {

        ObservableList<Consultation> selectedRows = table.getSelectionModel().getSelectedItems();
        for (Consultation con : selectedRows)
        {
            DAOFactory.getConsultationDAO().delete(con);
        }
        refreshScreen(event);

    }

    boolean addConsultation(){

        return 1<0 ;
    }
}
