package handler;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Michal on 12/11/2015.
 */
public class HandleButtonAction {

    public HandleButtonAction() {

    }

    /**
     * @param node  Node is a superclass for all nodes(buttons, labels, textfield  )
     * @param fxmldir FXML directory is a string which tells where to find chosen FXML file
     * @throws IOException
     */
    public void handleButtonAction(Node node, String fxmldir) throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) node.getScene().getWindow();
        //load up OTHER FXML document
        root = FXMLLoader.load(getClass().getResource(fxmldir));
        //create a new scene with root and set the stage
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void handleButtonActionWarning(String fxmldir) throws IOException {
        Parent root;
        //load up OTHER FXML document


        root = FXMLLoader.load(getClass().getResource(fxmldir));

        //create a new scene with root and set the stage
        Stage warning = new Stage();
        Scene scene = new Scene(root);
        warning.setScene(scene);
        warning.initModality(Modality.APPLICATION_MODAL);
        warning.show();
    }

    public void hadleButtonActionClose(Node node){
        Stage stage;
        stage = (Stage) node.getScene().getWindow();
        stage.close();
    }
}
