package lk.penguin.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import lk.penguin.dto.BranchDto;
import lk.penguin.service.ServiceFactory;
import lk.penguin.service.custom.BranchService;
import lk.penguin.service.custom.impl.BranchServiceImpl;
import lk.penguin.util.Navigation;

import java.io.IOException;

public class UpdateBranchController {

    @FXML
    private JFXButton btnBranchExitOnAction;

    @FXML
    private JFXComboBox<?> cmbBranchAvailability;

    @FXML
    private JFXComboBox<?> cmbBranchDistrict;

    @FXML
    private JFXButton fxbtnUpdate;

    @FXML
    private JFXButton fxbtnUpdate1;

    @FXML
    private TextField txtContactNum;

    @FXML
    private TextField txtaBranchName;

    BranchService branchService= (BranchServiceImpl) ServiceFactory.getServiceFactory().getService(ServiceFactory.ServiceType.BRANCH);

    @FXML
    void btnBranchSaveExit(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) throws IOException {

        BranchDto branchDto=new BranchDto(
            BranchAdminManageFormRawController.branchId,
                BranchAdminManageFormRawController.branchName,
                BranchAdminManageFormRawController.district,
                BranchAdminManageFormRawController.branchContact,
                BranchAdminManageFormRawController.availability,
                WelcomeFormController.admin
        );
        if(branchService.update(branchDto)){
            Navigation.switchPaging(UserDashBoard.getUserDashBoard().mainAdminPaneInterface,"/view/branchManageForm.fxml");
            Navigation.closePopup();
        }
    }

}
