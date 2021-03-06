package es.azarquiel.pkg3enraya;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AppUIController implements Initializable {

    // @FXML
    // private Label label;
    
    protected void handleEventReceived() {
        // Here we'd receive the important code!
    }
    
    @FXML
    private void handleOpenAction(ActionEvent event) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("oh hai there");
        alert.setHeaderText("Hey, you clicked me");
        alert.setContentText("Hello, world!");

        alert.showAndWait();
    }

    @FXML
    private void handleCloseAction(ActionEvent event) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("how could you do this");
        alert.setHeaderText("You clicked that, you idiot!!!");
        alert.setContentText("Goodbye, world...");

        alert.showAndWait();
        Platform.exit();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
