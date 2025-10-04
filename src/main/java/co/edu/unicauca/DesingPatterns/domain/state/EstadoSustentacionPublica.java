package co.edu.unicauca.DesingPatterns.domain.state;

import co.edu.unicauca.DesingPatterns.domain.entities.Actions;
import co.edu.unicauca.DesingPatterns.domain.entities.EnumRolActor;
import co.edu.unicauca.DesingPatterns.domain.entities.IProjectState;
import co.edu.unicauca.DesingPatterns.domain.entities.ProyectoDeGrado;

public class EstadoSustentacionPublica implements IProjectState{
    
    @Override
    public String getNombreEstado() {
        return "SustentacionPublica";
    }
    
    @Override
    public void manejarAccion(ProyectoDeGrado proyecto, Actions accion) {
        if (accion.getActor() == EnumRolActor.JURADO) {
            switch (accion.getTipo()) {
                case APROBAR_SUSTENTACION:
                    proyecto.setState(new EstadoSustentacionAprobada());
                    break;
                case RECHAZAR_SUSTENTACION:
                    proyecto.setState(new EstadoSustentacionRechazada());
                    break;
                default:
                    throw new IllegalStateException(
                        "Acción no permitida. El JURADO solo puede: APROBAR_SUSTENTACION o RECHAZAR_SUSTENTACION"
                    );
            }
        } else {
            throw new IllegalStateException("Solo el JURADO puede evaluar la sustentación");
        }
    }
    
}
