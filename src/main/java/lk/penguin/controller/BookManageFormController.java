package lk.penguin.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import lk.penguin.dto.BooksDto;
import lk.penguin.service.ServiceFactory;
import lk.penguin.service.custom.BookManageService;
import lk.penguin.util.Navigation;

import java.io.IOException;
import java.util.ArrayList;

public class BookManageFormController {

    @FXML
    private VBox fxBookVbox;
    @FXML
    private Pane bookManagePane;
    @FXML
    void btnAddBookOnAction(ActionEvent event) throws IOException {
        Navigation.popupPaging(bookManagePane,"/view/saveNewBookForm.fxml");
    }

    BookManageService bookManageService= (BookManageService) ServiceFactory.getServiceFactory().getService(ServiceFactory.ServiceType.BOOKS);

    public void initialize() throws IOException {
        ArrayList<BooksDto> booksDtos =bookManageService.getAllBooks();
        if(booksDtos !=null){
            for(BooksDto booksDTO: booksDtos){
                createBookPane(booksDTO);
            }
        }

    }

    private void createBookPane(BooksDto booksDTO) throws IOException {
        FXMLLoader loader=new FXMLLoader(BookManageFormController.class.getResource("/view/bookAdminManageRawForm.fxml"));
        Parent root=loader.load();
        BookAdminManageFormRawController bookAdminManageFormRawController=loader.getController();

        bookAdminManageFormRawController.setDTO(booksDTO);

        fxBookVbox.getChildren().add(root);
    }

}
