/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package database.group.project.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import database.group.project.dao.dbsmDao;  
import database.group.project.dao.TIMEINDAO;
import database.group.project.dao.TIMEOUTDAO;
import database.group.project.model.regFormModel;
/**
 *
 * @author Xander
 */
public class main extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getServletPath();
        switch(action){
            case "/regform/create/form":
                showProductCreateForm(request, response);
                break;
            case "/regform/create":
                createUser(request, response);
                break;
            case "/homepage":
            authenticateUser(request, response);
            break;
            default:
                viewProduct(request, response);
                break;
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    } 
    
    private void viewProduct(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        dbsmDao user = new dbsmDao();
        ArrayList<regFormModel> regFormList = user.getUserList();
        request.setAttribute("regFormList", regFormList);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/home.jsp");
        rd.forward(request, response);
    }
        
    
  private void showProductCreateForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = getServletContext().getRequestDispatcher(
                "/regForm.jsp");
        rd.forward(request, response);
    }
  
private void createUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String firstName = request.getParameter("firstName");
        String middleName = request.getParameter("middleName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String contactNumber = request.getParameter("contactNumber");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        dbsmDao user = new dbsmDao();
        regFormModel createUser = new regFormModel(
                username, firstName, middleName, lastName, email, contactNumber, password, confirmPassword);
        user.createUser(createUser);       
        
        
    request.setAttribute("username", username);
    String message = "User " + username + " has been created.";
    request.setAttribute("message", message);
         

     RequestDispatcher rd = getServletContext().getRequestDispatcher(
                "/login");
        rd.forward(request, response);  
        

    }

private void authenticateUser(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    // Perform authentication
    dbsmDao userDao = new dbsmDao();
    boolean authenticated = userDao.authenticate(username, password);

    if (authenticated) {
        // If authentication is successful, redirect to a secure page
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/home");
        rd.forward(request, response);
    } else {
        // If authentication fails, redirect back to login page with an error message
        String errorMessage = "Invalid username or password";
        request.setAttribute("errorMessage", errorMessage);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
        rd.forward(request, response);
    }
    
    
    
}
    
//private void authenticateTimeIn(HttpServletRequest request, HttpServletResponse response)
//        throws ServletException, IOException {
//    String username = request.getParameter("username");   
//    String firstName = request.getParameter("firstName");
//    String middleName = request.getParameter("middleName");
//    String lastName = request.getParameter("lastName");
//    String department = request.getParameter("department");
//    String day = request.getParameter("day");
//    String time = request.getParameter("time");
//
//    // Initialize DAOs
//    dbsmDao regFormDao = new dbsmDao();
//    TIMEINDAO timeInDao = new TIMEINDAO();
//
//    // Perform authentication using RegFormDao
//    boolean authenticated = regFormDao.timeinAuthenticate(username, firstName, middleName, lastName);
//
//    if (authenticated) {
//        // If authentication is successful, store the time-in details
//        boolean stored = timeInDao.storageTimeOut(username, firstName, middleName, lastName, department, day, time);
//
//        if (stored) {
//            // If storage is successful, redirect to a secure page
//            RequestDispatcher rd = getServletContext().getRequestDispatcher("/home");
//            rd.forward(request, response);
//        } else {
//            // If storage fails, redirect back to login page with an error message
//            String errorMessage = "Failed to store time-in details";
//            request.setAttribute("errorMessage", errorMessage);
//            RequestDispatcher rd = getServletContext().getRequestDispatcher("/TimeIn.jsp");
//            rd.forward(request, response);
//        }
//    } else {
//        // If authentication fails, redirect back to login page with an error message
//        String errorMessage = "User not in database";
//        request.setAttribute("errorMessage", errorMessage);
//        RequestDispatcher rd = getServletContext().getRequestDispatcher("/TimeIn.jsp");
//        rd.forward(request, response);
//    }
//    
//}
//
//private void authenticateTimeOut(HttpServletRequest request, HttpServletResponse response)
//        throws ServletException, IOException {
//    String username = request.getParameter("username");   
//    String firstName = request.getParameter("firstName");
//    String middleName = request.getParameter("middleName");
//    String lastName = request.getParameter("lastName");
//    String department = request.getParameter("department");
//    String day = request.getParameter("day");
//    String time = request.getParameter("time");
//
//    // Initialize DAOs
//    dbsmDao regFormDao = new dbsmDao();
//    TIMEOUTDAO timeOutDao = new TIMEOUTDAO();
//
//    // Perform authentication using RegFormDao
//    boolean authenticated = regFormDao.timeinAuthenticate(username, firstName, middleName, lastName);
//
//    if (authenticated) {
//        // If authentication is successful, store the time-in details
//        boolean stored = timeOutDao.storageTimeOut(username, firstName, middleName, lastName, department, day, time);
//
//        if (stored) {
//            // If storage is successful, redirect to a secure page
//            RequestDispatcher rd = getServletContext().getRequestDispatcher("/home");
//            rd.forward(request, response);
//        } else {
//            // If storage fails, redirect back to login page with an error message
//            String errorMessage = "Failed to store time-in details";
//            request.setAttribute("errorMessage", errorMessage);
//            RequestDispatcher rd = getServletContext().getRequestDispatcher("/TimeOut.jsp");
//            rd.forward(request, response);
//        }
//    } else {
//        // If authentication fails, redirect back to login page with an error message
//        String errorMessage = "User not in database";
//        request.setAttribute("errorMessage", errorMessage);
//        RequestDispatcher rd = getServletContext().getRequestDispatcher("/TimeOut.jsp");
//        rd.forward(request, response);
//    }
//    
//}

}




