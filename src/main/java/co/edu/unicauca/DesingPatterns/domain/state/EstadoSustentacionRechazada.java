package co.edu.unicauca.DesingPatterns.domain.state;

import co.edu.unicauca.DesingPatterns.domain.entities.Actions;
import co.edu.unicauca.DesingPatterns.domain.entities.IProjectState;
import co.edu.unicauca.DesingPatterns.domain.entities.ProyectoDeGrado;

public class EstadoSustentacionRechazada implements IProjectState{
    
    @Override
    public String getNombreEstado() {
        return "SustentacionRechazada";
    }
    
    @Override
    public void manejarAccion(ProyectoDeGrado proyecto, Actions accion) {
        //ESTADO FINAL - PROYECTO RECHAZADO
        throw new IllegalStateException("❌ PROYECTO RECHAZADO en sustentación. No se permiten más acciones.");
    }
    
}
