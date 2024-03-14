package lk.penguin.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import lk.penguin.dto.BooksDto;
import lk.penguin.service.ServiceFactory;
import lk.penguin.service.custom.BookManageService;
import lk.penguin.service.custom.impl.BookManageServiceImpl;
import lk.penguin.util.Navigation;

import java.io.IOException;
import java.util.ArrayList;

public class OrderAvailableBooksFormController {
    public static OrderAvailableBooksFormController ordervailableBookFormController;

    public OrderAvailableBooksFormController(){
        ordervailableBookFormController=this;
    }
    public static OrderAvailableBooksFormController getController(){
        return ordervailableBookFormController;
    }

    @FXML
    private VBox fxBookVbox;
    BookManageService bookManageService= (BookManageServiceImpl) ServiceFactory.getServiceFactory().getService(ServiceFactory.ServiceType.BOOKS);
    public static ArrayList<BooksDto>availableBookList;
    public static ArrayList<BooksDto>addedCartBookList;

    public void initialize() throws IOException {
        availableBookList =bookManageService.getAvailableBooks();
        addedCartBookList=new ArrayList<>();
        refreshTable();
    }

    public void refreshTable() throws IOException {
        fxBookVbox.getChildren().clear();
        if(availableBookList !=null){
            for(BooksDto booksDTO: availableBookList){
                createBookPane(booksDTO);
            }
        }
        Navigation.autoScrollToBottom();
    }

    private void createBookPane(BooksDto booksDTO) throws IOException {
        FXMLLoader loader=new FXMLLoader(BookManageFormController.class.getResource("/view/ordervailableBookRawForm.fxml"));
        Parent root=loader.load();
        OrdervailableBookRawFormController ordervailableBookRawFormController=loader.getController();

        ordervailableBookRawFormController.setDTO(booksDTO);

        fxBookVbox.getChildren().add(root);
    }

}
