package lesson4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ChatApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent auth = FXMLLoader.load(getClass().getResource("auth.fxml"));
        primaryStage.setTitle("Авторизация");
        primaryStage.setScene(new Scene(auth));
        primaryStage.show();
    }
}
