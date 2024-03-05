package lk.penguin.controller;

import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import lk.penguin.service.ServiceFactory;
import lk.penguin.service.custom.WelcomeService;
import lk.penguin.util.Navigation;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class WelcomeFormController implements Initializable {



    @FXML
    private JFXButton btntxtRent;

    @FXML
    private Hyperlink hyperLinkForget;

    @FXML
    private Label lblTitle;

    @FXML
    private PasswordField pwPasswordField;

    @FXML
    private TextField txtPassportId;

    @FXML
    private Pane weclcomeNicFxId;
    String userId;
    String password;

    WelcomeService welcomeService= (WelcomeService) ServiceFactory.getServiceFactory().getService(ServiceFactory.ServiceType.WELCOME);
    @FXML
    void btnCloseOnAction(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }

    @FXML
    void btnRentOnAction(ActionEvent event) throws IOException {
        userId= txtPassportId.getText();
        password=pwPasswordField.getText();

        if(!userId.isEmpty() && !password.isEmpty()){
            if(welcomeService.chekAdmin(userId,password)){
                Navigation.switchNavigation("/view/userDashBoard.fxml",event);
            } else if (welcomeService.chekMember(userId, password)) {

            } else{
                System.out.println("fk u");
            }
        }
    }

    @FXML
    void forgetPasswordOnAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txtPassportId.setOnAction(event ->pwPasswordField.requestFocus());
        pwPasswordField.setOnAction(event-> btntxtRent.fire());


    }
}
