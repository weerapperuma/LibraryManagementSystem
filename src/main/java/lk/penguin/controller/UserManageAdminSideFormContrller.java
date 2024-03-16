package lk.penguin.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import lk.penguin.dto.BooksDto;
import lk.penguin.dto.UserDto;
import lk.penguin.service.ServiceFactory;
import lk.penguin.service.custom.MemberService;
import lk.penguin.service.custom.impl.MemberServiceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserManageAdminSideFormContrller {

    @FXML
    private AnchorPane bookManagePane;

    @FXML
    private VBox fxBookVbox;

    @FXML
    private Label lblBrnchName;

    MemberService memberService= (MemberServiceImpl) ServiceFactory.getServiceFactory().getService(ServiceFactory.ServiceType.MEMBER);

    public void initialize() throws IOException {
        List<UserDto> userDtos =memberService.getAllMembers();
        if(userDtos !=null){
            for(UserDto userDto:userDtos){
                createBookPane(userDto);
            }
        }

    }

    private void createBookPane(UserDto userDto) throws IOException {
        FXMLLoader loader=new FXMLLoader(BookManageFormController.class.getResource("/view/userAdminSideTableRawForm.fxml"));
        Parent root=loader.load();
        UserAdminSideRawFormController userAdminSideRawFormController=loader.getController();

        userAdminSideRawFormController.setDTO(userDto);

        fxBookVbox.getChildren().add(root);
    }

}
