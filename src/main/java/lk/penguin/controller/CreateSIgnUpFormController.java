package lk.penguin.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import lk.penguin.dto.UserDto;
import lk.penguin.service.ServiceFactory;
import lk.penguin.service.custom.CreateSignUpService;
import lk.penguin.service.custom.impl.CreateSignUpServiceImpl;
import lk.penguin.util.Navigation;

import java.nio.file.attribute.FileAttribute;
import java.util.regex.Pattern;

public class CreateSIgnUpFormController {

    @FXML
    private JFXButton fxBtnSignUp;

    @FXML
    private TextField fxEmailNewUsr;

    @FXML
    private TextField fxNameNewUsr;

    @FXML
    private TextField fxNameNewUsrId;

    @FXML
    private TextField fxNewUsrContact;

    @FXML
    private PasswordField fxRePasswordNewUsr;

    @FXML
    private PasswordField fxpasswordNewUsr;

    CreateSignUpService createSignUpService= (CreateSignUpServiceImpl) ServiceFactory.getServiceFactory().getService(ServiceFactory.ServiceType.CREATESIGNUP);

    @FXML
    void btnClose(ActionEvent event) {
        Navigation.closePopup();
    }

    @FXML
    void btnSignUpnAction(ActionEvent event) {
        if(true){
            UserDto userDto=new UserDto(
                    0,
                    fxNameNewUsr.getText(),
                    Integer.parseInt(fxNameNewUsrId.getText()),
                    fxNewUsrContact.getText(),
                    fxEmailNewUsr.getText(),
                    fxRePasswordNewUsr.getText(),null
            );
            int saved=createSignUpService.saveNewUser(userDto);

            if(saved>0){
                Navigation.closePopup();
            }
        }
    }

    private boolean validated() {
        if(fxNameNewUsr.getText()!=null){
            if(fxEmailNewUsr!=null){
                boolean isEmailValidated=Pattern.compile("^\\+(?:[0-9] ?){6,14}[0-9]$").matcher(fxEmailNewUsr.getText()).matches();
                if(!isEmailValidated){
                    return false;
                }
            }
            if(!(fxNameNewUsrId.getLength() >3)){
                return false;
            }
            if(!fxpasswordNewUsr.getText().equals(fxRePasswordNewUsr.getText())){
                return false;
            }
        }return true;
    }
    public void initialize(){
        fxNameNewUsr.setOnAction(event ->fxNameNewUsrId.requestFocus());
        fxNameNewUsrId.setOnAction(event ->fxNewUsrContact.requestFocus());
        fxNewUsrContact.setOnAction(event ->fxEmailNewUsr.requestFocus());
        fxEmailNewUsr.setOnAction(event ->fxpasswordNewUsr.requestFocus());
        fxpasswordNewUsr.setOnAction(event ->fxRePasswordNewUsr.requestFocus());
        fxRePasswordNewUsr.setOnAction(event ->fxBtnSignUp.fire());
    }

}

