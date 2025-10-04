package co.edu.unicauca.DesingPatterns.domain.state;

import co.edu.unicauca.DesingPatterns.domain.entities.Actions;
import co.edu.unicauca.DesingPatterns.domain.entities.EnumRolActor;
import co.edu.unicauca.DesingPatterns.domain.entities.EnumTipoAccion;
import co.edu.unicauca.DesingPatterns.domain.entities.IProjectState;
import co.edu.unicauca.DesingPatterns.domain.entities.ProyectoDeGrado;

public class EstadoEvaluadorPideCorrecciones implements IProjectState {
    
    @Override
    public String getNombreEstado() {
        return "EvaluadorPideCorrecciones";
    }
    
    @Override
    public void manejarAccion(ProyectoDeGrado proyecto, Actions accion) {
        if (accion.getTipo() == EnumTipoAccion.PRESENTAR_ANTEPROYECTO && 
            accion.getActor() == EnumRolActor.TUTOR) {
            // Vuelve a evaluación después de corregir
            proyecto.setState(new EstadoEvaluacionDepartamento());
        } else {
            throw new IllegalStateException(
                "Acción no permitida. Solo el TUTOR puede PRESENTAR_ANTEPROYECTO (con correcciones) desde EvaluadorPideCorrecciones"
            );
        }
    }
    
}
