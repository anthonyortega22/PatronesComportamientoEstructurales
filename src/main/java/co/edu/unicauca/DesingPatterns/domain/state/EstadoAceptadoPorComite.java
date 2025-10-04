/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.DesingPatterns.domain.state;

import co.edu.unicauca.DesingPatterns.domain.entities.Actions;
import co.edu.unicauca.DesingPatterns.domain.entities.EnumRolActor;
import co.edu.unicauca.DesingPatterns.domain.entities.EnumTipoAccion;
import co.edu.unicauca.DesingPatterns.domain.entities.IProjectState;
import co.edu.unicauca.DesingPatterns.domain.entities.ProyectoDeGrado;

/**
 *
 * @author Usuario
 */
public class EstadoAceptadoPorComite implements IProjectState {
    
    @Override
    public String getNombreEstado() {
        return "AceptadoPorComite";
    }
    
    @Override
    public void manejarAccion(ProyectoDeGrado proyecto, Actions accion) {
        if (accion.getTipo() == EnumTipoAccion.INICIAR_ANTEPROYECTO && 
            accion.getActor() == EnumRolActor.ESTUDIANTE) {
            proyecto.setState(new EstadoEscribiendoAnteproyecto());
        } else {
            throw new IllegalStateException(
                "Acción no permitida. Solo el ESTUDIANTE puede INICIAR_ANTEPROYECTO desde AceptadoPorComite"
            );
        }
    }
    
}
