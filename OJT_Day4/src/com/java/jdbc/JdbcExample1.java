package com.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * <h2>JdbcExample1 Class</h2>
 * <p>
 * Process for Displaying JdbcExample1
 * </p>
 * 
 * @author User
 *
 */
public class JdbcExample1 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/first_test", "root",
                    "MyRootPass2022");
            Statement s = con.createStatement();
            // Create a statement / create table
            String sql1 = "CREATE TABLE STUDENT(STUDENTID VARCHAR(10) PRIMARY KEY,NAME VARCHAR(45),DEPARTMENT VARCHAR(45))";

            // Process a query
            // Insert records in the table
            String sql2 = "INSERT INTO STUDENT VALUES('S101','JEAN','CSE')";
            String sql3 = "INSERT INTO STUDENT VALUES('S102','ANA','CSE')";
            String sql4 = "INSERT INTO STUDENT VALUES('S103','ROBERT','ECE')";
            String sql5 = "INSERT INTO STUDENT VALUES('S104','ALEX','IT')";
            String sql6 = "INSERT INTO STUDENT VALUES('S105','DIANA','IT')";

            s.addBatch(sql1);
            s.addBatch(sql2);
            s.addBatch(sql3);
            s.addBatch(sql4);
            s.addBatch(sql5);
            s.addBatch(sql6);

            // Process the results
            // execute the sql statements
            s.executeBatch();
            ResultSet rs = s.executeQuery("Select * from Student");

            // Print commands
            System.out.println("StudentID\tName\t\tDepartment");
            System.out.println("-------------------------------------------------------");

            // Condition to check pointer pointing
            while (rs.next()) {
                System.out.println(rs.getString(1) + "\t\t" + rs.getString(2) + "\t\t" + rs.getString(3));
            }

            // Close the connection
            // con.commit();
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
