package dashbord;

import dashbord.Controllers.SceneController;
import dashbord.DAO.ConsultationDAO;
import dashbord.DAO.DAOFactory;
import dashbord.DAO.PatientDAO;
import dashbord.models.Consultation;
import dashbord.models.Patient;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        SceneController.getInitialScene(stage);
    }
    public static void main(String[] args) {


        launch();
    }
}
