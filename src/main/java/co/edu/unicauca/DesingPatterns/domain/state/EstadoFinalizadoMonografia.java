package co.edu.unicauca.DesingPatterns.domain.state;

import co.edu.unicauca.DesingPatterns.domain.entities.Actions;
import co.edu.unicauca.DesingPatterns.domain.entities.EnumRolActor;
import co.edu.unicauca.DesingPatterns.domain.entities.EnumTipoAccion;
import co.edu.unicauca.DesingPatterns.domain.entities.IProjectState;
import co.edu.unicauca.DesingPatterns.domain.entities.ProyectoDeGrado;

public class EstadoFinalizadoMonografia implements IProjectState{
    
    @Override
    public String getNombreEstado() {
        return "FinalizadoMonografia";
    }
    
    @Override
    public void manejarAccion(ProyectoDeGrado proyecto, Actions accion) {
        if (accion.getTipo() == EnumTipoAccion.PRESENTAR_DECANATURA && 
            accion.getActor() == EnumRolActor.TUTOR) {
            proyecto.setState(new EstadoPresentadoDecanatura());
        } else {
            throw new IllegalStateException(
                "Acción no permitida. Solo el TUTOR puede PRESENTAR_DECANATURA desde FinalizadoMonografia"
            );
        }
    }
    
}
