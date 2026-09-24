package main.java.com.mjlm.cinemark.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import main.java.com.mjlm.cinemark.controller.auth.LoginController;
import main.java.com.mjlm.cinemark.controller.auth.RegisterController;
import main.java.com.mjlm.cinemark.repository.auth.UsuarioRepository;
import main.java.com.mjlm.cinemark.service.auth.UsuarioService;

public class SceneManager {

    private Stage primaryStage;
    private final String FXML_PATH = "/main/resources/view/";

    // Atributo temporal para mantener la sesión del registro entre vistas
    private Long tempUserId;

    public SceneManager(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public Long getTempUserId() {
        return tempUserId;
    }

    public void setTempUserId(Long tempUserId) {
        this.tempUserId = tempUserId;
    }

    public void showRegisterView() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(FXML_PATH + "auth/register-view.fxml"));
        loader.setControllerFactory(clazz -> {
            if (clazz == RegisterController.class) {
                UsuarioRepository authRepository = new UsuarioRepository();
                UsuarioService authService = new UsuarioService(authRepository);
                return new RegisterController(this, authService);
            }
            try {
                return clazz.getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                throw new RuntimeException("Error al crear el constructor: " + e.getMessage());
            }
        });

        Parent root = loader.load();
        Scene scene = new Scene(root, 900, 600);
        scene.setFill(Color.TRANSPARENT);

        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }
    
    public void showLoginView() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(FXML_PATH + "auth/login-view.fxml"));
        loader.setControllerFactory(clazz -> {
            if (clazz == LoginController.class) {
                UsuarioRepository authRepository = new UsuarioRepository();
                UsuarioService authService = new UsuarioService(authRepository);
                return new LoginController(this, authService);
            }
            try {
                return clazz.getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                throw new RuntimeException("Error al crear el constructor: " + e.getMessage());
            }
        });

        Parent root = loader.load();
        Scene scene = new Scene(root, 900, 600);
        scene.setFill(Color.TRANSPARENT);

        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }
    
}
