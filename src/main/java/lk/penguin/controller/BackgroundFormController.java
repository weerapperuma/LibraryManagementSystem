package lk.penguin.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import lk.penguin.util.Navigation;

import javax.lang.model.element.Name;
import java.io.IOException;

public class BackgroundFormController {

    @FXML
    private Label lblDateAndTime;

    @FXML
    private AnchorPane pagingPane;

    @FXML
    void dashCloseButtonOnAction(ActionEvent event) {

    }

    @FXML
    void navigateLoginButtonOnAction(ActionEvent event) {

    }

    public void initialize() throws IOException {
        Navigation.switchPaging(pagingPane,"/view/rentalDashBoardForm.fxml");
    }

}
