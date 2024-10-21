/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database.group.project.model;

/**
 *
 * @author Xander
 */
public class regFormModel {
    private String username;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String contactNumber;
    private String password;
    private String confirmPassword;
    
    public regFormModel(String username, String firstName, String middleName, String lastName, String email, String contactNumber, String password, String confirmPassword){
        this.username = username;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
        this.contactNumber = contactNumber;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public regFormModel() {
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
    
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }     
    
    public String getContactNumber(){
        return contactNumber;
    }
    public void setContactNumber(String contactNumber){
        this.contactNumber = contactNumber;
    }    
    
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }      
    
    public String getConfirmPassword(){
        return confirmPassword;
    }
    public void setConfirmPassword(String confirmPassword){
        this.confirmPassword = confirmPassword;
    }    
}
