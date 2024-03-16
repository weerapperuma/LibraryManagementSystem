package lk.penguin.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import lk.penguin.dto.TransactionDto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TransactionDetailTableRawFormController {

    @FXML
    private JFXButton fxbtnCompleteOnAction;

    @FXML
    private Label lblDueDay;

    @FXML
    private Label lblId;

    @FXML
    private Label lblOrderDay;

    @FXML
    private Label lblStatus;

    @FXML
    void btnCompleteOnAction(ActionEvent event) {

    }

    public void setDTO(TransactionDto transactionDto) {
        lblId.setText(String.valueOf(transactionDto.getTransactionId()));
        lblOrderDay.setText(String.valueOf(convertDate(transactionDto.getOrderTime())));
        lblDueDay.setText(String.valueOf(convertDate(transactionDto.getDueDate())));
        lblStatus.setText(transactionDto.getCompletenceStatus());

        if(transactionDto.getCompletenceStatus()=="complete"){
            fxbtnCompleteOnAction.setVisible(false);
        }
    }
    public LocalDate convertDate(LocalDateTime dateTime2){
        LocalDate dateOnly = dateTime2.toLocalDate();

        return dateOnly;
    }
}
