/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package database.group.project.controller;

import database.group.project.dao.TIMEINDAO;
import database.group.project.dao.dbsmDao;
import database.group.project.model.regFormModel;
import database.group.project.model.timeInModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Xander
 */
public class timeinController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getServletPath();
        switch(action){
            case "/timein/create/form":
                showProductCreateForm(request, response);
                break;
            case "/timein/home":
                authenticateTimeIn(request, response);
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
        TIMEINDAO user = new TIMEINDAO();
        ArrayList<timeInModel> regFormList = user.getTimeInList();
        request.setAttribute("regFormList", regFormList);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/home.jsp");
        rd.forward(request, response);
    }
        
      private void showProductCreateForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = getServletContext().getRequestDispatcher(
                "/TimeIn.jsp");
        rd.forward(request, response);
    }

      private void createUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String firstName = request.getParameter("firstName");
        String middleName = request.getParameter("middleName");
        String lastName = request.getParameter("lastName");
        String department = request.getParameter("department");
        String day = request.getParameter("day");
        String time = request.getParameter("time");

        TIMEINDAO user = new TIMEINDAO();
        timeInModel createUser = new timeInModel(
                username, firstName, middleName, lastName, department, day, time);
        user.createTimeIn(createUser);       
        
        
    request.setAttribute("firstName", firstName);
    request.setAttribute("middleName", middleName);
    request.setAttribute("lastName", lastName);
    request.setAttribute("department", department);
    request.setAttribute("day", day);
    request.setAttribute("time", time);
    
    String message = firstName + " "+ middleName + " "+ lastName +  " timed in.";
    request.setAttribute("message", message);
        
         

     RequestDispatcher rd = getServletContext().getRequestDispatcher(
                "/home.jsp");
        rd.forward(request, response);  
        

    }
      
      
    
    private void authenticateTimeIn(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    String username = request.getParameter("username");   
    String firstName = request.getParameter("firstName");
    String middleName = request.getParameter("middleName");
    String lastName = request.getParameter("lastName");
    String department = request.getParameter("department");
    String day = request.getParameter("day");
    String time = request.getParameter("time");

    // Print received parameters
    System.out.println("Received parameters: " + username + ", " + firstName + ", " + middleName + ", " + lastName + ", " + department + ", " + day + ", " + time);

    // Initialize DAOs
    dbsmDao regFormDao = new dbsmDao();
    TIMEINDAO timeInDao = new TIMEINDAO();

    // Perform authentication using RegFormDao
    boolean authenticated = regFormDao.timeinAuthenticate(username, firstName, middleName, lastName);
    System.out.println("Authentication result for user " + username + ": " + authenticated);

    if (authenticated) {
        // If authentication is successful, store the time-in details
        System.out.println("Authentication successful for user: " + username);
        timeInModel TimeInDetails = timeInDao.getTimeInDetails(username);

        boolean stored = timeInDao.storageTimeOut(username, firstName, middleName, lastName, department, day, time);
        System.out.println("Storage result for user " + username + ": " + stored);

        if (stored) {
            // Set request attributes
            request.getSession().setAttribute("firstName", firstName);
            request.getSession().setAttribute("middleName", middleName);
            request.getSession().setAttribute("lastName", lastName);
            request.getSession().setAttribute("department", department);
            request.getSession().setAttribute("day", day);
            request.getSession().setAttribute("time", time);
            request.getSession().setAttribute("message", firstName + " " + middleName + " " + lastName + " timed in.");
            request.getSession().setAttribute("TimeInDetails", TimeInDetails);

            // Redirect to home.jsp to implement PRG pattern
            response.sendRedirect(request.getContextPath() + "/home.jsp");
        } else {
            // If storage fails, redirect back to login page with an error message
            
            String message1 = "User " + username + " has already timed in today!";
            request.setAttribute("message1", message1);
            
            request.setAttribute("errorMessage", "Failed to store time-in details");
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/TimeIn.jsp");
            rd.forward(request, response);
        }
    } else {
        // If authentication fails, redirect back to login page with an error message

        request.setAttribute("errorMessage", "User not in database");
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/TimeIn.jsp");
        rd.forward(request, response);

    }
}


      
      
}
