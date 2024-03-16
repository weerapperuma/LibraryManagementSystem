package lk.penguin.controller;

import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import lk.penguin.dto.BooksDto;
import lk.penguin.dto.TransactionDetailDto;
import lk.penguin.dto.TransactionDto;
import lk.penguin.dto.UserDto;
import lk.penguin.service.ServiceFactory;
import lk.penguin.service.custom.Pane1Service;
import lk.penguin.service.custom.impl.Pane1ServiceImpl;
import lk.penguin.util.Navigation;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class Pane1Controller {

    public static Pane1Controller pane1Controller;
    public Pane1Controller(){
        pane1Controller=this;
    }

    public static Pane1Controller getPane1Controller() {
        return pane1Controller;
    }

    @FXML
    private DatePicker dpReturnDate;

    @FXML
    private JFXButton fxBtnAddedCart;
    @FXML
    public VBox transactionVbox;

    @FXML
    private JFXButton fxSignInBtn;

    @FXML
    private JFXButton fxsearchBooksbtn;

    @FXML
    private Label lblReturntxt;

    @FXML
    private Label lblTimeTodatTxt;

    @FXML
    private Label lblTimeTodayShow;

    @FXML
    private Label lblUsrIdShow;

    @FXML
    private Label lblusrIdTxt;

    @FXML
    private Pane pane1bottom1;

    @FXML
    private Pane pane1bottom2;

    @FXML
    private TextField txtsearchBar;

    @FXML
    private TextField txtSignUserName;

    @FXML
    private TextField txtSignUserPassword;
    @FXML
    private Pane addCartPane;
    @FXML
    private JFXButton fxCompleteTransactionBtn;
    TransactionDto transactionDto=null;
    ArrayList<BooksDto> addedCartBookDtos=null;
    Pane1Service pane1Service= (Pane1ServiceImpl) ServiceFactory.getServiceFactory().getService(ServiceFactory.ServiceType.PANE1);
    @FXML
    void btnAddedCart(ActionEvent event) {
        addCartPane.setVisible(!addCartPane.isVisible());
    }
    @FXML
    void btncompleteTransaction(ActionEvent event) throws IOException {
        addedCartBookDtos=OrderAvailableBooksFormController.addedCartBookList;
        pane1Service.commitTransactions(transactionDto,addedCartBookDtos);
        addCartPane.setVisible(false);
        addCartPane.getChildren().clear();
        Navigation.switchPaging(pane1bottom2,"/view/transactionDetailTable.fxml");
    }

    UserDto userDto=null;
    @FXML
    void btnAvailableBooksOnAction(ActionEvent event) throws IOException {


        transactionDto=new TransactionDto(
                0,
                LocalDateTime.now(),
                dpReturnDate.getValue().atStartOfDay(),
                "incomplete",
                userDto
                );
        if(true){
            Navigation.switchPaging(Pane2Controller.getPane2Controller().fxPanePane2,"/view/orderAvailableBooksForm.fxml");
            Navigation.autoScrollToBottom();
            fxsearchBooksbtn.setDisable(true);
        }
    }

    @FXML
    void btnExitOnAction(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }

    @FXML
    void btnSearchBarOnAction(ActionEvent event) {

    }

    @FXML
    void btnSignInOnAction(ActionEvent event) throws IOException {
        userDto=pane1Service.isExistsUser(txtSignUserName.getText(),txtSignUserPassword.getText());

        if(userDto!=null){
            txtSignUserName.setVisible(false);
            txtSignUserPassword.setVisible(false);
            fxSignInBtn.setVisible(false);

            transactionFormLabelVisible(true);
            lblUsrIdShow.setText(txtSignUserName.getText());
            lblTimeTodayShow.setText(setTodayDate());
            Navigation.switchPaging(pane1bottom2,"/view/transactionDetailTable.fxml");
        }
    }

    private void transactionFormLabelVisible(boolean b) {
        lblusrIdTxt.setVisible(b);
        lblUsrIdShow.setVisible(b);
        lblTimeTodatTxt.setVisible(b);
        lblTimeTodayShow.setVisible(b);
        lblReturntxt.setVisible(b);
        dpReturnDate.setVisible(b);
        fxsearchBooksbtn.setVisible(b);
    }

    @FXML
    void hplinkShowAllBooks(ActionEvent event) throws IOException {
        Navigation.switchPaging(Pane2Controller.getPane2Controller().fxPanePane2,"/view/showAllBooksForm.fxml");
        Navigation.autoScrollToBottom();
    }

    @FXML
    void hplinksignup(ActionEvent event) throws IOException {
        Navigation.popupPaging(pane1bottom1,"/view/createSIgnUpForm.fxml");
    }
    public String setTodayDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String currentDate = dateFormat.format(new Date());
        lblTimeTodayShow.setText(currentDate);
        return currentDate;
    }

    public void initialize(){
        addCartPane.setVisible(false);
        transactionFormLabelVisible(false);
        dpReturnDate.setOnAction(event ->fxsearchBooksbtn.fire());

        txtSignUserName.setOnAction(event ->txtSignUserPassword.requestFocus());
        txtSignUserPassword.setOnAction(event -> fxSignInBtn.fire());
    }

    public void refreshCartForm() throws IOException {
        ArrayList<BooksDto>cartList=OrderAvailableBooksFormController.addedCartBookList;
        transactionVbox.getChildren().clear();
        if(cartList !=null){
            for(BooksDto booksDTO: cartList){
                createBookPane(booksDTO);
            }
        }
    }

    private void createBookPane(BooksDto booksDTO) throws IOException {
        FXMLLoader loader=new FXMLLoader(BookManageFormController.class.getResource("/view/transactionAddedCartRawPane.fxml"));
        Parent root=loader.load();
        TransactionAddedCartRawPaneController transactionAddedCartRawPaneController=loader.getController();

        transactionAddedCartRawPaneController.setDTO(booksDTO);

        transactionVbox.getChildren().add(root);
    }

}
