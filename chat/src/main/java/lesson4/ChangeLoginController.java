package lesson4;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;


public class ChangeLoginController {
    @FXML
    TextField login;


    public void change(ActionEvent actionEvent) throws IOException {
        MockAuthServiceImpl.getInstance().changeLogin(login.getText());
        login.getScene().getWindow().hide();
    }
}
