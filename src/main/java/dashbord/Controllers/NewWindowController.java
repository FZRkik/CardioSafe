package dashbord.Controllers;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class NewWindowController
{
    static double x;
    static double y;


    public static void getPopUpWindow(String path) throws IOException
    {
        Stage stage = new Stage();
        Pane main = FXMLLoader.load(NewWindowController.class.getResource(path));
        controlDrag(main, stage);
        stage.setScene(new Scene(main));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setTitle("CardioSafe");
        stage.getScene();
        stage.showAndWait();
    }

    public static void controlDrag(Pane main, Stage stage) {
        main.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                x = stage.getX() - event.getScreenX();
                y = stage.getY() - event.getScreenY();
            }
        });
        main.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() + x);
                stage.setY(event.getScreenY() + y);
            }
        });
    }

    public static void getAddPatient_Window() throws IOException {
        getPopUpWindow(ScenePath.Ajouter.getPath());
    }

    public static void getReservationindow() throws IOException {
        getPopUpWindow(ScenePath.Reserver.getPath());
    }

    public static void getinfoWin() throws IOException {
        getPopUpWindow(ScenePath.info.getPath());
    }

    public static void getUpdate_Window() throws IOException {
        getPopUpWindow(ScenePath.Update.getPath());
    }

    public static void getCom_Consult_Window() throws IOException {
        getPopUpWindow(ScenePath.commencer_Consult.getPath());
    }

    public static void getAjouterPaiement_Window() throws IOException {
        getPopUpWindow(ScenePath.AjouterPaiement.getPath());
    }
}
