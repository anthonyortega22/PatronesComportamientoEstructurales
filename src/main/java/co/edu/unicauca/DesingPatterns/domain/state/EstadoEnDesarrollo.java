package co.edu.unicauca.DesingPatterns.domain.state;

import co.edu.unicauca.DesingPatterns.domain.entities.Actions;
import co.edu.unicauca.DesingPatterns.domain.entities.EnumRolActor;
import co.edu.unicauca.DesingPatterns.domain.entities.EnumTipoAccion;
import co.edu.unicauca.DesingPatterns.domain.entities.IProjectState;
import co.edu.unicauca.DesingPatterns.domain.entities.ProyectoDeGrado;

public class EstadoEnDesarrollo implements IProjectState{
    
    @Override
    public String getNombreEstado() {
        return "EnDesarrollo";
    }
    
    @Override
    public void manejarAccion(ProyectoDeGrado proyecto, Actions accion) {
        if (accion.getTipo() == EnumTipoAccion.SOLICITAR_PRORROGA && 
            accion.getActor() == EnumRolActor.ESTUDIANTE) {
            proyecto.setState(new EstadoProrrogaSolicitada());
        } else if (accion.getTipo() == EnumTipoAccion.FINALIZAR_MONOGRAFIA && 
                   accion.getActor() == EnumRolActor.ESTUDIANTE) {
            proyecto.setState(new EstadoFinalizadoMonografia());
        } else {
            throw new IllegalStateException(
                "Acción no permitida. El ESTUDIANTE solo puede SOLICITAR_PRORROGA o FINALIZAR_MONOGRAFIA desde EnDesarrollo"
            );
        }
    }
    
}
