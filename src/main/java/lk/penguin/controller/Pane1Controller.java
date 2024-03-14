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
import lk.penguin.service.ServiceFactory;
import lk.penguin.service.custom.Pane1Service;
import lk.penguin.service.custom.impl.Pane1ServiceImpl;
import lk.penguin.util.Navigation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.text.SimpleDateFormat;
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
    Pane1Service pane1Service= (Pane1ServiceImpl) ServiceFactory.getServiceFactory().getService(ServiceFactory.ServiceType.PANE1);
    @FXML
    void btnAddedCart(ActionEvent event) {
        addCartPane.setVisible(!addCartPane.isVisible());
    }
    @FXML
    void btncompleteTransaction(ActionEvent event) {
        addCartPane.setVisible(false);
    }

    @FXML
    void btnAvailableBooksOnAction(ActionEvent event) throws IOException {
        Navigation.switchPaging(Pane2Controller.getPane2Controller().fxPanePane2,"/view/orderAvailableBooksForm.fxml");
        Navigation.autoScrollToBottom();
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
    void btnSignInOnAction(ActionEvent event) {
        boolean isuserExists=pane1Service.isExistsUser(txtSignUserName.getText(),txtSignUserPassword.getText());
        if(isuserExists){
            txtSignUserName.setVisible(false);
            txtSignUserPassword.setVisible(false);
            fxSignInBtn.setVisible(false);

            transactionFormLabelVisible(true);
            lblUsrIdShow.setText(txtSignUserName.getText());
            lblTimeTodayShow.setText(setTodayDate());
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
    void hplinksignup(ActionEvent event) {

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
