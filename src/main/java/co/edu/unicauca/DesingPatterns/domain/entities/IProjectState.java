package co.edu.unicauca.DesingPatterns.domain.entities;

public interface IProjectState {
    
    void manejarAccion(ProyectoDeGrado proyecto, Actions accion);
    String getNombreEstado();
 
}
