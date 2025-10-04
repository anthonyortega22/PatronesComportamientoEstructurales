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
public class EstadoPresentadoAlCoordinador implements IProjectState {
    
    @Override
    public String getNombreEstado() {
        return "PresentadoAlCoordinador";
    }
    
    @Override
    public void manejarAccion(ProyectoDeGrado proyecto, Actions accion) {
        if (accion.getTipo() == EnumTipoAccion.EVALUAR_COMITE && 
            accion.getActor() == EnumRolActor.COORDINADOR) {
            proyecto.setState(new EstadoEnEvaluacionComite());
        } else {
            throw new IllegalStateException(
                "Acción no permitida. Solo el COORDINADOR puede EVALUAR_COMITE desde PresentadoAlCoordinador"
            );
        }
    }
    
}
