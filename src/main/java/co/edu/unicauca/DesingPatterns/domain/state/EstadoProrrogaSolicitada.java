package co.edu.unicauca.DesingPatterns.domain.state;

import co.edu.unicauca.DesingPatterns.domain.entities.Actions;
import co.edu.unicauca.DesingPatterns.domain.entities.EnumRolActor;
import co.edu.unicauca.DesingPatterns.domain.entities.EnumTipoAccion;
import co.edu.unicauca.DesingPatterns.domain.entities.IProjectState;
import co.edu.unicauca.DesingPatterns.domain.entities.ProyectoDeGrado;

public class EstadoProrrogaSolicitada implements IProjectState {
    @Override
    public String getNombreEstado() {
        return "ProrrogaSolicitada";
    }
    
    @Override
    public void manejarAccion(ProyectoDeGrado proyecto, Actions accion) {
        if (accion.getTipo() == EnumTipoAccion.FINALIZAR_MONOGRAFIA && 
            accion.getActor() == EnumRolActor.ESTUDIANTE) {
            proyecto.setState(new EstadoFinalizadoMonografia());
        } else {
            throw new IllegalStateException(
                "Acción no permitida. Solo el ESTUDIANTE puede FINALIZAR_MONOGRAFIA desde ProrrogaSolicitada"
            );
        }
    }
}
