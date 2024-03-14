package lk.penguin.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import lk.penguin.dto.BooksDto;
import lk.penguin.util.Navigation;

import java.io.IOException;
import java.util.ArrayList;

public class OrdervailableBookRawFormController {

    @FXML
    private JFXButton addTransactionAddCart;

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

    @FXML
    void btnaddTransactionAddCart(ActionEvent event) {
        ArrayList<BooksDto>list=OrderAvailableBooksFormController.availableBookList;
        int bookIdToRemove= Integer.parseInt(lblbookID.getText());
        BooksDto bookDtoToDelete=null;
        for(BooksDto booksDto:list){
            if(booksDto.getBookId()==bookIdToRemove){
                bookDtoToDelete=booksDto;
                break;
            }

        }if(bookDtoToDelete!=null){
            list.remove(bookDtoToDelete);
            OrderAvailableBooksFormController.availableBookList=list;
            try {
                OrderAvailableBooksFormController.getController().refreshTable();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }

    public void setDTO(BooksDto booksDTO) {
        lblbookID.setText(String.valueOf(booksDTO.getBookId()));
        lblBookName.setText(booksDTO.getBookTitle());
        lblGenre.setText(booksDTO.getGenre());
        lblAvailability.setText(booksDTO.getAvailability());
        lblAuthorName.setText(booksDTO.getAuthor());
    }
}
