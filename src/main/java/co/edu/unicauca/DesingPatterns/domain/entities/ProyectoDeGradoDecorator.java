/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.DesingPatterns.domain.entities;

/**
 *
 * Decorador abstracto que extiende ProyectoDeGrado y permite
 * añadir funcionalidad adicional sin modificar la clase base.
 * 
 * @author CRISTHIAN TORRES
 */
public abstract class ProyectoDeGradoDecorator extends ProyectoDeGrado {
    
  
    protected ProyectoDeGrado proyecto;
    
    public ProyectoDeGradoDecorator(ProyectoDeGrado proyecto) {
      
        super(proyecto.getState());
        this.proyecto = proyecto;
    }

    @Override
    public IProjectState getState() {
        return proyecto.getState();
    }

    @Override
    public void setState(IProjectState state) {
        proyecto.setState(state);
    }
}
