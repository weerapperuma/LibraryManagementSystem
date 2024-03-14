package lk.penguin.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import lk.penguin.dto.BooksDto;

import java.io.IOException;
import java.util.ArrayList;

public class TransactionAddedCartRawPaneController {

    @FXML
    private Label lblAddedName;
    public int bookid=0;

    @FXML
    void deleteBtnOnAction(ActionEvent event) throws IOException {
        int bookIdToRemove= bookid;
        BooksDto bookDtoToDelete=null;
        ArrayList<BooksDto>addedCartlist=OrderAvailableBooksFormController.addedCartBookList;
        ArrayList<BooksDto>availableList=OrderAvailableBooksFormController.availableBookList;
        for(BooksDto booksDto:addedCartlist){
            if(booksDto.getBookId()==bookIdToRemove){
                bookDtoToDelete=booksDto;
                break;
            }

        }if(bookDtoToDelete!=null){
            addedCartlist.remove(bookDtoToDelete);
            availableList.add(bookDtoToDelete);
            Pane1Controller.getPane1Controller().refreshCartForm();
            OrderAvailableBooksFormController.availableBookList=availableList;
            OrderAvailableBooksFormController.addedCartBookList=addedCartlist;
            try {
                OrderAvailableBooksFormController.getController().refreshTable();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }

    public void setDTO(BooksDto booksDTO) {
        bookid= booksDTO.getBookId();
        lblAddedName.setText(booksDTO.getBookTitle());
    }
}
