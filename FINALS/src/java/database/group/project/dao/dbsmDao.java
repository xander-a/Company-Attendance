/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database.group.project.dao;
import database.group.project.model.regFormModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author Xander
 */

public class dbsmDao {
public ArrayList<regFormModel> getUserList() {
            ArrayList<regFormModel> UserList = new ArrayList<>();  
        Connection conn  = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "select * from regformregistration";
        try {
            conn = ConnectionPool.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                regFormModel user = new regFormModel();
                
                user.setUsername(rs.getString("username"));
                user.setFirstName(rs.getString("firstName"));
                user.setMiddleName(rs.getString("middleName"));
                user.setLastName(rs.getString("lastName"));
                user.setEmail(rs.getString("email"));
                user.setContactNumber(rs.getString("contactNumber"));
                user.setPassword(rs.getString("password"));
                user.setConfirmPassword(rs.getString("confirmPassword"));
                UserList.add(user);
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
        
        return UserList;
    }
   

    public regFormModel getUserDetails(String username) {
        regFormModel UserDetails = null;
        Connection conn  = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = ""
                + "select username, "
                + "firstName, "
                + "middleName, "
                + "lastName, "
                + "email, "
                + "contactNumber, "
                + "password ,"
                + "confirmPassword "
                + "from regformregistration "
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
                String email = rs.getString("email");
                String contactNumber = rs.getString("contactNumber");
                String password = rs.getString("password");
                String confirmPassword = rs.getString("confirmPassword");
                UserDetails = new regFormModel(username, firstName, middleName, lastName, email, contactNumber, password, confirmPassword);
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
        return UserDetails;
    }
    
    public boolean createUser (regFormModel user) {
        boolean success = false;
        Connection conn  = null;
        PreparedStatement ps = null;
        String query = "insert into regformregistration ("
                + "username, "
                + "firstName, "
                + "middleName, "
                + "lastName, "
                + "email, "
                + "contactNumber, "
                + "password, "
                + "confirmPassword )"
                + "values (?,?,?,?,?,?,?,?)";
        try {
            conn = ConnectionPool.getConnection();
            ps = conn.prepareStatement(query);
             
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getFirstName());
            ps.setString(3, user.getMiddleName());
            ps.setString(4, user.getLastName());
            ps.setString(5, user.getEmail());
            ps.setString(6, user.getContactNumber());
            ps.setString(7, user.getPassword());
            ps.setString(8, user.getConfirmPassword());
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
    
    public boolean authenticate(String username, String password) {
        boolean authenticated = false;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = ConnectionPool.getConnection();
            String query = "SELECT * FROM regformregistration WHERE username = ? AND password = ?";
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            
            // If the result set has at least one row, the user is authenticated
            authenticated = rs.next();
        } catch (SQLException e) {
            // Handle any SQL exceptions
            e.printStackTrace();
        } finally {
            // Close resources in reverse order
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        
        return authenticated;
    }
    
    public boolean timeinAuthenticate(String username, String firstName, String middleName, String lastName) {
        boolean authenticated = false;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = ConnectionPool.getConnection();
            String query = "SELECT * FROM regformregistration WHERE username = ? AND firstName = ? AND middleName = ? AND lastName = ?";
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, firstName);
            ps.setString(3, middleName);
            ps.setString(4, lastName);
            rs = ps.executeQuery();
            
            // If the result set has at least one row, the user is authenticated
            authenticated = rs.next();
        } catch (SQLException e) {
            // Handle any SQL exceptions
            e.printStackTrace();
        } finally {
            // Close resources in reverse order
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        
        return authenticated;
    }
    
}
   



