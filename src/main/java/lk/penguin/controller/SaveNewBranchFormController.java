package lk.penguin.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import lk.penguin.dto.BranchDto;
import lk.penguin.service.ServiceFactory;
import lk.penguin.service.custom.BranchService;
import lk.penguin.service.custom.impl.BranchServiceImpl;
import lk.penguin.util.Navigation;
import lk.penguin.util.RegexUtil;

import java.io.IOException;

public class SaveNewBranchFormController {

    @FXML
    private JFXButton btnBranchExitOnAction;

    @FXML
    private JFXComboBox<String> cmbBranchAvailability;

    @FXML
    private JFXComboBox<String> cmbBranchDistrict;

    @FXML
    private JFXButton fxbtnSave;

    @FXML
    private TextField txtContactNum;

    @FXML
    private TextField txtaBranchName;



    private final BranchService branchService= (BranchServiceImpl) ServiceFactory.getServiceFactory().getService(ServiceFactory.ServiceType.BRANCH);
    @FXML
    void btnBranchSaveExit(ActionEvent event) {
        Navigation.closePopup();
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) throws IOException {
        if(RegexUtil.validateBranch(txtaBranchName.getText(),txtContactNum.getText())){
            BranchDto branchDto=new BranchDto(
                    0,
                    txtaBranchName.getText(),
                    (String) cmbBranchDistrict.getValue(),
                    txtContactNum.getText(),
                    (String) cmbBranchAvailability.getValue(),
                    WelcomeFormController.admin

            );

            int save = branchService.save(branchDto);
            if(save>0) {
                Navigation.switchPaging(WelcomeFormController.getWelcomeFormController().paneLoader, "/view/branchManageForm.fxml");
                Navigation.closePopup();
            }
        }
    }

    public void initialize(){
        cmbBranchAvailability.setItems(FXCollections.observableArrayList("available","unavailable"));
        cmbBranchAvailability.setValue("available");

        cmbBranchDistrict.setItems((FXCollections.observableArrayList(
                "Galle","Matara","Colombo","Gampaha")));

        cmbBranchDistrict.setValue("Galle");

        txtaBranchName.setOnAction(event ->txtContactNum.requestFocus());
        txtContactNum.setOnAction(event ->cmbBranchDistrict.requestFocus());
        cmbBranchAvailability.setOnAction(event ->fxbtnSave.fire());
    }


}
