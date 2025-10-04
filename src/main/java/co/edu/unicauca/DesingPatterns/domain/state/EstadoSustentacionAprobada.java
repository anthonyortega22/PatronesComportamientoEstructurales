package co.edu.unicauca.DesingPatterns.domain.state;

import co.edu.unicauca.DesingPatterns.domain.entities.Actions;
import co.edu.unicauca.DesingPatterns.domain.entities.IProjectState;
import co.edu.unicauca.DesingPatterns.domain.entities.ProyectoDeGrado;


public class EstadoSustentacionAprobada implements IProjectState{
    
    @Override
    public String getNombreEstado() {
        return "SustentacionAprobada";
    }
    
    @Override
    public void manejarAccion(ProyectoDeGrado proyecto, Actions accion) {
        //ESTADO FINAL - PROYECTO EXITOSO
        throw new IllegalStateException("🎉 ¡PROYECTO APROBADO! Sustentación exitosa. No se requieren más acciones.");
    }
    
}
