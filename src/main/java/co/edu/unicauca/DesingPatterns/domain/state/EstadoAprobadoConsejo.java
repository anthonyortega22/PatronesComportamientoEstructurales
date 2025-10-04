package co.edu.unicauca.DesingPatterns.domain.state;

import co.edu.unicauca.DesingPatterns.domain.entities.Actions;
import co.edu.unicauca.DesingPatterns.domain.entities.EnumRolActor;
import co.edu.unicauca.DesingPatterns.domain.entities.EnumTipoAccion;
import co.edu.unicauca.DesingPatterns.domain.entities.IProjectState;
import co.edu.unicauca.DesingPatterns.domain.entities.ProyectoDeGrado;


public class EstadoAprobadoConsejo implements IProjectState{
    
    @Override
    public String getNombreEstado() {
        return "AprobadoConsejo";
    }
    
    @Override
    public void manejarAccion(ProyectoDeGrado proyecto, Actions accion) {
        if (accion.getTipo() == EnumTipoAccion.EMITIR_RESOLUCION && 
            accion.getActor() == EnumRolActor.CONSEJO_FACULTAD) {
            proyecto.setState(new EstadoResolucionAprobado());
        } else {
            throw new IllegalStateException(
                "Acción no permitida. Solo el CONSEJO_FACULTAD puede EMITIR_RESOLUCION desde AprobadoConsejo"
            );
        }
    }
    
}
