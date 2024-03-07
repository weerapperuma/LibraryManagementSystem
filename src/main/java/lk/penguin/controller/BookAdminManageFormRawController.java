package lk.penguin.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import lk.penguin.dto.BooksDTO;

public class BookAdminManageFormRawController {
    @FXML
    private Label lblAvailability;

    @FXML
    private Label lblBookAuthor;

    @FXML
    private Label lblBookGenre;

    @FXML
    private Label lblBookID;

    @FXML
    private Label lblBookName;

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }
    public void setDTO(BooksDTO booksDTO) {
        lblBookID.setText(String.valueOf(booksDTO.getBookId()));
        lblBookAuthor.setText(booksDTO.getAuthor());
        lblBookGenre.setText(booksDTO.getGenre());
        lblBookName.setText(booksDTO.getBookTitle());
        lblAvailability.setText(booksDTO.getAvailability());
    }
}
