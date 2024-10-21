/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database.group.project.model;


/**
 *
 * @author Xander
 */
public class timeOutModel {
    private String username;
    private String firstName;
    private String middleName;
    private String lastName;
    private String department;
    private String day;
    private String time;
    
    public timeOutModel(String username, String firstName, String middleName, String lastName, String department, String day, String time){
        this.username = username;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.department = department;
        this.day = day;
        this.time = time;
    }
    
    public timeOutModel() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }
    
    public String getFirstName( ){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }    
    
    public String getMiddleName(){
        return middleName;
    }
    public void setMiddleName(String middleName){
        this.middleName = middleName;
    }    
    
    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }    
    
    public String getDepartment(){
        return department;
    }
    public void setDepartment(String department){
        this.department = department;
    }     
    
    public String getDay(){
        return day;
    }
    public void setDay(String day){
        this.day = day;
    }    
    
    public String getTime(){
        return time;
    }
    public void setTime(String time){
        this.time = time;
    }      
    
}
