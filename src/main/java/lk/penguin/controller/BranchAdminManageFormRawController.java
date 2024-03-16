package lk.penguin.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import lk.penguin.dto.BranchDto;
import lk.penguin.service.ServiceFactory;
import lk.penguin.service.custom.BranchService;
import lk.penguin.service.custom.impl.BranchServiceImpl;
import lk.penguin.util.Navigation;

import java.io.IOException;

public class BranchAdminManageFormRawController {


    private final BranchService branchService= (BranchServiceImpl) ServiceFactory.getServiceFactory().getService(ServiceFactory.ServiceType.BRANCH);

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private Label lblAvailability;

    @FXML
    private Label lblBrnchName;

    @FXML
    private Label lblContact;

    @FXML
    private Label lblDistrict;

    @FXML
    private Label lblbookID;
    public static BranchDto branchDto;

    @FXML
    void btnAdelete(ActionEvent event) {
        try {
            branchService.deleteBranch(Integer.parseInt(lblbookID.getText()));
            Navigation.switchPaging(WelcomeFormController.getWelcomeFormController().paneLoader, "/view/branchManageForm.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        branchDto=new BranchDto(
                Integer.parseInt(lblbookID.getText()),
                lblBrnchName.getText(),
                lblDistrict.getText(),
                lblContact.getText(),
                lblAvailability.getText(),
                WelcomeFormController.admin
        );
        try {
            Navigation.popupPaging(WelcomeFormController.getWelcomeFormController().paneLoader, "/view/updateBranchForm.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void setDTO(BranchDto branchDto) {
        lblbookID.setText(String.valueOf(branchDto.getBranchId()));
        lblBrnchName.setText(branchDto.getBranchName());
        lblDistrict.setText(branchDto.getBranchDistrict());
        lblContact.setText(branchDto.getBranchContactNb());
        lblAvailability.setText(branchDto.getBranchAvailability());
    }


}
