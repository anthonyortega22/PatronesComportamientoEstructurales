package co.edu.unicauca.DesingPatterns.domain.state;

import co.edu.unicauca.DesingPatterns.domain.entities.Actions;
import co.edu.unicauca.DesingPatterns.domain.entities.EnumRolActor;
import co.edu.unicauca.DesingPatterns.domain.entities.IProjectState;
import co.edu.unicauca.DesingPatterns.domain.entities.ProyectoDeGrado;

public class EstadoEvaluacionDepartamento implements IProjectState{
    
    @Override
    public String getNombreEstado() {
        return "EvaluacionDepartamento";
    }
    
    @Override
    public void manejarAccion(ProyectoDeGrado proyecto, Actions accion) {
        if (accion.getActor() == EnumRolActor.EVALUADOR_DEPARTAMENTO) {
            switch (accion.getTipo()) {
                case APROBAR_DEPARTAMENTO:
                    proyecto.setState(new EstadoEvaluadorAcepta());
                    break;
                case RECHAZAR_DEPARTAMENTO:
                    proyecto.setState(new EstadoEvaluadorRechaza());
                    break;
                case SOLICITAR_CORRECCIONES_DEPARTAMENTO:
                    proyecto.setState(new EstadoEvaluadorPideCorrecciones());
                    break;
                default:
                    throw new IllegalStateException(
                        "Acción no permitida. El EVALUADOR_DEPARTAMENTO solo puede: APROBAR_DEPARTAMENTO, RECHAZAR_DEPARTAMENTO o SOLICITAR_CORRECCIONES_DEPARTAMENTO"
                    );
            }
        } else {
            throw new IllegalStateException("Solo el EVALUADOR_DEPARTAMENTO puede evaluar en este estado");
        }
    }
    
}
