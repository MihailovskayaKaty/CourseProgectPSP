package sample.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class AdminStudController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button BackAdminButton;

    @FXML
    private TableView<?> StudentTable;

    @FXML
    private TableColumn<?, ?> student_id_col;

    @FXML
    private TableColumn<?, ?> student_surname_col;

    @FXML
    private TableColumn<?, ?> student_name_col;

    @FXML
    private TableColumn<?, ?> student_patronymic_col;

    @FXML
    private TableColumn<?, ?> faculty_name_col;

    @FXML
    private TableColumn<?, ?> form_of_study_col;

    @FXML
    private TableColumn<?, ?> average_mark_col1;

    @FXML
    private TableColumn<?, ?> grants_col;

    @FXML
    void initialize() {
       BackAdminButton.setOnAction(event -> {
            BackAdminButton.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/view/AdminWindow.fxml"));

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
