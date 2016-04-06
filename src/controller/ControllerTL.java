package controller;

import handler.HandleButtonAction;
import javafx.scene.control.RadioButton;


import java.io.IOException;

/**
 * Created by Michal on 12/11/2015.
 */
public class ControllerTL {

    public RadioButton tenant;
    public RadioButton landlord;
    static final String DIRECTION_REGISTERLANDLORD = "/gui/RegisterLandlord.fxml";
    static final String DIRECTION_REGISTERTENANT = "/gui/RegisterTenant.fxml";

    public HandleButtonAction handler = new HandleButtonAction();




    public void handleButtonActionLandlord() throws IOException {

        handler.handleButtonAction(landlord, DIRECTION_REGISTERLANDLORD);
    }

    //handle button action tenant
    public void handleButtonActionTenant() throws IOException {

        handler.handleButtonAction(tenant, DIRECTION_REGISTERTENANT);

    }
}
