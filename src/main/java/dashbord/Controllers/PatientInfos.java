package dashbord.Controllers;


import dashbord.DAO.DAOFactory;
import dashbord.models.Consultation;
import dashbord.models.information;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PatientInfos implements Initializable {

    @FXML
    private Button ebtn_exit;

    @FXML
    private TableColumn<information,String> bc;

    @FXML
    private TableColumn<information,String> move;

    @FXML
    private TableColumn<information, String> pression;

    @FXML
    private TableView<information> table;

    ObservableList<information> oblist = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        pression.setCellValueFactory(new PropertyValueFactory<>("pression"));
        bc.setCellValueFactory(new PropertyValueFactory<>("BC"));
        move.setCellValueFactory(new PropertyValueFactory<>("mouvement"));


        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        oblist.addAll(DAOFactory.getInfo().all());

        table.setItems(oblist);

        }

    @FXML
    void exit(ActionEvent event) {
        Stage stage = (Stage) ebtn_exit.getScene().getWindow();
        stage.close();

    }


}







