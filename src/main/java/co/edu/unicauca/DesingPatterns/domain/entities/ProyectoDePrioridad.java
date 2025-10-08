package co.edu.unicauca.DesingPatterns.domain.entities;

import co.edu.unicauca.DesingPatterns.domain.decorator.ProyectoDeGradoDecorator;

public class ProyectoDePrioridad extends ProyectoDeGradoDecorator{
    
    public ProyectoDePrioridad(ProyectoDeGrado proyecto) {
        super(proyecto);
    }
    
    
    @Override
    public String getDescripcion() {
        // Extiende el comportamiento añadiendo la etiqueta de prioridad
        return proyecto.getDescripcion() + " [Alta Prioridad]";
    }
    
}
