package co.edu.unicauca.DesingPatterns.domain.state;

import co.edu.unicauca.DesingPatterns.domain.entities.Actions;
import co.edu.unicauca.DesingPatterns.domain.entities.EnumRolActor;
import co.edu.unicauca.DesingPatterns.domain.entities.IProjectState;
import co.edu.unicauca.DesingPatterns.domain.entities.ProyectoDeGrado;


public class EstadoEnEvaluacionComite implements IProjectState{
    
    @Override
    public String getNombreEstado() {
        return "EnEvaluacionComite";
    }
    
    @Override
    public void manejarAccion(ProyectoDeGrado proyecto, Actions accion) {
        if (accion.getActor() == EnumRolActor.MIEMBRO_COMITE) {
            switch (accion.getTipo()) {
                case APROBAR_COMITE:
                    proyecto.setState(new EstadoAceptadoPorComite());
                    break;
                case RECHAZAR_COMITE:
                    proyecto.setState(new EstadoRechazadoPorComite());
                    break;
                case SOLICITAR_CORRECCIONES_COMITE:
                    proyecto.setState(new EstadoCorreccionesComite());
                    break;
                default:
                    throw new IllegalStateException(
                        "Acción no permitida. El COMITE solo puede: APROBAR_COMITE, RECHAZAR_COMITE o SOLICITAR_CORRECCIONES_COMITE"
                    );
            }
        } else {
            throw new IllegalStateException("Solo el MIEMBRO_COMITE puede evaluar en este estado");
        }
    }
    
}
