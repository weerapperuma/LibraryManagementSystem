package lk.penguin.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import lk.penguin.dto.UserDto;
import lk.penguin.service.ServiceFactory;
import lk.penguin.service.custom.MemberService;
import lk.penguin.service.custom.impl.MemberServiceImpl;
import lk.penguin.util.Navigation;

import java.io.IOException;

public class UserAdminSideRawFormController {

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private Label lblAdminId;

    @FXML
    private Label lblContact;

    @FXML
    private Label lblUserEmail;

    @FXML
    private Label lblUserId;

    @FXML
    private Label lblUserName;
    MemberService memberService= (MemberServiceImpl) ServiceFactory.getServiceFactory().getService(ServiceFactory.ServiceType.MEMBER);

    public static UserDto userDto2=null;

    @FXML
    void btndelete(ActionEvent event) {
        boolean isDeleted=memberService.delete(Integer.parseInt(lblUserId.getText()));

        if(isDeleted){
            try {
                Navigation.switchPaging(WelcomeFormController.getWelcomeFormController().paneLoader, "/view/userManageAdminSideForm.fxml");
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }

    public void setDTO(UserDto userDto) {
        userDto2=userDto;
        lblUserId.setText(String.valueOf(userDto.getUserId()));
        lblUserName.setText(userDto.getName());
        lblContact.setText(userDto.getContact());
        lblUserEmail.setText(userDto.getUserEmail());
        lblAdminId.setText("1");
    }
}
