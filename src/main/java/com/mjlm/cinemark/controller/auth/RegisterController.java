package main.java.com.mjlm.cinemark.controller.auth;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import main.java.com.mjlm.cinemark.dto.request.auth.RegisterRequest;
import main.java.com.mjlm.cinemark.dto.response.auth.RegisterResponse;
import main.java.com.mjlm.cinemark.service.auth.UsuarioService;
import main.java.com.mjlm.cinemark.util.SceneManager;

public class RegisterController implements Initializable {

    @FXML
    private HBox windowHeader;

    @FXML
    private Button closeButton;

    @FXML
    private Button minimizeButton;

    @FXML
    private TextField emailField;

    @FXML
    private TextField nicknameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private Button registerButton;

    @FXML
    private Hyperlink loginHyperlink;

    private double xOffset = 0;
    private double yOffset = 0;

    private final SceneManager stage;
    private final UsuarioService usuarioService;

    // Inyección de dependencias a través del constructor
    public RegisterController(SceneManager stage, UsuarioService usuarioService) {
        this.stage = stage;
        this.usuarioService = usuarioService;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setupWindowControls();

        if (registerButton != null) {
            registerButton.setOnAction(event -> handleRegister());
        }

        if (loginHyperlink != null) {
            loginHyperlink.setOnAction(event -> {
                try {
                    handleGoToLogin();
                } catch (Exception ex) {
                    Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        }
    }

    @FXML
    private void handleRegister() {
        removerEstilosError();

        boolean camposValidos = true;

        if (esVacio(emailField.getText())) {
            marcarError(emailField);
            camposValidos = false;
        }

        if (esVacio(nicknameField.getText())) {
            marcarError(nicknameField);
            camposValidos = false;
        }

        if (esVacio(passwordField.getText())) {
            marcarError(passwordField);
            camposValidos = false;
        }

        if (esVacio(confirmPasswordField.getText())) {
            marcarError(confirmPasswordField);
            camposValidos = false;
        }

        if (!camposValidos) {
            return;
        }

        if (!passwordField.getText().equals(confirmPasswordField.getText())) {
            marcarError(passwordField);
            marcarError(confirmPasswordField);
            return;
        }

        try {
            RegisterRequest request = new RegisterRequest();
            request.setEmail(emailField.getText().trim());
            request.setNickname(nicknameField.getText().trim());
            request.setContrasena(passwordField.getText());

            RegisterResponse response = usuarioService.registrarUsuario(request);

            if (response != null && response.isExito()) {
                System.out.println("Registro exitoso: " + response.getMensaje());
                stage.showLoginView();
            } else {
                System.err.println(response != null ? response.getMensaje() : "Error desconocido al registrar.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleGoToLogin() throws Exception {
        try {
            stage.showLoginView();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setupWindowControls() {
        if (windowHeader != null) {
            windowHeader.setOnMousePressed(event -> {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            });

            windowHeader.setOnMouseDragged(event -> {
                Stage windowStage = (Stage) windowHeader.getScene().getWindow();
                windowStage.setX(event.getScreenX() - xOffset);
                windowStage.setY(event.getScreenY() - yOffset);
            });
        }

        if (closeButton != null) {
            closeButton.setOnAction(event -> {
                Stage windowStage = (Stage) closeButton.getScene().getWindow();
                windowStage.close();
            });
        }

        if (minimizeButton != null) {
            minimizeButton.setOnAction(event -> {
                Stage windowStage = (Stage) minimizeButton.getScene().getWindow();
                windowStage.setIconified(true);
            });
        }
    }

    private boolean esVacio(String valor) {
        return valor == null || valor.trim().isEmpty();
    }

    private void marcarError(javafx.scene.control.Control campo) {
        if (campo != null) {
            campo.setStyle("-fx-border-color: #d90429; -fx-border-width: 2px; -fx-border-radius: 15px; -fx-background-radius: 15px;");
        }
    }

    private void removerEstilosError() {
        String estiloNormal = "-fx-border-color: transparent; -fx-background-radius: 15px;";
        if (emailField != null) {
            emailField.setStyle(estiloNormal);
        }
        if (nicknameField != null) {
            nicknameField.setStyle(estiloNormal);
        }
        if (passwordField != null) {
            passwordField.setStyle(estiloNormal);
        }
        if (confirmPasswordField != null) {
            confirmPasswordField.setStyle(estiloNormal);
        }
    }
}