package lk.penguin.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import lk.penguin.util.Navigation;

public class Pane1Controller {

    @FXML
    void down(ActionEvent event) {
        Navigation.autoScrollToBottom();
    }

}
