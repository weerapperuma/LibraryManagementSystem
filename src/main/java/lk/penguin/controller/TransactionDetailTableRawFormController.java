package lk.penguin.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import lk.penguin.dto.TransactionDto;
import lk.penguin.service.ServiceFactory;
import lk.penguin.service.custom.TransactionTableService;

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
    public TransactionDto transactionDto=new TransactionDto();
    TransactionTableService transactionTableService = (TransactionTableService) ServiceFactory.getServiceFactory().getService(ServiceFactory.ServiceType.TRANSACTIONTABLESERVICE);

    @FXML
    void btnCompleteOnAction(ActionEvent event) {
        transactionTableService.makeReturn(transactionDto);
    }



    public void setDTO(TransactionDto transactionDto) {
        this.transactionDto=transactionDto;
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
