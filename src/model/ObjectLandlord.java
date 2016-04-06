package model;

/**
 * Created by Michal on 12/11/2015.
 */
public class ObjectLandlord extends ObjectUser {

    private String studentAceptation; // yes no

    public ObjectLandlord() {

    }

    public ObjectLandlord(String studentAceptation){
        super();
        this.studentAceptation = studentAceptation;
    }

    public String getStudentAceptation() {
        return studentAceptation;
    }

    public void setStudentAceptation(String studentAceptation) {
        this.studentAceptation = studentAceptation;
    }
}
