package model;


import controller.ControllerSelectionLandlord;
import controller.ControllerSelectionTenant;


import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * Created by Michal on 05/11/2015.
 */
public class DAOUser {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/property";
    static final String USER = "root";
    static final String PASS = "dollym";
    static PreparedStatement prStmt;
    static Connection conn = null;
    static ResultSet rs;
    static HashMap<String, ObjectTenant> tenantHashMap;
    static HashMap<String, ObjectLandlord> landlordHashMap;
    static HashMap<String, ObjectUser> userHashMap;


    /**
     * we need an list of tenants who match the landlords requirements
     * @param objectLandlord properties of landlord enters query logic
     * @return listOfTeants which is displayed in ControllerSelectionTenant
     */

    public static ArrayList<ObjectTenant> getMatchForLandlord(ObjectLandlord objectLandlord) {
        ArrayList<ObjectTenant> listOfTenants = new ArrayList();
        ObjectTenant tenant = null;

        boolean[] landLordChoice;

        landLordChoice = ControllerSelectionLandlord.newLandlordChoice;
        System.out.println(ControllerSelectionLandlord.sliderValue);

        String query = "SELECT * FROM tenant ;";
        String modifiedQuery = "";

        if (landLordChoice[0] || landLordChoice[1] || landLordChoice[2] || landLordChoice[3] || landLordChoice[4] || landLordChoice[5]) {
            query = query.replace(";", "") + " WHERE ";

            if (landLordChoice[0])//if you want to have a match in gender
            {
                query = query + "tenant.gender = ? AND ";
            }
            if (landLordChoice[1])//if you want to have a match in  smoker
            {
                query = query + "tenant.smoker = ? AND ";
            }
            if (landLordChoice[2])//if you want to have a match in pet
            {
                query = query + "tenant.pet = ? AND ";
            }
            if (landLordChoice[3])//if you want to have a match in workStatus
            {
                query = query + "tenant.workStatus = ? AND ";
            }
            if (landLordChoice[4])//if you want to have a match in maritalStatus
            {
                query = query + "tenant.maritalStatus = ? AND ";
            }
            if (landLordChoice[5])//if you want to have a match in student
            {
                query = query + "tenant.student = ? AND ";
            }
        } else query = "SELECT * FROM tenant ";

        //substring without AND + ;
        int lastChar = query.lastIndexOf('A');

        if (lastChar > 0) {
            modifiedQuery = query.substring(0, lastChar) + " LIMIT ?;";

        } else {
            modifiedQuery = " SELECT * FROM tenant LIMIT ? ; ";
        }
        try {

            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            prStmt = conn.prepareStatement(modifiedQuery);
            int count = 1;

//            System.out.println("if is selected or not::: " + landLordChoice[0]);

            if (landLordChoice[0]) {
                prStmt.setString(count, objectLandlord.getGender());
                count++;
            }
            if (landLordChoice[1]) {
                prStmt.setString(count, objectLandlord.getSmoker());
                count++;
            }
            if (landLordChoice[2]) {
                prStmt.setString(count, objectLandlord.getPet());
                count++;
            }
            if (landLordChoice[3]) {
                prStmt.setString(count, objectLandlord.getWorkStatus());
                count++;
            }
            if (landLordChoice[4]) {
                prStmt.setString(count, objectLandlord.getMaritalStatus());
                count++;
            }
            if (landLordChoice[5]) {
                prStmt.setString(count, objectLandlord.getStudentAceptation());
                count++;
            }
            // sets the limit of shown tenants
            prStmt.setInt(count, ControllerSelectionLandlord.sliderValue);
            System.out.println(prStmt.toString());
            rs = prStmt.executeQuery();

            while (rs.next()) {
                tenant = new ObjectTenant();
                tenant.setUserName(rs.getString("userName"));
                System.out.println(tenant.getUserName());
                listOfTenants.add(tenant);
            }
        } catch (SQLException ex) {
            ex.getErrorCode();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (prStmt != null)
                    prStmt.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return listOfTenants;
    }

    /**
     * we need an list of landlords who match the tenants requirements
     * @param objectTenant
     * @return
     */
    public static ArrayList<ObjectLandlord> getMatchForTenant(ObjectTenant objectTenant) {
        ArrayList<ObjectLandlord> listOfLandlord = new ArrayList();
        ObjectLandlord landlord = null;

        boolean[] tenantChoice;

        tenantChoice = ControllerSelectionTenant.newTenantChoice;
        System.out.println(ControllerSelectionTenant.sliderValue);

        String query = "SELECT * FROM landlord ;";
        String modifiedQuery = "";

        if (tenantChoice[0] || tenantChoice[1] || tenantChoice[2] || tenantChoice[3] || tenantChoice[4] || tenantChoice[5]) {
            query = query.replace(";", "") + " WHERE ";

            if (tenantChoice[0])//if you want to have a match in gender
            {
                query = query + "landlord.gender = ? AND ";
            }
            if (tenantChoice[1])//if you want to have a match in  smoker
            {
                query = query + "landlord.smoker = ? AND ";
            }
            if (tenantChoice[2])//if you want to have a match in pet
            {
                query = query + "landlord.pet = ? AND ";
            }
            if (tenantChoice[3])//if you want to have a match in workStatus
            {
                query = query + "landlord.workStatus = ? AND ";
            }
            if (tenantChoice[4])//if you want to have a match in maritalStatus
            {
                query = query + "landlord.maritalStatus = ? AND ";
            }
            if (tenantChoice[5])//if you want to have a match in student
            {
                query = query + "landlord.student = ? AND ";
            }
        } else query = "SELECT * FROM landlord ";

        //substring without AND + ;
        int lastChar = query.lastIndexOf('A');

        if (lastChar > 0) {
            modifiedQuery = query.substring(0, lastChar) + " LIMIT ?;";

        } else {
            modifiedQuery = " SELECT * FROM landlord LIMIT ? ; ";
        }
        try {

            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            prStmt = conn.prepareStatement(modifiedQuery);
            int count = 1;

           System.out.println("if is selected or not::: " + tenantChoice[0]);

            if (tenantChoice[0]) {
                prStmt.setString(count, objectTenant.getGender());
                count++;
            }
            if (tenantChoice[1]) {
                prStmt.setString(count, objectTenant.getSmoker());
                count++;
            }
            if (tenantChoice[2]) {
                prStmt.setString(count, objectTenant.getPet());
                count++;
            }
            if (tenantChoice[3]) {
                prStmt.setString(count, objectTenant.getWorkStatus());
                count++;
            }
            if (tenantChoice[4]) {
                prStmt.setString(count, objectTenant.getMaritalStatus());
                count++;
            }
            if (tenantChoice[5]) {
                prStmt.setString(count, objectTenant.getStudent());
                count++;
            }
            // sets the limit of shown tenants
            prStmt.setInt(count, ControllerSelectionTenant.sliderValue);
            System.out.println(prStmt.toString());
            rs = prStmt.executeQuery();

            while (rs.next()) {
                landlord = new ObjectLandlord();
                landlord.setUserName(rs.getString("userName"));
                System.out.println(landlord.getUserName());
                listOfLandlord.add(landlord);
            }
        } catch (SQLException ex) {
            ex.getErrorCode();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (prStmt != null)
                    prStmt.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return listOfLandlord;
    }

    /**
     * inserts new tenant to database
     * @param userInput is an object of type ObjectTenant (is created when SAVE button is pressed :D)
     * @return true value when object is uploaded to model
     */
    public boolean insertTenant(ObjectTenant userInput) {
        boolean isSuccess = false;

        String query = "INSERT INTO tenant(" +
                "userName," +
                "password," +
                "gender," +
                "smoker," +
                "pet," +
                "workStatus," +
                "maritalStatus," +
                "status," +
                "student" +
                ")VALUES(?,?,?,?,?,?,?,?,?);";
        try {

            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            prStmt = conn.prepareStatement(query);

            prStmt.setString(1, userInput.getUserName());
            prStmt.setString(2, userInput.getPassword());
            prStmt.setString(3, userInput.getGender());
            prStmt.setString(4, userInput.getSmoker());
            prStmt.setString(5, userInput.getPet());
            prStmt.setString(6, userInput.getWorkStatus());
            prStmt.setString(7, userInput.getMaritalStatus());
            prStmt.setString(8, userInput.getStatus());
            prStmt.setString(9, userInput.getStudent());

            prStmt.executeUpdate();
            isSuccess = true;

        } catch (SQLException e) {
            System.out.println("SQLException :" + e.getMessage());
            e.printStackTrace();
            isSuccess = false;

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (prStmt != null)
                    prStmt.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println("USER DAO ERROR ::insertUser" + ex.toString());
            }
        }
        return isSuccess;
    }

    /**
     * inserts new landlord to database
     * @param userInput is an object of type ObjectLandlord (is created when SAVE button is pressed :D)
     * @return true value when object is uploaded to model
     */
    // insert new Landlord to model
    public boolean insertLandlord(ObjectLandlord userInput) {
        boolean isSuccess = false;

        String query = "INSERT INTO landlord(" +
                "userName," +
                "password," +
                "gender," +
                "smoker," +
                "pet," +
                "workStatus," +
                "maritalStatus," +
                "status," +
                "student" +
                ")VALUES(?,?,?,?,?,?,?,?,?);";
        try {

            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            prStmt = conn.prepareStatement(query);

            prStmt.setString(1, userInput.getUserName());
            prStmt.setString(2, userInput.getPassword());
            prStmt.setString(3, userInput.getGender());
            prStmt.setString(4, userInput.getSmoker());
            prStmt.setString(5, userInput.getPet());
            prStmt.setString(6, userInput.getWorkStatus());
            prStmt.setString(7, userInput.getMaritalStatus());
            prStmt.setString(8, userInput.getStatus());
            prStmt.setString(9, userInput.getStudentAceptation());

            prStmt.executeUpdate();
            isSuccess = true;

        } catch (SQLException e) {
            System.out.println("SQLException :" + e.getMessage());
            e.printStackTrace();
            isSuccess = false;

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (prStmt != null)
                    prStmt.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println("USER DAO ERROR ::insertUser" + ex.toString());
            }
        }
        return isSuccess;
    }

