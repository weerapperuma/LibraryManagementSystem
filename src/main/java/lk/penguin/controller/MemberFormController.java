package lk.penguin.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import lk.penguin.dto.BranchDto;
import lk.penguin.dto.UserDto;
import lk.penguin.service.ServiceFactory;
import lk.penguin.service.custom.MemberService;
import lk.penguin.service.custom.impl.MemberServiceImpl;
import lk.penguin.util.Navigation;

import java.io.IOException;
import java.util.List;

public class MemberFormController {

    @FXML
    private AnchorPane bookManagePane;

    @FXML
    private VBox fxBranchVbox;
    private final MemberService memberService= (MemberServiceImpl) ServiceFactory.getServiceFactory().getService(ServiceFactory.ServiceType.MEMBER);

    public void initialize() throws IOException {
        List<UserDto> userDtos =memberService.getAllMembers();
        if(userDtos !=null){
            for(UserDto userDto:userDtos){
                createMemberPane(userDto);
            }
        }

    }

    private void createMemberPane(UserDto userDto) throws IOException {
        FXMLLoader loader=new FXMLLoader(MemberFormController.class.getResource("/view/membeRawForm.fxml"));
        Parent root=loader.load();
        MemberRawFormController memberRawFormController=loader.getController();

        memberRawFormController.setDTO(userDto);

        fxBranchVbox.getChildren().add(root);
    }

}
