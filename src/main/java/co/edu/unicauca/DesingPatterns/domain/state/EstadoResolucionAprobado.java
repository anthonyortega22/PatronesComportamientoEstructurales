package co.edu.unicauca.DesingPatterns.domain.state;

import co.edu.unicauca.DesingPatterns.domain.entities.Actions;
import co.edu.unicauca.DesingPatterns.domain.entities.EnumRolActor;
import co.edu.unicauca.DesingPatterns.domain.entities.EnumTipoAccion;
import co.edu.unicauca.DesingPatterns.domain.entities.IProjectState;
import co.edu.unicauca.DesingPatterns.domain.entities.ProyectoDeGrado;

public class EstadoResolucionAprobado implements IProjectState{
    
    @Override
    public String getNombreEstado() {
        return "ResolucionAprobado";
    }
    
    @Override
    public void manejarAccion(ProyectoDeGrado proyecto, Actions accion) {
        if (accion.getTipo() == EnumTipoAccion.INICIAR_DESARROLLO && 
            accion.getActor() == EnumRolActor.ESTUDIANTE) {
            proyecto.setState(new EstadoEnDesarrollo());
        } else {
            throw new IllegalStateException(
                "Acción no permitida. Solo el ESTUDIANTE puede INICIAR_DESARROLLO desde ResolucionAprobado"
            );
        }
    }
    
}
