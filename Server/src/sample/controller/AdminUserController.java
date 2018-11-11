package sample.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AdminUserController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button BackAdminButton;

    @FXML
    private TableView<?> UserTable;

    @FXML
    private TableColumn<?, ?> user_id_col;

    @FXML
    private TableColumn<?, ?> login_id_col;

    @FXML
    private TableColumn<?, ?> password_id_col;

    @FXML
    private Button AddUserButton;

    @FXML
    private Button DelUserButton;

    @FXML
    private TextField pass_fieldAdmin;

    @FXML
    private TextField login_fieldAdmin;

    @FXML
    void initialize() {

    }
}
