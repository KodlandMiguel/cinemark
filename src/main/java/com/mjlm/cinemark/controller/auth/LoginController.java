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
import main.java.com.mjlm.cinemark.model.auth.Usuarios;
import main.java.com.mjlm.cinemark.service.auth.UsuarioService;
import main.java.com.mjlm.cinemark.util.SceneManager;

public class LoginController implements Initializable {

    @FXML
    private HBox windowHeader;

    @FXML
    private Button closeButton;

    @FXML
    private Button minimizeButton;

    @FXML
    private TextField identifierField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private Hyperlink registerHyperlink;

    private double xOffset = 0;
    private double yOffset = 0;

    private final SceneManager stage;
    private final UsuarioService usuarioService;

    // Inyección de dependencias por constructor
    public LoginController(SceneManager stage, UsuarioService usuarioService) {
        this.stage = stage;
        this.usuarioService = usuarioService;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setupWindowControls();

        if (loginButton != null) {
            loginButton.setOnAction(event -> handleLogin());
        }

        if (registerHyperlink != null) {
            registerHyperlink.setOnAction(event -> {
                try {
                    handleGoToRegister();
                } catch (Exception ex) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        }
    }

    @FXML
    private void handleLogin() {
        removerEstilosError();

        boolean camposValidos = true;
        String identificador = identifierField.getText();
        String contrasena = passwordField.getText();

        if (esVacio(identificador)) {
            marcarError(identifierField);
            camposValidos = false;
        }

        if (esVacio(contrasena)) {
            marcarError(passwordField);
            camposValidos = false;
        }

        if (!camposValidos) {
            return;
        }

        try {
            // Recorremos la lista para verificar las credenciales (por email o nickname)
            boolean autenticado = false;
            for (Usuarios usuario : usuarioService.listarUsuarios()) {
                boolean coincideUsuario = identificador.trim().equalsIgnoreCase(usuario.getEmail())
                        || identificador.trim().equalsIgnoreCase(usuario.getNickname());

                if (coincideUsuario && contrasena.equals(usuario.getContrasena())) {
                    autenticado = true;
                    stage.setTempUserId((long) usuario.getIdUsuario());
                    break;
                }
            }

            if (autenticado) {
                System.out.println("Inicio de sesión exitoso");
                // stage.showMainView(); // Redirige a la vista principal según la lógica de tu SceneManager
            } else {
                marcarError(identifierField);
                marcarError(passwordField);
                System.err.println("Credenciales incorrectas");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleGoToRegister() throws Exception {
        try {
            stage.showRegisterView();
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
        if (identifierField != null) {
            identifierField.setStyle(estiloNormal);
        }
        if (passwordField != null) {
            passwordField.setStyle(estiloNormal);
        }
    }
}
