package com.java.jdbc;
import java.io.*;
import java.sql.*;
import java.util.*;

public class JdbcExample {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // TODO Auto-generated method stub
        String url = "jdbc:mysql://localhost:3306/test";
        String uname = "root";
        String pass = "MyRootPass2022";

        // Query from the database taken
        // Custom query taken to illustrate
        String query = "select name from emp where id=2";

        // Loading and registering drivers
        Class.forName("com.mysql.jdbc.Driver");

        // Creating an connection object by
        // getConnection() method which is static method and
        // returns the instance of Connection class

        // This method takes 3 parameters as defined above
        Connection con = DriverManager.getConnection(url, uname, pass);

        Statement st = con.createStatement();

        // It returns a tabular structure so we need
        // ResultSet as it stores chunk of data into
        // structures
        ResultSet rs = st.executeQuery(query);

        // Now we are having our data in object of ResultSet
        // which is no more tabular

        // Note:
        // Fetching the above data by storing it as a String
        // Here pointer is lagging with data for which we
        // use next() method to
        // take it to next record
        rs.next();

        // Here we are fetching name column data
        String n = rs.getString("name");

        // Lastly print the data
        System.out.println(n);

        // It is good practice to close the connection
        // using close() method

        // Closing the statement first
        st.close();

        // Now close the connection also
        con.close();
    }

}
