package controller;

import model.DAOUser;
import model.ObjectTenant;
import handler.HandleButtonAction;
import javafx.scene.control.*;

import java.io.IOException;

/**
 * Created by Michal on 14/11/2015.
 */
public class ControllerRegTenant {
    public static final String DIRECTION_LOGIN = "/gui/LogIn.fxml";
    public static final String DIRECTION_POPUP = "/warningGui/RegistrationWarningPopUp.fxml";
    public static final String DIRECTION_TENANT_LANDLORD = "/gui/TenantLnadlordPopup.fxml";

    public Label invisibleLabel;

    public Button saveButtonTenant;
    public Button backButton;

    public TextField txtFieldUserName;

    public PasswordField passFieldTenantPassWord;

    public RadioButton maleRadioButton;
    public RadioButton femaleRadioButton;
    public RadioButton smokerRadioButton;
    public RadioButton nonsmokerRadioButton;
    public RadioButton petYesRadioButton;
    public RadioButton petNoRadioButton;
    public RadioButton empoyedRadioButton;
    public RadioButton unemployedRadioButton;
    public RadioButton singleRadioButton;
    public RadioButton coupleRadioButton;
    public RadioButton studentYesRadioButton;
    public RadioButton studentNoRadioButton;

    public HandleButtonAction handler = new HandleButtonAction();

//    public HashMap <String, ObjectUser> userHashMap;



    public void changeLabelColor() {


        if (ControllerLogIn.userHashMap.get(txtFieldUserName.getText()) == null && txtFieldUserName.getText().toCharArray().length > 1) {
            //Use onKeyReleased
            invisibleLabel.setText("OK");
            invisibleLabel.setStyle("-fx-text-fill:#4fdc24 ");
        } else if (ControllerLogIn.userHashMap.get(txtFieldUserName.getText()) == null && txtFieldUserName.getText().toCharArray().length <= 1) {
            invisibleLabel.setStyle("-fx-text-fill: #383838");
        } else {
            invisibleLabel.setStyle("-fx-text-fill:#e1233a ");
            invisibleLabel.setText("Try another");
        }
    }

    //TODO same shit as for landlord with warnings
    public void saveTenantToDatabase() throws IOException {
//if tenant is selected create ObjectTenant and fill all the properties
        ObjectTenant tenant = new ObjectTenant();
        int count = 0;
        if (txtFieldUserName.getText().toCharArray().length > 0 && passFieldTenantPassWord.getText().toCharArray().length > 0) {
            tenant.setUserName(txtFieldUserName.getText()); //username
            tenant.setPassword(passFieldTenantPassWord.getText()); //password
            count++;
        }
        if (maleRadioButton.isSelected() || femaleRadioButton.isSelected()) {
            if (maleRadioButton.isSelected()) tenant.setGender("M");//gender male
            if (femaleRadioButton.isSelected()) tenant.setGender("F"); //gender female
            count++;
        }

        if (smokerRadioButton.isSelected() || nonsmokerRadioButton.isSelected()) {
            if (smokerRadioButton.isSelected()) tenant.setSmoker("Y");//gender female
            if (nonsmokerRadioButton.isSelected()) tenant.setSmoker("N"); // smoker N
            count++;
        }
        if (petNoRadioButton.isSelected() || petYesRadioButton.isSelected()) {
            if (petYesRadioButton.isSelected()) tenant.setPet("Y"); // pet Y
            if (petNoRadioButton.isSelected()) tenant.setPet("N"); // pet N
            count++;
        }
        if (empoyedRadioButton.isSelected() || unemployedRadioButton.isSelected()) {
            if (empoyedRadioButton.isSelected()) tenant.setWorkStatus("EMPLOYED"); // work status EMPLOYED
            if (unemployedRadioButton.isSelected()) tenant.setWorkStatus("UNEMPLOYED"); // work status UNEMPLOYED
            count++;
        }
        if (singleRadioButton.isSelected() || coupleRadioButton.isSelected()) {
            if (singleRadioButton.isSelected()) tenant.setMaritalStatus("SINGLE"); //maritalstatus SINGLE
            if (coupleRadioButton.isSelected()) tenant.setMaritalStatus("COUPLE"); // maritalstatus COUPLE
            count++;
        }
        tenant.setStatus("tenant"); // status tenant

        if (studentNoRadioButton.isSelected() || studentYesRadioButton.isSelected()) {
            if (studentYesRadioButton.isSelected()) tenant.setStudent("Y"); // are_Ustudent Y
            if (studentNoRadioButton.isSelected()) tenant.setStudent("N"); // are_Ustudent N
            count++;
        }
        if (count < 7) {
            handler.handleButtonActionWarning(DIRECTION_POPUP);
            System.out.println(count);
        } else {
            // new landlord is inserted to model
            DAOUser daoUser = new DAOUser();
            daoUser.insertTenant(tenant);
            ControllerLogIn.userHashMap.put(tenant.getUserName(),tenant); // add new guy to hashMap

            //after new object is saved and sent to model, close this window and open LogIn.fxml
            handler.handleButtonAction(saveButtonTenant, DIRECTION_LOGIN);
        }

    }

    public void goBack()throws IOException{

        handler.handleButtonAction(backButton,DIRECTION_TENANT_LANDLORD);
    }
}
