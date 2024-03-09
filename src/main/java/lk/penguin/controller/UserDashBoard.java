package lk.penguin.controller;

import com.jfoenix.controls.JFXButton;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import lk.penguin.util.Navigation;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserDashBoard {

    @FXML
    private JFXButton fxbtnBook;
    @FXML
    public Pane mainAdminPaneInterface;

    private static UserDashBoard userDashBoard;
    public UserDashBoard(){
        userDashBoard=this;
    }
    public static UserDashBoard getUserDashBoard(){
        return userDashBoard;
    }

    @FXML
    private JFXButton fxbtnBranches;

    @FXML
    private JFXButton fxbtnReader;
    @FXML
    void btnNavigateOnAction(ActionEvent event) throws IOException {
        Navigation.switchNavigation("/view/welcomeForm.fxml",event);
    }


    @FXML
    private Label lblDate;

    @FXML
    private Label lblTime;

    @FXML
    void btnBooksOnAction(ActionEvent event) throws IOException {
        Navigation.switchPaging(mainAdminPaneInterface,"/view/bookManageForm.fxml");
        Navigation.switchPaging(mainAdminPaneInterface,"/view/bookManageForm.fxml");
    }

    @FXML
    void btnBranchesOnAction(ActionEvent event) {

    }

    @FXML
    void btnCloseOnAction(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }

    @FXML
    void btnReaderOnAction(ActionEvent event) {

    }
    public void initialize(){
        startClock();
        setTodayDate();
    }
    public void startClock() {
        Timeline clockTimeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
            String currentTime = timeFormat.format(new Date());
            lblTime.setText(currentTime);
        }));
        clockTimeline.setCycleCount(Timeline.INDEFINITE);
        clockTimeline.play();
    }

    public void setTodayDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String currentDate = dateFormat.format(new Date());
        lblDate.setText(currentDate);
    }




}
