package co.edu.unicauca.DesingPatterns.domain.entities;

public class ProyectoDeGrado {
    
    private IProjectState state; 

    public ProyectoDeGrado(IProjectState state) {
        this.state = state;
    }

    public IProjectState getState() {
        return state;
    }

    public void setState(IProjectState state) {
        this.state = state;
    }
    
    
    
}
