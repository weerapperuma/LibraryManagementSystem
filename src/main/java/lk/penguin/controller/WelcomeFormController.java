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
import lk.penguin.dto.UserDto;
import lk.penguin.entity.Admin;
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
    private JFXButton fxBtnCreateAcc;

    @FXML
    private TextField fxEmailNewUsr;

    @FXML
    private TextField fxNameNewUsr;

    @FXML
    private PasswordField fxRePasswordNewUsr;

    @FXML
    private PasswordField fxpasswordNewUsr;

    @FXML
    private Pane weclcomeNicFxId;
    String userId;
    String password;

    public static Admin admin;
    WelcomeService welcomeService= (WelcomeService) ServiceFactory.getServiceFactory().getService(ServiceFactory.ServiceType.WELCOME);
    @FXML
    void btnCloseOnAction(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }
    @FXML
    void btnCreateAccOnAction(ActionEvent event) {
        UserDto userDTO=new UserDto(
                0,
                fxNameNewUsr.getText(),
                fxEmailNewUsr.getText(),
                fxpasswordNewUsr.getText());

        boolean saved=welcomeService.saveUser(userDTO);
    }

    @FXML
    void btnRentOnAction(ActionEvent event) throws IOException {
        userId= txtPassportId.getText();
        password=pwPasswordField.getText();

        if(!userId.isEmpty() && !password.isEmpty()){
            if(welcomeService.chekAdmin(userId,password)){
                admin=welcomeService.getAdmin(userId);
                Navigation.switchNavigation("/view/userDashBoard.fxml",event);
            } else if (welcomeService.chekMember(userId, password)) {
                System.out.println("Elakiri");
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

        fxNameNewUsr.setOnAction(event ->fxEmailNewUsr.requestFocus());
        fxEmailNewUsr.setOnAction(event ->fxpasswordNewUsr.requestFocus());
        fxpasswordNewUsr.setOnAction(event -> fxRePasswordNewUsr.requestFocus());
        fxRePasswordNewUsr.setOnAction(event ->fxBtnCreateAcc.fire());

    }
}
