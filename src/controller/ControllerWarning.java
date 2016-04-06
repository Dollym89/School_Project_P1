package controller;

import handler.HandleButtonAction;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;


public class ControllerWarning {
    public Button OkNoMatchButton;
    public Button OkButton;
    public Button newUserButton;
    public Button tryAgainButton;

    public HandleButtonAction handler = new HandleButtonAction();

    /**
     * Created by Michal on 14/11/2015.
     */


    public void handleButtonActionNewUser() throws IOException {

        Stage stage;
        Parent root;
        stage = (Stage) newUserButton.getScene().getWindow();
        stage.close();
        Stage stage2;

//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gui/TenantLnadlordPopup.fxml"));
//        root = fxmlLoader.load();
//
//        //create a new scene with root and set the stage
//        Scene scene = new Scene(root);
//        stage2.setScene(scene);
//        stage.show();
    }

    public void handleButtonActionTryAgain() {

        handler.hadleButtonActionClose(tryAgainButton);
    }

    public void handleButtonActionOkButton() {

        handler.hadleButtonActionClose(OkButton);
    }

    public void handleButtonActionOkNoMatchButton() {

        handler.hadleButtonActionClose(OkNoMatchButton);
    }
}
