/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.elon.lib;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Jacob_Wells
 */
public class Book implements Serializable{
    private String firstName;
    private String lastName;
    private String email;
    private String title;
    private String dueDate;
    
    public Book() {
        firstName = "";
        lastName = "";
        email = "";
        title = "";
        dueDate = "";
    }
    public Book(String firstName, String lastName, String email, String title, java.sql.Date sqlDate){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.title = title;
        
        Date date = new Date(sqlDate.getTime());
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        this.dueDate = sdf.format(date);
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getEmail(){
        return email;
    }
    public String getTitle(){
        return title;
    }
    public String getDueDate(){
        return dueDate;
    }
    
    
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setDueDate(String dueDate){
        this.dueDate = dueDate;
    }
}
