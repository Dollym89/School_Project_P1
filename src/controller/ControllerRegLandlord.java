package controller;

import model.DAOUser;
import model.ObjectLandlord;
import handler.HandleButtonAction;
import javafx.scene.control.*;
import java.io.IOException;

/**
 * Created by Michal on 14/11/2015.
 */
public class ControllerRegLandlord {
    public static final String DIRECTION_LOGIN = "/gui/LogIn.fxml";
    public static final String DIRECTION_POPUP = "/warningGui/RegistrationWarningPopUp.fxml";
    public static final String DIRECTION_TENANT_LANDLORD = "/gui/TenantLnadlordPopup.fxml";

    public Label invisibleLabel;

    public Button saveButtonLandlord;
    public Button backButton; //TODO create back button to retutn back to tenant landlord option

    public TextField txtFieldUserName;

    public PasswordField passFieldLandlordPassWord;

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

    public void saveLandlordToDatabase() throws IOException {
//if tenant is selected create ObjectTenant and fill all the properties

        int count = 0;
        ObjectLandlord landlord = new ObjectLandlord();


        if (txtFieldUserName.getText().toCharArray().length > 0 && passFieldLandlordPassWord.getText().toCharArray().length > 0) {
            landlord.setUserName(txtFieldUserName.getText()); //username
            landlord.setPassword(passFieldLandlordPassWord.getText());//password
            count++;
        }
        if (maleRadioButton.isSelected() || femaleRadioButton.isSelected()) {
            if (maleRadioButton.isSelected()) landlord.setGender("M");//gender male
            if (femaleRadioButton.isSelected()) landlord.setGender("F"); //gender female
            count++;
        }

        if (smokerRadioButton.isSelected() || nonsmokerRadioButton.isSelected()) {
            if (smokerRadioButton.isSelected()) landlord.setSmoker("Y");//gender female
            if (nonsmokerRadioButton.isSelected()) landlord.setSmoker("N"); // smoker N
            count++;
        }

        if (petNoRadioButton.isSelected() || petYesRadioButton.isSelected()) {
            if (petYesRadioButton.isSelected()) landlord.setPet("Y"); // pet Y
            if (petNoRadioButton.isSelected()) landlord.setPet("N"); // pet N
            count++;
        }

        if (empoyedRadioButton.isSelected() || unemployedRadioButton.isSelected()) {
            if (empoyedRadioButton.isSelected()) landlord.setWorkStatus("EMPLOYED"); // work status EMPLOYED
            if (unemployedRadioButton.isSelected()) landlord.setWorkStatus("UNEMPLOYED"); // work status UNEMPLOYED
            count++;
        }

        if (singleRadioButton.isSelected() || coupleRadioButton.isSelected()) {
            if (singleRadioButton.isSelected()) landlord.setMaritalStatus("SINGLE"); //maritalstatus SINGLE
            if (coupleRadioButton.isSelected()) landlord.setMaritalStatus("COUPLE"); // maritalstatus COUPLE
            count++;
        }
        landlord.setStatus("landlord"); // status tenant

        if (studentNoRadioButton.isSelected() || studentYesRadioButton.isSelected()) {
            if (studentYesRadioButton.isSelected()) landlord.setStudentAceptation("Y"); // are_Ustudent Y
            if (studentNoRadioButton.isSelected()) landlord.setStudentAceptation("N"); // are_Ustudent N
            count++;
        }
        if (count < 7) {
            handler.handleButtonActionWarning(DIRECTION_POPUP);
            System.out.println(count);
        } else {


            // new landlord is inserted to model
            DAOUser daoUser = new DAOUser();
            daoUser.insertLandlord(landlord);
            ControllerLogIn.userHashMap.put(landlord.getUserName(),landlord); // add new guy to hashMap

            //after new object is saved and sent to model, close this window and open LogIn.fxml
            handler.handleButtonAction(saveButtonLandlord, DIRECTION_LOGIN);
        }

    }

    public void goBack() throws IOException {

        handler.handleButtonAction(backButton,DIRECTION_TENANT_LANDLORD);
    }
}
