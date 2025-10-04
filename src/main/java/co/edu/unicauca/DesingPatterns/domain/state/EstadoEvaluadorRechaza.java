package co.edu.unicauca.DesingPatterns.domain.state;

import co.edu.unicauca.DesingPatterns.domain.entities.Actions;
import co.edu.unicauca.DesingPatterns.domain.entities.IProjectState;
import co.edu.unicauca.DesingPatterns.domain.entities.ProyectoDeGrado;

public class EstadoEvaluadorRechaza implements IProjectState{
    
    @Override
    public String getNombreEstado() {
        return "EvaluadorRechaza";
    }
    
    @Override
    public void manejarAccion(ProyectoDeGrado proyecto, Actions accion) {
        // Estado final - no permite más transiciones
        throw new IllegalStateException("Anteproyecto RECHAZADO por el departamento. No se permiten más acciones.");
    }
}
