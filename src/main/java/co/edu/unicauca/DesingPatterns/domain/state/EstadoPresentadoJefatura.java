package co.edu.unicauca.DesingPatterns.domain.state;

import co.edu.unicauca.DesingPatterns.domain.entities.Actions;
import co.edu.unicauca.DesingPatterns.domain.entities.EnumRolActor;
import co.edu.unicauca.DesingPatterns.domain.entities.EnumTipoAccion;
import co.edu.unicauca.DesingPatterns.domain.entities.IProjectState;
import co.edu.unicauca.DesingPatterns.domain.entities.ProyectoDeGrado;


public class EstadoPresentadoJefatura implements IProjectState{
    
    @Override
    public String getNombreEstado() {
        return "PresentadoJefatura";
    }
    
    @Override
    public void manejarAccion(ProyectoDeGrado proyecto, Actions accion) {
        if (accion.getTipo() == EnumTipoAccion.EVALUAR_DEPARTAMENTO && 
            accion.getActor() == EnumRolActor.JEFE_DEPARTAMENTO) {
            proyecto.setState(new EstadoEvaluacionDepartamento());
        } else {
            throw new IllegalStateException(
                "Acción no permitida. Solo el JEFE_DEPARTAMENTO puede EVALUAR_DEPARTAMENTO desde PresentadoJefatura"
            );
        }
    }
    
}
