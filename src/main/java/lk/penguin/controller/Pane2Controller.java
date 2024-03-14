package lk.penguin.controller;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import lk.penguin.util.Navigation;

import java.io.IOException;

public class Pane2Controller {
    private static Pane2Controller pane2Controller;

    public Pane2Controller(){
        pane2Controller=this;
    }
    public static Pane2Controller getPane2Controller(){
        return pane2Controller;
    }

    @FXML
    public Pane fxPanePane2;

    public void initialize() throws IOException {
        Navigation.switchPaging(fxPanePane2,"/view/showAllBooksForm.fxml");
    }

}
