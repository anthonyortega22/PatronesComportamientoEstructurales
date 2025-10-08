package co.edu.unicauca.DesingPatterns.domain.entities;

public class ProyectoDeGrado {
    
    
    private String titulo;
    private String name; 
    private IProjectState state; 
    private String descripcion;

    public ProyectoDeGrado(String titulo, String name) {
        this.titulo = titulo;
        this.name = name;
    }

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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
    
    
    
}
