package co.edu.unicauca.DesingPatterns.domain.state;

import co.edu.unicauca.DesingPatterns.domain.entities.Actions;
import co.edu.unicauca.DesingPatterns.domain.entities.EnumRolActor;
import co.edu.unicauca.DesingPatterns.domain.entities.EnumTipoAccion;
import co.edu.unicauca.DesingPatterns.domain.entities.IProjectState;
import co.edu.unicauca.DesingPatterns.domain.entities.ProyectoDeGrado;

public class EstadoPresentadoDecanatura implements IProjectState{
    
    @Override
    public String getNombreEstado() {
        return "PresentadoDecanatura";
    }
    
    @Override
    public void manejarAccion(ProyectoDeGrado proyecto, Actions accion) {
        if (accion.getTipo() == EnumTipoAccion.ASIGNAR_FECHA_SUSTENTACION && 
            accion.getActor() == EnumRolActor.DECANO) {
            proyecto.setState(new EstadoFechaSustentacionFijada());
        } else {
            throw new IllegalStateException(
                "Acción no permitida. Solo el DECANO puede ASIGNAR_FECHA_SUSTENTACION desde PresentadoDecanatura"
            );
        }
    }
    
}
