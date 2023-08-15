/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author Jasper
 */
public class Vaccine implements Serializable {
    String vaccineName;
    LocalDate vaccinationDate;
    
    public Vaccine(String vaccineName, LocalDate vaccinationDate) {
        this.vaccineName = vaccineName;
        this.vaccinationDate = vaccinationDate;
    }
}
