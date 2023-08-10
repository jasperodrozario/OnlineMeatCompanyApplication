/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author Jasper
 */
public abstract class User implements Serializable{
    protected int userId;
    protected String userType, userName, password;
    protected boolean gender;
    
    public abstract void changePassword();
}
