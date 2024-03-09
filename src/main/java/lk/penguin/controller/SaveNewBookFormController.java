package lk.penguin.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import lk.penguin.dto.BooksDTO;
import lk.penguin.service.ServiceFactory;
import lk.penguin.service.custom.BookManageService;
import lk.penguin.util.Navigation;

import java.io.IOException;

public class SaveNewBookFormController {

    @FXML
    private JFXButton btnVehicleExitOnAction;

    @FXML
    private JFXComboBox<String> cmbBookGenre;

    @FXML
    private JFXComboBox<String> cmbBookStatus;

    @FXML
    private TextField txtAuthorName;

    @FXML
    private TextField txtBookTitle;
    @FXML
    private JFXButton fxbtnSave;
    public static int bookID=0;
    public static String bookTitle=null;
    public static String genre=null;
    public static String author=null;
    public static String availability="available";
    BookManageService bookManageService= (BookManageService) ServiceFactory.getServiceFactory().getService(ServiceFactory.ServiceType.BOOKS);

    @FXML
    void btnSaveOnAction(ActionEvent event) throws IOException {
        BooksDTO booksDTO=new BooksDTO(
                bookID,
                txtBookTitle.getText(),
                (String) cmbBookGenre.getValue(),
                txtAuthorName.getText(),
                (String) cmbBookStatus.getValue()

        );

        if(bookID==0){

            if(bookManageService.save(booksDTO)){
                Navigation.switchPaging(UserDashBoard.getUserDashBoard().mainAdminPaneInterface,"/view/bookManageForm.fxml");
                nullValues();
                Navigation.closePopup();
            }
        }else {
            if(bookManageService.update(booksDTO)){
                Navigation.switchPaging(UserDashBoard.getUserDashBoard().mainAdminPaneInterface,"/view/bookManageForm.fxml");
                nullValues();
                Navigation.closePopup();
            }
        }

    }

    @FXML
    void btnVehicleSaveExit(ActionEvent event) {
        Navigation.closePopup();
    }

    public void initialize(){
        cmbBookStatus.setItems(FXCollections.observableArrayList("available","unavailable"));
        cmbBookStatus.setValue(availability);

        cmbBookGenre.setItems((FXCollections.observableArrayList(
                "Fiction","Non-fiction","Mystery","Thriller","Romance",
                "Science Fiction","Fantasy","Horror",
                "Biography","Memoir")));

        cmbBookGenre.setValue(genre);

        txtBookTitle.setText(bookTitle);
        txtAuthorName.setText(author);

        txtBookTitle.setOnAction(event ->txtAuthorName.requestFocus());
        txtAuthorName.setOnAction(event ->cmbBookGenre.requestFocus());
        cmbBookGenre.setOnAction(event ->cmbBookStatus.requestFocus());
        cmbBookStatus.setOnAction(event ->fxbtnSave.fire());
    }

    public void nullValues(){
        bookID=0;
        bookTitle=null;
        genre="Fiction";
        author=null;
        availability="available";
    }
}
