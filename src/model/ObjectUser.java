package model;

/**
 * Created by Michal on 05/11/2015.
 */
public class ObjectUser {

    private Integer userID; // autoincremented number
    private String userName; // username
    private String password; // *******
    private String gender; // male female
    private String smoker; // yes no
    private String pet; // yes no
    private String workStatus; // like employed unemployed
    private String maritalStatus; // single couple
    private String status; // like tenant landlord
    private String timeCreated; // only getter needed model creats this


    //TODO add all the datafilds as in model this object will be send to model ....


    public ObjectUser() {

    }

    public ObjectUser(Integer userID, String userName, String password, String gender, String smoker, String pet, String workStatus, String maritalStatus, String status, String timeCreated) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        this.gender = gender;
        this.smoker = smoker;
        this.pet = pet;
        this.workStatus = workStatus;
        this.maritalStatus = maritalStatus;
        this.status = status;
        this.timeCreated = timeCreated;


    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSmoker() {
        return smoker;
    }

    public void setSmoker(String smoker) {
        this.smoker = smoker;
    }

    public String getPet() {
        return pet;
    }

    public void setPet(String pet) {
        this.pet = pet;
    }

    public String getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(String workStatus) {
        this.workStatus = workStatus;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTimeCreated() {
        return timeCreated;
    }


}
