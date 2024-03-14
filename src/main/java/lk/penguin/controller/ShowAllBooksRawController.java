package lk.penguin.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import lk.penguin.dto.BooksDto;
import lk.penguin.service.ServiceFactory;
import lk.penguin.service.custom.BookManageService;
import lk.penguin.service.custom.impl.BookManageServiceImpl;

import java.io.IOException;
import java.util.ArrayList;

public class ShowAllBooksRawController {

    @FXML
    private Label lblAuthorName;

    @FXML
    private Label lblAvailability;

    @FXML
    private Label lblBookName;

    @FXML
    private Label lblGenre;

    @FXML
    private Label lblbookID;


    public void setDTO(BooksDto booksDTO) {
        lblbookID.setText(String.valueOf(booksDTO.getBookId()));
        lblBookName.setText(booksDTO.getBookTitle());
        lblGenre.setText(booksDTO.getGenre());
        lblAvailability.setText(booksDTO.getAvailability());
        lblAuthorName.setText(booksDTO.getAuthor());
    }
}
