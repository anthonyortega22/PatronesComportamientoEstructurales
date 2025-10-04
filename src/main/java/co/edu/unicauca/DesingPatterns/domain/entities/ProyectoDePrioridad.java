/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.DesingPatterns.domain.entities;

/**
 *
 * @author CRISTHIAN TORRES
 */
public class ProyectoDePrioridad extends ProyectoDeGradoDecorator{
    
    public ProyectoDePrioridad(ProyectoDeGrado proyecto) {
        super(proyecto);
    }
    
    
    @Override
    public String getDescripcion() {
        // Extiende el comportamiento añadiendo la etiqueta de prioridad
        return proyecto.getDescripcion() + " [Alta Prioridad]";
    }
    
}
