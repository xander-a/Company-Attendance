/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database.group.project.dao;

import database.group.project.model.regFormModel;
import database.group.project.model.timeInModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Xander
 */
public class TIMEINDAO {
    
          public boolean storageTimeOut(String username, String firstName, String middleName, String lastName,
                                String department, String day, String time) {
        boolean success = false;
        String query = "INSERT INTO timein (username, firstName, middleName, lastName, department, day, time) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, username);
            ps.setString(2, firstName);
            ps.setString(3, middleName);
            ps.setString(4, lastName);
            ps.setString(5, department);
            ps.setString(6, day);
            ps.setString(7, time);

            int rowAffected = ps.executeUpdate();
            if (rowAffected != 0) {
                success = true;
            }
        } catch (SQLException e) {
            System.out.println("createTimeIn Error: " + e.getMessage());
            e.printStackTrace();
        }

        return success;
    }

public ArrayList<timeInModel> getTimeInList() {
            ArrayList<timeInModel> TimeInList = new ArrayList<>();  
        Connection conn  = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "select * from timein";
        try {
            conn = ConnectionPool.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                timeInModel user = new timeInModel();
                
                user.setUsername(rs.getString("username"));
                user.setFirstName(rs.getString("firstName"));
                user.setMiddleName(rs.getString("middleName"));
                user.setLastName(rs.getString("lastName"));
                user.setDepartment(rs.getString("department"));
                user.setDay(rs.getString("day"));
                user.setTime(rs.getString("time"));
                TimeInList.add(user);
            }

            conn.close();
        } catch (SQLException e) {
            System.out.println("getProductList Error: " + e); 
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("THERES SOMETHING WRONG");
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    //ignore
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    //ignore
                }
            }
            
        }
        
        return TimeInList;
    }
   

public timeInModel getTimeInDetails(String username) {
    timeInModel TimeInDetails = null;
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String query = "SELECT username, firstName, middleName, lastName, department, day, time " +
                   "FROM timein WHERE username = ?";
    
    try {
        conn = ConnectionPool.getConnection();
        ps = conn.prepareStatement(query);
        ps.setString(1, username);
        rs = ps.executeQuery();
        
        if (rs.next()) {
            String firstName = rs.getString("firstName");
            String middleName = rs.getString("middleName");
            String lastName = rs.getString("lastName");
            String department = rs.getString("department");
            String day = rs.getString("day");
            String time = rs.getString("time");
            
            TimeInDetails = new timeInModel(username, firstName, middleName, lastName, department, day, time);
            
            // Log details retrieved (optional)
            System.out.println("getTimeInDetails retrieved: " + TimeInDetails.toString());
        }
    } catch (SQLException e) {
        System.out.println("getTimeInDetails Error: " + e.getMessage()); 
    } finally {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            System.out.println("Error closing resources: " + e.getMessage());
        }
    }
    
    return TimeInDetails;
}

    
    public boolean createTimeIn (timeInModel user) {
        boolean success = false;
        Connection conn  = null;
        PreparedStatement ps = null;
            String query = "insert into timein ("
                + "username, "
                + "firstName, "
                + "middleName, "
                + "lastName, "
                + "department, "
                + "day, "
                + "time )"
                + "values (?,?,?,?,?,?,?)";
        try {
            conn = ConnectionPool.getConnection();
            ps = conn.prepareStatement(query);
             
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getFirstName());
            ps.setString(3, user.getMiddleName());
            ps.setString(4, user.getLastName());
            ps.setString(5, user.getDepartment());
            ps.setString(6, user.getDay());
            ps.setString(7, user.getTime());
            int rowAffected = ps.executeUpdate();
            if (rowAffected != 0) {
                success = true;
            }
        } catch (SQLException e) {
            System.out.println("createProduct Error: " + e); 
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    //ignore
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    //ignore
                }
            }
            
        }
        return success;
    }
    
    
  
}
    

