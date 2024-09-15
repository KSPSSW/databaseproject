/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.databaseproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author kissa
 */
public class InsertDatabase {
    public static void main(String[] args) {
        Connection conn = null;
        String url = "jdbc:sqlite:dcoffee.db";
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Connect to SQLite has been establish");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return;
        }

        //INSERT
        String sql = "INSERT INTO category(category_id , category_name) VALUES (?,?);";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, 3); 
            stmt.setString(2, "candy");
            int status = stmt.executeUpdate();
            //ResultSet key = stmt.getGeneratedKeys();
            //key.next();
            //System.out.println("" + key.getInt(1));

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return;
        }

        ///close
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
