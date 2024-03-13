package lk.penguin.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import lk.penguin.util.Navigation;

import javax.lang.model.element.Name;
import java.io.IOException;

public class RentalDashBoardFormController {

    @FXML
    private AnchorPane rentalDashBoardAnchorPane;

    @FXML
    private AnchorPane rentalDashBoardPane;

    @FXML
    private ScrollPane rentalDashBoardScroll;

    public void initialize() throws IOException {
        Navigation.switchPaging(rentalDashBoardPane,"/view/rentalCustomerForm.fxml");
    }

}
