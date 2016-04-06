package controller;


import model.DAOUser;
import model.ObjectLandlord;
import model.ObjectTenant;
import handler.HandleButtonAction;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.ArrayList;


/**
 * Created by Michal on 18/11/2015.
 */
public class ControllerSelectionLandlord {

    public ControllerSelectionLandlord() {

    }

    public static final String DIRECTION_NOMATCH_POPUP = "warningGui/NoMatch.fxml";
    HandleButtonAction handler = new HandleButtonAction();

    public static boolean[] newLandlordChoice = {true, true, true, true, true, true};


    public Button newSelection;
    public Label invisibleLabel;



    public CheckBox gender;
    public CheckBox smoker;
    public CheckBox pet;
    public CheckBox workStatus;
    public CheckBox maritalStatus;
    public CheckBox student;

    public Slider slider;

    public ListView<String> listView;

    public static int sliderValue;


    public void isSelectedGender() {
        if (gender.isSelected()) {
            newLandlordChoice[0] = true;
        } else newLandlordChoice[0] = false;
    }

    public void isSelectedSmoker() {
        if (smoker.isSelected()) {
            newLandlordChoice[1] = true;
        } else newLandlordChoice[1] = false;
    }

    public void isSelectedPet() {
        if (pet.isSelected()) {
            newLandlordChoice[2] = true;
        } else newLandlordChoice[2] = false;
    }

    public void isSelectedWorkStatus() {
        if (workStatus.isSelected()) {
            newLandlordChoice[3] = true;
        } else newLandlordChoice[3] = false;
    }

    public void isSelectedMaritalStatus() {
        if (maritalStatus.isSelected()) {
            newLandlordChoice[4] = true;
        } else newLandlordChoice[4] = false;
    }

    public void isSelectedStudent() {
        if (student.isSelected()) {
            newLandlordChoice[5] = true;
        } else newLandlordChoice[5] = false;
    }

    public void showListOfTenants() throws IOException {

        invisibleLabel.setText(ControllerLogIn.user.toString());

        sliderValue = (int) slider.getValue();


        ObjectLandlord landlord;
        landlord = ControllerLogIn.landlordHashMap.get(ControllerLogIn.user);
        ArrayList<ObjectTenant> list = DAOUser.getMatchForLandlord(landlord);
        ArrayList<String> listOfTenantName = new ArrayList<>();

        for (ObjectTenant tenant : list) {
            listOfTenantName.add(tenant.getUserName());
        }
        System.out.println(list.size());

        ObservableList<String> names = FXCollections.observableArrayList(listOfTenantName);
        listView.setItems(names);
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

    }
}










