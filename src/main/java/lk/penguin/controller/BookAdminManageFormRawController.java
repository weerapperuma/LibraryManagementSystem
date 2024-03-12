package lk.penguin.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import lk.penguin.dto.BooksDto;
import lk.penguin.service.ServiceFactory;
import lk.penguin.service.custom.BookManageService;
import lk.penguin.util.Navigation;

import java.io.IOException;

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
    BookManageService bookManageService= (BookManageService) ServiceFactory
            .getServiceFactory()
            .getService(ServiceFactory.ServiceType.BOOKS);

    @FXML
    void btnDeleteOnAction(ActionEvent event) throws IOException {
        if(bookManageService.delete(Integer.parseInt(lblBookID.getText()))){
            Navigation.switchPaging(
                    UserDashBoard.getUserDashBoard().mainAdminPaneInterface, "/view/bookManageForm.fxml");
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) throws IOException {
        SaveNewBookFormController.bookID=Integer.parseInt(lblBookID.getText());
        SaveNewBookFormController.bookTitle=lblBookName.getText();
        SaveNewBookFormController.genre=lblBookGenre.getText();
        SaveNewBookFormController.author=lblBookAuthor.getText();
        SaveNewBookFormController.availability=lblAvailability.getText();

        Navigation.popupPaging(UserDashBoard.getUserDashBoard().mainAdminPaneInterface, "/view/saveNewBookForm.fxml");

    }
    public void setDTO(BooksDto booksDTO) {
        lblBookID.setText(String.valueOf(booksDTO.getBookId()));
        lblBookAuthor.setText(booksDTO.getAuthor());
        lblBookGenre.setText(booksDTO.getGenre());
        lblBookName.setText(booksDTO.getBookTitle());
        lblAvailability.setText(booksDTO.getAvailability());
    }
}
