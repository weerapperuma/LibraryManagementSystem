package lk.penguin.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import lk.penguin.util.Navigation;

import java.io.IOException;

public class BackgroundFormController {

    @FXML
    private Pane backgroundPane1;

    @FXML
    private Pane backgroundPane2;

    @FXML
    private AnchorPane pagingPane;

    @FXML
    private ScrollPane backgroundScrollPane;

    public void initialize() throws IOException {
        Navigation.setScrollPane(backgroundScrollPane);
        Navigation.switchPaging(backgroundPane1,"/view/pane1.fxml");
        Navigation.switchPaging(backgroundPane2,"/view/pane2.fxml");
    }
}
