package lk.penguin.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import lk.penguin.dto.BooksDto;
import lk.penguin.service.ServiceFactory;
import lk.penguin.service.custom.BookManageService;
import lk.penguin.service.custom.impl.BookManageServiceImpl;

import java.io.IOException;
import java.util.ArrayList;

public class ShowAllBooksFormController {

    @FXML
    private VBox fxBookVbox;
    BookManageService bookManageService= (BookManageServiceImpl) ServiceFactory.getServiceFactory().getService(ServiceFactory.ServiceType.BOOKS);

    public void initialize() throws IOException {
        ArrayList<BooksDto> booksDtos =bookManageService.getAllBooks();
        if(booksDtos !=null){
            for(BooksDto booksDTO: booksDtos){
                createBookPane(booksDTO);
            }
        }

    }

    private void createBookPane(BooksDto booksDTO) throws IOException {
        FXMLLoader loader=new FXMLLoader(BookManageFormController.class.getResource("/view/showAllBooksRaw.fxml"));
        Parent root=loader.load();
        ShowAllBooksRawController showAllBooksRawController=loader.getController();

        showAllBooksRawController.setDTO(booksDTO);

        fxBookVbox.getChildren().add(root);
    }
}
