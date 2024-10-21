/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database.group.project.dao;

import database.group.project.model.timeOutModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Xander
 */
public class TIMEOUTDAO {

    public boolean storageTimeOut(String username, String firstName, String middleName, String lastName,
            String department, String day, String time) {
        boolean success = false;
        String query = "INSERT INTO timeout (username, firstName, middleName, lastName, department, day, time) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionPool.getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {

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

    public ArrayList<timeOutModel> getTimeOutList() {
        ArrayList<timeOutModel> TimeOutList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "select * from timeout";
        try {
            conn = ConnectionPool.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                timeOutModel user = new timeOutModel();

                user.setUsername(rs.getString("username"));
                user.setFirstName(rs.getString("firstName"));
                user.setMiddleName(rs.getString("middleName"));
                user.setLastName(rs.getString("lastName"));
                user.setDepartment(rs.getString("department"));
                user.setDay(rs.getString("day"));
                user.setTime(rs.getString("time"));
                TimeOutList.add(user);
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

        return TimeOutList;
    }

    public timeOutModel getTimeOutDetails(String username) {
        timeOutModel TimeOutDetails = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = ""
                + "select username, "
                + "firstName, "
                + "middleName, "
                + "lastName, "
                + "department, "
                + "day, "
                + "time "
                + "from timeout "
                + "where username = ? ";
        try {
            conn = ConnectionPool.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()) {
                username = rs.getString("username");
                String firstName = rs.getString("firstName");
                String middleName = rs.getString("middleName");
                String lastName = rs.getString("lastName");
                String department = rs.getString("department");
                String day = rs.getString("day");
                String time = rs.getString("time");
                TimeOutDetails = new timeOutModel(username, firstName, middleName, lastName, department, day, time);
            }
        } catch (SQLException e) {
            System.out.println("getProductDetails Error: " + e);
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
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    //ignore
                }
            }

        }
        return TimeOutDetails;
    }

    public boolean createTimeOut(timeOutModel user) {
        boolean success = false;
        Connection conn = null;
        PreparedStatement ps = null;
        String query = "insert into timeout ("
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
