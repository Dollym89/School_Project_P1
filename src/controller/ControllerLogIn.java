package controller;


import model.DAOUser;
import model.ObjectLandlord;
import model.ObjectTenant;
import model.ObjectUser;
import handler.HandleButtonAction;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
/**
 * Created by Michal on 01/11/2015.
 */

public class ControllerLogIn implements Initializable {

    public static final String DIRECTION_SELECTION_LANDLORD = "/gui/SelectionLandlord.fxml";
    public static final String DIRECTION_SELECTION_TENANT = "/gui/SelectionTenant.fxml";
    public static final String DIRECTION_LOGIN_WARNING_POPUP = "/warningGui/LogInWarningPopUp.fxml";
    public static final String DIRECTION_TENANT_LANDLORD_POPUP = "/gui/TenantLnadlordPopup.fxml";

    public Button buttonReg;
    public Button buttonLogIn;

    public TextField userName;
    public PasswordField passwordField;
    public HandleButtonAction handler = new HandleButtonAction();

    static String user;

    public static HashMap<String, ObjectUser> userHashMap; // is static because we want to reach same data from each class and we do not want to open connection all the time;
    public static HashMap<String, ObjectLandlord> landlordHashMap;
    public static HashMap<String, ObjectTenant> tenantHashMap;

    //loads all users and add them to hash map before anything happens
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        DAOUser daoUser = new DAOUser();
        landlordHashMap = daoUser.getLandlordHashMap();
        tenantHashMap = daoUser.getTenantHashMap();
        userHashMap = daoUser.getUserHashMap();


//        for (String userName : userHashMap.keySet()) {
//            System.out.println(userHashMap.get(userName).getStatus());
//        }

    }

    //    TODO this is only test, create a real funcionality for LogIn button
    public void handleButtonActionLogIn() throws IOException {

        DAOUser daoUser = new DAOUser();
        userHashMap = daoUser.getUserHashMap();
        // use containsKey

        if (userHashMap.get(userName.getText()) == null || passwordField.getText().equals("")) {
            //warning popUp appears
            handler.handleButtonActionWarning(DIRECTION_LOGIN_WARNING_POPUP);
        } else {
            if (passwordField.getText().equals(userHashMap.get(userName.getText()).getPassword())) {

                if (userHashMap.get(userName.getText()).getStatus().equals("tenant")) {
                    System.out.println(userHashMap.get(userName.getText()).getStatus());

                    handler.handleButtonAction(buttonLogIn, DIRECTION_SELECTION_TENANT);

                    user = userName.getText();

                } else {
                    handler.handleButtonAction(buttonLogIn, DIRECTION_SELECTION_LANDLORD);

                    user = userName.getText();
                }
            }
        }
    }
// TODO create fxml, popup "Your pass is wrong " - two buttons

    public void handleButtonActionRegistration() throws IOException {

        handler.handleButtonAction(buttonReg, DIRECTION_TENANT_LANDLORD_POPUP);
    }


}



