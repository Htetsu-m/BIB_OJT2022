package com.java.jdbc;

import java.sql.*;

/**
 * <h2>MysqlCon Class</h2>
 * <p>
 * Process for Displaying MysqlCon
 * </p>
 * 
 * @author User
 *
 */
public class MysqlCon {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "MyRootPass2022");
            // here test is database name, root is username and password
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from emp");
            while (rs.next())
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
