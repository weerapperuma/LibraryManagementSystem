package lk.penguin.controller;

import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
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


    private static WelcomeFormController welcomeFormController;
    public WelcomeFormController(){
        welcomeFormController=this;
    }
    public static WelcomeFormController getWelcomeFormController(){
        return welcomeFormController;
    }


    @FXML
    private JFXButton btntxtRent;

    @FXML
    private PasswordField pwPasswordField;

    @FXML
    private TextField txtPassportId;
    String userId;
    String password;

    @FXML
    private JFXButton fxBooksBtn;

    @FXML
    private JFXButton fxReadersOnAction;

    @FXML
    private JFXButton fxSearchBtn;

    @FXML
    private JFXButton fxbranchesBtn;

    @FXML
    private Hyperlink hyperLinkForget;
    @FXML
    public Pane paneLoader;


    @FXML
    private TextField txtsearchBar;


    public static Admin admin;
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
                admin=welcomeService.getAdmin(userId);
                visibleScreanIcons(true);
                txtPassportId.setVisible(false);
                pwPasswordField.setVisible(false);
                btntxtRent.setVisible(false);
                hyperLinkForget.setVisible(false);

            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Login");
                alert.setHeaderText("An Error Occurred");
                alert.setContentText("User Name And Password Mismatch.");

                // Display the alert and wait for the user to close it
                alert.showAndWait();
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

        visibleScreanIcons(false);
        try {
            Navigation.switchPaging(paneLoader,"/view/bookManageForm.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    void visibleScreanIcons(boolean y){
        paneLoader.setVisible(y);
        fxbranchesBtn.setVisible(y);
        fxBooksBtn.setVisible(y);
        fxReadersOnAction.setVisible(y);
        txtsearchBar.setVisible(y);
        fxSearchBtn.setVisible(y);
    }

    @FXML
    void btnBranchesOnAction(ActionEvent event) throws IOException {
        Navigation.switchPaging(paneLoader,"/view/branchManageForm.fxml");
    }


    @FXML
    void btnReadersOnAction(ActionEvent event) {
        try {
            Navigation.switchPaging(paneLoader,"/view/userManageAdminSideForm.fxml");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    @FXML
    void searchbtnOnAction(ActionEvent event) {

    }
    public void tnBooksOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.switchPaging(paneLoader,"/view/bookManageForm.fxml");
    }
}
