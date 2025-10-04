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
public class EstadoCorreccionesComite implements IProjectState{
    
    @Override
    public String getNombreEstado() {
        return "CorreccionesComite";
    }
    
    @Override
    public void manejarAccion(ProyectoDeGrado proyecto, Actions accion) {
        if (accion.getTipo() == EnumTipoAccion.CORREGIR_FORMATO_A && 
            accion.getActor() == EnumRolActor.ESTUDIANTE) {
            proyecto.setState(new EstadoFormatoADiligenciado());
        } else {
            throw new IllegalStateException(
                "Acción no permitida. Solo el ESTUDIANTE puede CORREGIR_FORMATO_A desde CorreccionesComite"
            );
        }
    }
    
}
