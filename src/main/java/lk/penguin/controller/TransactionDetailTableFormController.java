package lk.penguin.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import lk.penguin.dto.BooksDto;
import lk.penguin.dto.TransactionDto;
import lk.penguin.service.ServiceFactory;
import lk.penguin.service.custom.TransactionTableService;
import lk.penguin.service.custom.impl.TransactionTableServiceImpl;

import java.io.IOException;
import java.util.ArrayList;

public class TransactionDetailTableFormController {

    @FXML
    private Pane transactionTableLoadPane;

    @FXML
    private VBox vbox;
    TransactionTableService transactionTableService = (TransactionTableServiceImpl) ServiceFactory.getServiceFactory().getService(ServiceFactory.ServiceType.TRANSACTIONTABLESERVICE);

    public void initialize() throws IOException {
        ArrayList<TransactionDto> transactionDtos = transactionTableService.getAllTransactions();
        System.out.println("huuuuu"+transactionDtos);
        if(transactionDtos !=null){
            for(TransactionDto transactionDto:transactionDtos){
                createBookPane(transactionDto);
            }
        }
    }

    private void createBookPane(TransactionDto transactionDto) throws IOException {
        FXMLLoader loader=new FXMLLoader(BookManageFormController.class.getResource("/view/transactionDetailTableRaw.fxml"));
        Parent root=loader.load();
        TransactionDetailTableRawFormController transactionDetailTableRawFormController=loader.getController();

        transactionDetailTableRawFormController.setDTO(transactionDto);

        vbox.getChildren().add(root);
    }

}
