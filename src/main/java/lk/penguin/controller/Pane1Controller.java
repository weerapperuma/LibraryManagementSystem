package lk.penguin.controller;

import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import lk.penguin.service.ServiceFactory;
import lk.penguin.service.custom.Pane1Service;
import lk.penguin.service.custom.impl.Pane1ServiceImpl;
import lk.penguin.util.Navigation;

public class Pane1Controller {

    @FXML
    private DatePicker dpReturnDate;

    @FXML
    private JFXButton fxBtnAddedCart;

    @FXML
    private JFXButton fxSignInBtn;

    @FXML
    private JFXButton fxsearchBooksbtn;

    @FXML
    private Label lblReturntxt;

    @FXML
    private Label lblTimeTodatTxt;

    @FXML
    private Label lblTimeTodayShow;

    @FXML
    private Label lblUsrIdShow;

    @FXML
    private Label lblusrIdTxt;

    @FXML
    private Pane pane1bottom1;

    @FXML
    private Pane pane1bottom2;

    @FXML
    private TextField txtsearchBar;

    @FXML
    private TextField txtSignUserName;

    @FXML
    private TextField txtSignUserPassword;
    Pane1Service pane1Service= (Pane1ServiceImpl) ServiceFactory.getServiceFactory().getService(ServiceFactory.ServiceType.PANE1);
    @FXML
    void btnAddedCart(ActionEvent event) {

    }

    @FXML
    void btnAvailableBooksOnAction(ActionEvent event) {
        Navigation.autoScrollToBottom();
    }

    @FXML
    void btnExitOnAction(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }

    @FXML
    void btnSearchBarOnAction(ActionEvent event) {

    }

    @FXML
    void btnSignInOnAction(ActionEvent event) {
        boolean isuserExists=pane1Service.isExistsUser(txtSignUserName.getText(),txtSignUserPassword.getText());
        if(isuserExists){
            txtSignUserName.setVisible(false);
            txtSignUserPassword.setVisible(false);
            fxSignInBtn.setVisible(false);
        }
    }

    @FXML
    void hplinkShowAllBooks(ActionEvent event) {
        Navigation.autoScrollToBottom();
    }

    @FXML
    void hplinksignup(ActionEvent event) {

    }

    public void initialize(){
        lblusrIdTxt.setVisible(false);
        lblUsrIdShow.setVisible(false);
        lblTimeTodatTxt.setVisible(false);
        lblTimeTodayShow.setVisible(false);
        lblReturntxt.setVisible(false);
        dpReturnDate.setVisible(false);
        fxsearchBooksbtn.setVisible(false);
    }
}