    /**
     *  return hashMap where Key is UserName and Value ObjectTenant
     * @return hasmap with all the tenants
     */
    //method which returns Tenant user from model
    public HashMap<String, ObjectTenant> getTenantHashMap() {
        ObjectTenant objectTenant;
        String query = "SELECT*FROM tenant";

        tenantHashMap = new HashMap(); // have to initialize new hash map before you start to fill new objects inside;

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            prStmt = conn.prepareStatement(query);
            rs = prStmt.executeQuery(query);


            while (rs.next()) {
                objectTenant = new ObjectTenant();

                objectTenant.setUserName(rs.getString("userName"));
                objectTenant.setPassword(rs.getString("password"));
                objectTenant.setGender(rs.getString("gender"));
                objectTenant.setSmoker(rs.getString("smoker"));
                objectTenant.setPet(rs.getString("pet"));
                objectTenant.setWorkStatus(rs.getString("workStatus"));
                objectTenant.setMaritalStatus(rs.getString("maritalStatus"));
                objectTenant.setStatus(rs.getString("status"));
                objectTenant.setStudent(rs.getString("student"));

                tenantHashMap.put(rs.getString("userName"), objectTenant);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (prStmt != null)
                    prStmt.close();
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.getStackTrace();
            }
        }
        return tenantHashMap;
    }

    /**
     * return hashMap where Key is UserName and Value ObjectLandlord
     * @return hashmap with all landlords
     */

    //method which returns hash map landlord user from model
    public HashMap<String, ObjectLandlord> getLandlordHashMap() {
        ObjectLandlord objectLandlord;
        String query = "SELECT*FROM landlord";
        landlordHashMap = new HashMap();

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            prStmt = conn.prepareStatement(query);
            rs = prStmt.executeQuery(query);

            while (rs.next()) {
                objectLandlord = new ObjectLandlord();
                objectLandlord.setUserName(rs.getString("userName"));
                objectLandlord.setPassword(rs.getString("password"));
                objectLandlord.setGender(rs.getString("gender"));
                objectLandlord.setSmoker(rs.getString("smoker"));
                objectLandlord.setPet(rs.getString("pet"));
                objectLandlord.setWorkStatus(rs.getString("workStatus"));
                objectLandlord.setMaritalStatus(rs.getString("maritalStatus"));
                objectLandlord.setStatus(rs.getString("status"));
                objectLandlord.setStudentAceptation(rs.getString("student"));

                landlordHashMap.put(rs.getString("userName"), objectLandlord);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (prStmt != null)
                    prStmt.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return landlordHashMap;
    }



    //    TODO create methods, change User, delet User
//    public boolean changeUser(ObjectLandlord landlord) {
//        return true;
//    }
//
//    public boolean changeUser(ObjectTenant tenant) {
//        return true;
//    }
//
//    public boolean deleteUser(ObjectTenant tenant) {
//        return true;
//    }
//
//    public boolean deleteUser(ObjectLandlord landlord) {
//        return true;
//    }

    /**
     * return hashMap where Key is UserName and Value ObjectUser
     * @return hash map with all users.
     */
    public HashMap<String, ObjectUser> getUserHashMap() {
        ObjectUser objectUser;

        String query = "SELECT userName, password,status FROM tenant " +
                "UNION " +
                "SELECT userName,password,status FROM landlord;";

        userHashMap = new HashMap();

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            prStmt = conn.prepareStatement(query);
            rs = prStmt.executeQuery(query);

            while (rs.next()) {
                objectUser = new ObjectUser();
                objectUser.setUserName(rs.getString("userName"));
                objectUser.setPassword(rs.getString("password"));
                objectUser.setStatus(rs.getString("status"));

                userHashMap.put(rs.getString("userName"), objectUser);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (prStmt != null)
                    prStmt.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return userHashMap;
    }


}
