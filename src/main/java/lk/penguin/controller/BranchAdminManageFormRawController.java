package lk.penguin.controller;

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

    @FXML
    private Label lblAvailability;

    @FXML
    private Label lblBranchContact;

    @FXML
    private Label lblBranchID;

    @FXML
    private Label lblBranchName;

    @FXML
    private Label lblBranchdistrict;

    public static int branchId;
    public static String branchName=null;
    public static String branchContact=null;
    public static String district =null;
    public static String availability =null;
    private final BranchService branchService= (BranchServiceImpl) ServiceFactory.getServiceFactory().getService(ServiceFactory.ServiceType.BRANCH);

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        boolean isDeleted = branchService.deleteBranch(Integer.parseInt(lblBranchID.getText()));
        if(isDeleted){
            try {
                Navigation.switchPaging(UserDashBoard.getUserDashBoard().mainAdminPaneInterface, "/view/branchManageForm.fxml");
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        branchId= Integer.parseInt(lblBranchID.getText());
        branchName = lblBranchName.getText();
        branchContact=lblBranchContact.getText();
        availability=lblAvailability.getText();
        district=lblBranchdistrict.getText();
        try {
            Navigation.popupPaging(UserDashBoard.getUserDashBoard().mainAdminPaneInterface, "/view/saveNewBranch.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setDTO(BranchDto branchDto) {
        lblBranchID.setText(String.valueOf(branchDto.getBranchId()));
        lblBranchName.setText(branchDto.getBranchName());
        lblBranchContact.setText(branchDto.getBranchContactNb());
        lblAvailability.setText(branchDto.getBranchAvailability());
        lblBranchdistrict.setText(branchDto.getBranchDistrict());
    }
}
