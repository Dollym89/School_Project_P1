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
public class ControllerSelectionTenant {

    public ControllerSelectionTenant() {

    }

    public static final String DIRECTION_NOMATCH_POPUP = "warningGui/NoMatch.fxml";
    HandleButtonAction handler = new HandleButtonAction();

    public static boolean[] newTenantChoice = {true, true, true, true, true, true};


    public Button newSelection;


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
            newTenantChoice[0] = true;
        } else newTenantChoice[0] = false;
    }

    public void isSelectedSmoker() {
        if (smoker.isSelected()) {
            newTenantChoice[1] = true;
        } else newTenantChoice[1] = false;
    }

    public void isSelectedPet() {
        if (pet.isSelected()) {
            newTenantChoice[2] = true;
        } else newTenantChoice[2] = false;
    }

    public void isSelectedWorkStatus() {
        if (workStatus.isSelected()) {
            newTenantChoice[3] = true;
        } else newTenantChoice[3] = false;
    }

    public void isSelectedMaritalStatus() {
        if (maritalStatus.isSelected()) {
            newTenantChoice[4] = true;
        } else newTenantChoice[4] = false;
    }

    public void isSelectedStudent() {
        if (student.isSelected()) {
            newTenantChoice[5] = true;
        } else newTenantChoice[5] = false;
    }

    public void showListOfTenants() throws IOException {

        sliderValue = (int) slider.getValue();


        ObjectTenant tenant;
        tenant = ControllerLogIn.tenantHashMap.get(ControllerLogIn.user);

        ArrayList<ObjectLandlord> list = DAOUser.getMatchForTenant(tenant);

        ArrayList<String> listOfTenantName = new ArrayList<>();


        for (ObjectLandlord landlord : list) {
            listOfTenantName.add(landlord.getUserName());
        }
        System.out.println(list.size());

        ObservableList<String> names = FXCollections.observableArrayList(listOfTenantName);
        listView.setItems(names);
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

    }
}










