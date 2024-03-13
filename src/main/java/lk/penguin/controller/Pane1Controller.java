package lk.penguin.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import lk.penguin.util.Navigation;

public class Pane1Controller {
    @FXML
    private VBox fxSignUpVbox;

    @FXML
    void down(ActionEvent event) {
        Navigation.autoScrollToBottom();
    }

    public void mainSearchButtonOnAction(ActionEvent actionEvent) {

    }

    public void btnExitOnAction(ActionEvent actionEvent) {
        Platform.exit();
        System.exit(0);
    }
    @FXML
    void btnSignOptionOnAction(ActionEvent event) {
        fxSignUpVbox.setVisible(true);
    }
    public void initialize(){
        fxSignUpVbox.setVisible(false);
    }
}
