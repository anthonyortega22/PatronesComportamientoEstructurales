package co.edu.unicauca.DesingPatterns.domain.entities;

public class ProyectoDeGrado {
    
    private IProjectState state; 
    private String descripcion;

    public ProyectoDeGrado(IProjectState state) {
        this.state = state;
    }

    public IProjectState getState() {
        return state;
    }

    public void setState(IProjectState state) {
        this.state = state;
    }
    
     public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
