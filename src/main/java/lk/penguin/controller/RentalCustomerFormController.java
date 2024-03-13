package lk.penguin.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class RentalCustomerFormController {

    @FXML
    private JFXComboBox<?> cmbDropOffLocation;

    @FXML
    private JFXComboBox<?> cmbPickupLocation;

    @FXML
    private DatePicker datePickerEnding;

    @FXML
    private DatePicker datePickerStarting;

    @FXML
    private Label lblCustId;

    @FXML
    private Label lblCustIdSelected;

    @FXML
    private Label lblDropOffLocation;

    @FXML
    private Label lblEndingDate;

    @FXML
    private Label lblPickUpLocation;

    @FXML
    private Label lblRentIdAutoGenerate;

    @FXML
    private Label lblRentalId;

    @FXML
    private JFXButton lblSearchButton;

    @FXML
    private Label lblStartingDate;

    @FXML
    private Pane paneBokingfirstpane;

    @FXML
    private Pane paneBottomLeft;

    @FXML
    private Pane paneBottomRight;

    @FXML
    private Pane paneTopRight;

    @FXML
    private Pane paneWhyChosseUs;

    @FXML
    private AnchorPane rentCustomerAnchorPane;

    @FXML
    private Pane tableLoadPane;

    @FXML
    void menuButtonOnAction(ActionEvent event) {

    }

    @FXML
    void searchBtnOnAction(ActionEvent event) {

    }

}
