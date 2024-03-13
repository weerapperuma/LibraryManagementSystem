package lk.penguin.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import lk.penguin.dto.UserDto;

public class MemberRawFormController {

    @FXML
    private Label lblName;

    @FXML
    private Label lblUserContact;

    @FXML
    private Label lblUserEmail;

    @FXML
    private Label lblUserId;

    @FXML
    private Label lblUserName;

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    public void setDTO(UserDto userDto) {
        lblUserId.setText(String.valueOf(userDto.getUserId()));
        lblName.setText(userDto.getName());
        lblUserEmail.setText(userDto.getUserEmail());
        lblUserContact.setText(userDto.getContact());
    }
}
