package dashbord.Controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;


public class SceneController
{

    private static double x;
    private static double y;

    private static Parent main;

   /* public static void getAcceuilMainScene(ActionEvent event) throws IOException {
        changeScreen(event, ScenePath.Acceuil.getPath());
    }*/

    public static void getConsultationsScene(ActionEvent event) throws IOException {
        changeScreen(event, ScenePath.Consultations.getPath());
    }

    public static void getLOGINScene(ActionEvent event) throws IOException {
        changeScreen(event, ScenePath.LOGIN.getPath());
    }

    public static void getDashbordScene(ActionEvent event) throws IOException {
        changeScreen(event, ScenePath.Dashbord.getPath());
    }

    public static void getAceuilScene(ActionEvent event) throws IOException
    {
        changeScreen(event, ScenePath.Acceuil.getPath());
    }

    public static void getPatientsScene(ActionEvent event) throws IOException {
        changeScreen(event, ScenePath.Patients.getPath());
    }

    public static void getPaiementsScene(ActionEvent event) throws IOException {
        changeScreen(event, ScenePath.Paiements.getPath());
    }

    public static void getInitialScene(Stage stage) throws IOException {
        main = FXMLLoader.load((SceneController.class.getResource(ScenePath.LOGIN.getPath())));
        Scene scene = new Scene(main);
        controlDrag(stage);
        stage.initStyle(StageStyle.DECORATED);
        stage.setTitle("cardioSafe");
        stage.setScene(scene);
        stage.show();
    }

    private static void changeScreen(ActionEvent event, String path) throws IOException {
        main = FXMLLoader.load(SceneController.class.getResource(path));
        Scene visitScene = new Scene(main);

        //visitScene.getStylesheets().add(SceneController.class.getResource("/dashbord/css/style.css").toExternalForm());

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        controlDrag(window);
        window.setScene(visitScene);
        window.show();
    }

    public static void controlDrag(Stage stage) {
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

    public static void close(ActionEvent actionEvent) {
        Node  source = (Node)  actionEvent.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
    }

    public static void getAjouterStage(ActionEvent event) throws IOException
    {
        changeScreen(event, ScenePath.Ajouter.getPath());
    }





}
