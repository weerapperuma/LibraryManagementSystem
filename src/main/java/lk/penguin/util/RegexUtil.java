package lk.penguin.util;

import javafx.scene.control.Alert;

import java.util.regex.Pattern;

public class RegexUtil {
    public static boolean validateBranch(String branchName,String contactNb){
        if(branchName.length()<4){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Branch Name");
            alert.setHeaderText("An Error Occurred");
            alert.setContentText("Invalid Branch name");

            // Display the alert and wait for the user to close it
            alert.showAndWait();
            return false;
        }
        String trimmedContactNb = contactNb.trim();

        boolean isContactNumberValid = Pattern.compile("^\\d{1,15}$").matcher(trimmedContactNb).matches();

        if (!isContactNumberValid) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Contact Number");
            alert.setHeaderText("Invalid Contact Number");
            alert.setContentText("Contact number can only include numbers with a maximum of 15 digits.");

            // Display the alert and wait for the user to close it
            alert.showAndWait();

            return false;
        }
        return true;
    }
}
