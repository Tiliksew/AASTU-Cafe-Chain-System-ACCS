package Helpers;

import java.sql.*;
import java.util.Arrays;

public class Database {
    private static final int CUSTOMER_SIZE = 6;
    private static final int FOOD_SIZE = 6;

    /*
    public static void main(String[] args) throws SQLException {
        Connection c = getConnection();
        ResultSet r = getItemsFromTable("foods");
        int x = searchItem("customers","username","yabeye");
        System.out.println("Does Abdi exist ? " + x);
        //String[] ddf =  getItem("foods","foodName","Firfer",FOOD_SIZE);
        //System.out.println("Foods " + Arrays.toString(ddf));
        System.out.println("Is valid user " +  checkLogInAttempt("teleke","123abc"));
        while (r.next()){
            System.out.println(r.getString(2));
        }
        setCustomer(new String[]{"4","Arrayof","stringof","dsgf","f","tyuty"});
    }
    */
    static Connection getConnection(){
        try {
            final String DB_NAME = "jdbc:mysql://localhost:3306/ACCS";
            final String USERNAME = "root";
            final String PASSWORD = "welcome123";

            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(DB_NAME, USERNAME,PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(" "+e);
            // Proper error message displayed on the console //
            return null;
        }
    }
    static ResultSet getItemsFromTable(String tableName) throws SQLException {
        String query = "SELECT * FROM "+ tableName;
        Connection conn = getConnection();
        if(conn==null) throw new NullPointerException();
        Statement stat = conn.createStatement();
        return stat.executeQuery(query);
    }


    public static int searchItem(String tableName, String colName, String itemName ) throws SQLException {
        /* searchCustomer method finds a customer by
            1. get the result set of the mysql query where username is username(parameter)
            2. check the result set and if result is -1 then it is not found else it is found
        */

        String query = "SELECT * FROM " + tableName + " WHERE " + colName + "='"+itemName+"'";
        Connection conn = getConnection();
        if(conn==null) throw new NullPointerException();
        Statement stat = conn.createStatement();
        ResultSet resultSet = stat.executeQuery(query);
        return (resultSet.next())? Integer.parseInt(resultSet.getString(1)) :-1;

    }

    public static String[] getItem(String tableName, String colName, String itemName, int size) throws SQLException {
        String query = "SELECT * FROM " + tableName + " WHERE "  + colName + " = '" + itemName+"'";
        String[] itemInfo = new String[size];

        Connection conn = getConnection();
        if(conn==null) throw new NullPointerException();
        Statement stat = conn.createStatement();
        ResultSet resultSet = stat.executeQuery(query);

        while (resultSet.next()){
            for(int i=0;i<size;i++){
                itemInfo[i] =  resultSet.getString((i+1));
            }
        }

        return itemInfo;
    }

    public static boolean checkLogInAttempt(String username, String password) throws SQLException {
        String tableName = "customers";
        String colName = "username";
        if (searchItem(tableName,colName,username)!=-1){
            String[] userInfo = getItem(tableName,colName,username, CUSTOMER_SIZE ); // String tableName ,String colName,String itemName+
            System.out.println("" + userInfo[2] +username +userInfo[3] + password);
            return (userInfo[2].equals(username) && userInfo[3].equals(password) );
        }
        return false;
    }

    public static boolean setCustomer(String[] userInfo)  {
        try {
            Connection connection = getConnection();
            if (connection == null) throw new NullPointerException();
            String query = "INSERT INTO customers VALUES (?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, Integer.parseInt(userInfo[0]));
            for (int i = 2; i <= userInfo.length; i++) {   // HERE THE DB MUST BE CONFIGURED TO OUR DB MODEL // NUMBER < 10 ?? :(
                statement.setString(i, userInfo[i - 1]);
            }
            statement.execute();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    //  select MAX(id) from customers;
    public static int getCustomerSize(){
        try {
            Connection connection = getConnection();
            if (connection == null) throw new NullPointerException();
            String query = "SELECT MAX(id) FROM customers";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery(query);
            int size = -1;
            while (rs.next()){
                size = rs.getInt(1) + 1;
            }

            return size;
        }catch (SQLException e){
            return -1;
        }
    }
    // select username from customers where username="yabeye"; //
    static boolean checkItemValueReplication(String itemValue )  {
        try {
            Connection connection = getConnection();
            if (connection == null) throw new NullPointerException();
            String query = "SELECT username FROM customers where username='"+ itemValue  +"'";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery(query);
            return !rs.next();
        }catch (SQLException e){
            return true;
        }
    }
}
