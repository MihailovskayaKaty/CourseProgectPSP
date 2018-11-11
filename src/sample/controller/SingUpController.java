package sample.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.database.DatabaseHandler;

public class SingUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane EnterLoginField;

    @FXML
    private TextField loginField;

    @FXML
    private TextField passField;

    @FXML
    private TextField EnterSurnameField;

    @FXML
    private TextField EnterNameField;

    @FXML
    private Button SighUpButton;

    @FXML
    private TextField EnterPatronField;

    @FXML
    private TextField EnterFacultyField;

    @FXML
    private TextField EnterFormOStudyField;

    @FXML
    private TextField EnterAvMarkField;

    @FXML
    void initialize() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        SighUpButton.setOnAction(event -> {
            try {
                dbHandler.signUpUser(loginField.getText(), passField.getText());
                dbHandler.signUpStudent(EnterSurnameField.getText(), EnterNameField.getText(), EnterPatronField.getText(),
                        EnterFacultyField.getText(), EnterFormOStudyField.getText(), EnterAvMarkField.getText());
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            SighUpButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/view/StudWindow.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
    }
}