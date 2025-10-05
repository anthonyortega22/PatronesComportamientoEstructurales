/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.DesingPatterns.domain.adapter;

/**
 *
 * @author User
 */
public class ExternalService {

    public String getCompanyData() {
        // Ejemplo realista: podría venir más información, aquí devolvemos al menos el nombre
        return "{\"name\":\"Empaques del Cauca\"}";
    }
}