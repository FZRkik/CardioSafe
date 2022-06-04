package dashbord.Controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Login   {

    @FXML
    public TextField username;

    @FXML
    public TextField passwd;

    @FXML
    public Button login;

    @FXML
    public Label warning;






    @FXML
    public void verifyconnectedUser(ActionEvent actionEvent) throws IOException
    {
       if (username.getText().equals("Admin") &&
                passwd.getText().equals("0000"))
        {
            SceneController.getAceuilScene(actionEvent);
        }

       else {
           warning.setText("Le nom de l'utilisateur ou le mot de passe est incorrecte !");
       }
    }
}
