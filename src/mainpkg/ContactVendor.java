/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg;

import java.io.Serializable;

/**
 *
 * @author DELL
 */
public class ContactVendor implements Serializable{
    
    String designation,phone,email;

    public ContactVendor(String designation, String phone, String email) {
        this.designation = designation;
        this.phone = phone;
        this.email = email;
    }

    public String getDesignation() {
        return designation;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
    
    
    
    
}
