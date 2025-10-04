package co.edu.unicauca.DesingPatterns.domain.state;

import co.edu.unicauca.DesingPatterns.domain.entities.Actions;
import co.edu.unicauca.DesingPatterns.domain.entities.EnumRolActor;
import co.edu.unicauca.DesingPatterns.domain.entities.EnumTipoAccion;
import co.edu.unicauca.DesingPatterns.domain.entities.IProjectState;
import co.edu.unicauca.DesingPatterns.domain.entities.ProyectoDeGrado;

public class EstadoEvaluadorAcepta implements IProjectState{
    
    @Override
    public String getNombreEstado() {
        return "EvaluadorAcepta";
    }
    
    @Override
    public void manejarAccion(ProyectoDeGrado proyecto, Actions accion) {
        if (accion.getTipo() == EnumTipoAccion.APROBAR_CONSEJO && 
            accion.getActor() == EnumRolActor.CONSEJO_FACULTAD) {
            proyecto.setState(new EstadoAprobadoConsejo());
        } else {
            throw new IllegalStateException(
                "Acción no permitida. Solo el CONSEJO_FACULTAD puede APROBAR_CONSEJO desde EvaluadorAcepta"
            );
        }
    }
    
}
