/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.DesingPatterns.domain.state;

import co.edu.unicauca.DesingPatterns.domain.entities.Actions;
import co.edu.unicauca.DesingPatterns.domain.entities.IProjectState;
import co.edu.unicauca.DesingPatterns.domain.entities.ProyectoDeGrado;

/**
 *
 * @author Usuario
 */
public class EstadoRechazadoPorComite implements IProjectState{
    
    @Override
    public String getNombreEstado() {
        return "RechazadoPorComite";
    }
    
    @Override
    public void manejarAccion(ProyectoDeGrado proyecto, Actions accion) {
        // Estado final - no permite más transiciones
        throw new IllegalStateException("Proyecto RECHAZADO. No se permiten más acciones.");
    }
    
}
