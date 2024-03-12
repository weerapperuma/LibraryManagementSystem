package lk.penguin.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import lk.penguin.dto.BooksDto;
import lk.penguin.dto.BranchDto;
import lk.penguin.service.ServiceFactory;
import lk.penguin.service.custom.BranchService;
import lk.penguin.service.custom.impl.BranchServiceImpl;
import lk.penguin.util.Navigation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BranchManageFormController {
    @FXML
    private AnchorPane bookManagePane;

    @FXML
    private VBox fxBranchVbox;

    private final BranchService branchService= (BranchServiceImpl) ServiceFactory.getServiceFactory().getService(ServiceFactory.ServiceType.BRANCH);
    @FXML
    void btnAddBranchOnAction(ActionEvent event) throws IOException {
        Navigation.popupPaging(bookManagePane,"/view/saveNewBranch.fxml");
    }

    public void initialize() throws IOException {
        List<BranchDto> branchDtos =branchService.getAllBranches();
        if(branchDtos !=null){
            for(BranchDto branchDto: branchDtos){
                createBookPane(branchDto);
            }
        }

    }

    private void createBookPane(BranchDto branchDto) throws IOException {
        FXMLLoader loader=new FXMLLoader(BookManageFormController.class.getResource("/view/branchAdminManageRawForm.fxml"));
        Parent root=loader.load();
        BranchAdminManageFormRawController branchAdminManageFormRawController=loader.getController();

        branchAdminManageFormRawController.setDTO(branchDto);

        fxBranchVbox.getChildren().add(root);
    }
}
