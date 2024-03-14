package lk.penguin.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import lk.penguin.dto.BooksDto;

public class TransactionAddedCartRawPaneController {

    @FXML
    private Label lblAddedName;

    @FXML
    void deleteBtnOnAction(ActionEvent event) {

    }

    public void setDTO(BooksDto booksDTO) {
        lblAddedName.setText(booksDTO.getBookTitle());
    }
}
