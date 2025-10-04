package co.edu.unicauca.DesingPatterns.domain.state;

import co.edu.unicauca.DesingPatterns.domain.entities.Actions;
import co.edu.unicauca.DesingPatterns.domain.entities.EnumRolActor;
import co.edu.unicauca.DesingPatterns.domain.entities.EnumTipoAccion;
import co.edu.unicauca.DesingPatterns.domain.entities.IProjectState;
import co.edu.unicauca.DesingPatterns.domain.entities.ProyectoDeGrado;

public class EstadoFormatoADiligenciado implements IProjectState{

    @Override
    public String getNombreEstado() {
        return "FormatoADiligenciado";
    }
    
    @Override
    public void manejarAccion(ProyectoDeGrado proyecto, Actions accion) {
        if (accion.getTipo() == EnumTipoAccion.PRESENTAR_ANTEPROYECTO && 
            accion.getActor() == EnumRolActor.TUTOR) {
            proyecto.setState(new EstadoPresentadoAlCoordinador());
        } else {
            throw new IllegalStateException(
                "Acción no permitida. Solo el TUTOR puede PRESENTAR_ANTEPROYECTO desde Formato A Diligenciado"
            );
        }
    }
    
}
