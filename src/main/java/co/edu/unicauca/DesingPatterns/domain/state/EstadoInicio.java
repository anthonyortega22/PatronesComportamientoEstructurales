package co.edu.unicauca.DesingPatterns.domain.state;

import co.edu.unicauca.DesingPatterns.domain.entities.Actions;
import co.edu.unicauca.DesingPatterns.domain.entities.EnumRolActor;
import co.edu.unicauca.DesingPatterns.domain.entities.EnumTipoAccion;
import co.edu.unicauca.DesingPatterns.domain.entities.IProjectState;
import co.edu.unicauca.DesingPatterns.domain.entities.ProyectoDeGrado;


public class EstadoInicio implements IProjectState {

    @Override
    public String getNombreEstado() {
        return "Inicio";
    }
    
    @Override
    public void manejarAccion(ProyectoDeGrado proyecto, Actions accion) {
        if (accion.getTipo() == EnumTipoAccion.PRESENTAR_FORMATO_A && 
            accion.getActor() == EnumRolActor.ESTUDIANTE) {
            proyecto.setState(new EstadoFormatoADiligenciado());
        } else {
            throw new IllegalStateException(
                "Acción no permitida. Solo el ESTUDIANTE puede PRESENTAR_FORMATO_A desde el estado Inicio"
            );
        }
    }
}