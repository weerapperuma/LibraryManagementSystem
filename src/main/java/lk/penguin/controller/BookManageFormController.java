package lk.penguin.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import lk.penguin.dto.BooksDTO;
import lk.penguin.service.ServiceFactory;
import lk.penguin.service.custom.BookManageService;

import java.io.IOException;
import java.util.ArrayList;

public class BookManageFormController {

    @FXML
    private VBox fxBookVbox;
    @FXML
    void btnAddBookOnAction(ActionEvent event) {
        System.out.println("");
    }

    BookManageService bookManageService= (BookManageService) ServiceFactory.getServiceFactory().getService(ServiceFactory.ServiceType.BOOKS);

    public void initialize() throws IOException {
        ArrayList<BooksDTO> booksDTOS=bookManageService.getAllBooks();
        if(booksDTOS!=null){
            for(BooksDTO booksDTO:booksDTOS){
                createBookPane(booksDTO);
            }
        }
    }

    private void createBookPane(BooksDTO booksDTO) throws IOException {
        FXMLLoader loader=new FXMLLoader(BookManageFormController.class.getResource("/view/bookAdminManageRawForm.fxml"));
        Parent root=loader.load();
        BookAdminManageFormRawController bookAdminManageFormRawController=loader.getController();

        bookAdminManageFormRawController.setDTO(booksDTO);

        fxBookVbox.getChildren().add(root);
    }

}
