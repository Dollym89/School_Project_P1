package model;

/**
 * Created by Michal on 12/11/2015.
 */
public class ObjectTenant extends ObjectUser {

    private String student;


    public ObjectTenant() {
        super();
    }

    public ObjectTenant(String student) {
        super();
        this.student = student;

    }

    public String getStudent() {
        return this.student;
    }

    public void setStudent(String student) {
        this.student = student;
    }


}




