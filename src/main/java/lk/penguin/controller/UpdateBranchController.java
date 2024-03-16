package lk.penguin.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import lk.penguin.dto.BranchDto;
import lk.penguin.service.ServiceFactory;
import lk.penguin.service.custom.BranchService;
import lk.penguin.service.custom.impl.BranchServiceImpl;
import lk.penguin.util.Navigation;
import lk.penguin.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;

public class UpdateBranchController {

    @FXML
    private JFXButton btnBranchExitOnAction;

    @FXML
    private JFXComboBox<String> cmbBranchAvailability;

    @FXML
    private JFXComboBox<String> cmbBranchDistrict;

    @FXML
    private JFXButton fxbtnUpdate;

    @FXML
    private JFXButton fxbtnUpdate1;

    @FXML
    private TextField txtContactNum;

    @FXML
    private TextField txtaBranchName;
    BranchDto branchDto=null;
    private Session session;

    BranchService branchService= (BranchServiceImpl) ServiceFactory.getServiceFactory().getService(ServiceFactory.ServiceType.BRANCH);

    @FXML
    void btnBranchSaveExit(ActionEvent event) {
        Navigation.closePopup();
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) throws IOException {


        BranchDto branchDto2=new BranchDto(
                branchDto.getBranchId(),
                txtaBranchName.getText(),
                cmbBranchDistrict.getValue(),
                txtContactNum.getText(),
                cmbBranchAvailability.getValue(),
                branchDto.getAdmin()
        );
        boolean update = branchService.update(branchDto2);
        if (update){
            Navigation.switchPaging(WelcomeFormController.getWelcomeFormController().paneLoader, "/view/branchManageForm.fxml");
            Navigation.closePopup();
        }
    }
    public void initialize(){
        branchDto=BranchAdminManageFormRawController.branchDto;
        cmbBranchAvailability.setItems(FXCollections.observableArrayList("available","unavailable"));
        cmbBranchAvailability.setValue(branchDto.getBranchAvailability());

        cmbBranchDistrict.setItems((FXCollections.observableArrayList(
                "Galle","Matara","Colombo","Gampaha")));

        cmbBranchDistrict.setValue(branchDto.getBranchDistrict());
        txtaBranchName.setText(branchDto.getBranchName());
        txtContactNum.setText(branchDto.getBranchContactNb());

        txtaBranchName.setOnAction(event ->txtContactNum.requestFocus());
        txtContactNum.setOnAction(event ->cmbBranchDistrict.requestFocus());
        cmbBranchAvailability.setOnAction(event ->fxbtnUpdate.fire());
    }

}
