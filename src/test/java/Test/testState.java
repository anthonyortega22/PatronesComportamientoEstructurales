package Test;

import co.edu.unicauca.DesingPatterns.domain.entities.*;
import co.edu.unicauca.DesingPatterns.domain.state.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class testState {

    // ===== TEST 1: ESTADO INICIAL =====
    @Test
    public void testProyectoIniciaEnEstadoInicio() {
        ProyectoDeGrado proyecto = new ProyectoDeGrado(new EstadoInicio());
        assertEquals("Inicio", proyecto.getState().getNombreEstado());
    }

    // ===== TEST 2: CAMBIO DE ESTADO BÁSICO =====
    @Test
    public void testCambioDeEstado() {
        ProyectoDeGrado proyecto = new ProyectoDeGrado(new EstadoInicio());
        proyecto.setState(new EstadoFormatoADiligenciado());
        assertEquals("FormatoADiligenciado", proyecto.getState().getNombreEstado());
    }

    // ===== TEST 3: FLUJO EXITOSO SIMPLIFICADO =====
    @Test
    public void testFlujoExitosoBasico() {
        ProyectoDeGrado proyecto = new ProyectoDeGrado(new EstadoInicio());
        
        // De Inicio a FormatoADiligenciado
        proyecto.getState().manejarAccion(proyecto, 
            new Actions(EnumTipoAccion.PRESENTAR_FORMATO_A, EnumRolActor.ESTUDIANTE, ""));
        assertEquals("FormatoADiligenciado", proyecto.getState().getNombreEstado());
        
        // De FormatoADiligenciado a PresentadoAlCoordinador
        proyecto.getState().manejarAccion(proyecto,
            new Actions(EnumTipoAccion.PRESENTAR_ANTEPROYECTO, EnumRolActor.TUTOR, ""));
        assertEquals("PresentadoAlCoordinador", proyecto.getState().getNombreEstado());
    }

    // ===== TEST 4: VALIDACIÓN DE ROLES =====
    @Test
    public void testSoloEstudiantePuedePresentarFormatoA() {
        ProyectoDeGrado proyecto = new ProyectoDeGrado(new EstadoInicio());
        
        // Rol correcto - debería funcionar
        proyecto.getState().manejarAccion(proyecto,
            new Actions(EnumTipoAccion.PRESENTAR_FORMATO_A, EnumRolActor.ESTUDIANTE, ""));
        assertEquals("FormatoADiligenciado", proyecto.getState().getNombreEstado());
        
        // Resetear proyecto
        proyecto.setState(new EstadoInicio());
        
        // Rol incorrecto - debería fallar
        assertThrows(IllegalStateException.class, () -> {
            proyecto.getState().manejarAccion(proyecto,
                new Actions(EnumTipoAccion.PRESENTAR_FORMATO_A, EnumRolActor.TUTOR, ""));
        });
    }

    // ===== TEST 5: ESTADO FINAL BLOQUEA ACCIONES =====
    @Test
    public void testEstadoFinalBloqueaAcciones() {
        ProyectoDeGrado proyecto = new ProyectoDeGrado(new EstadoSustentacionAprobada());
        
        assertThrows(Exception.class, () -> {
            proyecto.getState().manejarAccion(proyecto,
                new Actions(EnumTipoAccion.PRESENTAR_FORMATO_A, EnumRolActor.ESTUDIANTE, ""));
        });
    }

    // ===== TEST 6: TRANSICIONES MÚLTIPLES DESDE UN ESTADO =====
    @Test
    public void testEstadoConMultipleTransiciones() {
        ProyectoDeGrado proyecto = new ProyectoDeGrado(new EstadoEnEvaluacionComite());
        
        // Probar transición a AceptadoPorComite
        proyecto.getState().manejarAccion(proyecto,
            new Actions(EnumTipoAccion.APROBAR_COMITE, EnumRolActor.MIEMBRO_COMITE, ""));
        assertEquals("AceptadoPorComite", proyecto.getState().getNombreEstado());
        
        // Resetear y probar transición a RechazadoPorComite
        proyecto.setState(new EstadoEnEvaluacionComite());
        proyecto.getState().manejarAccion(proyecto,
            new Actions(EnumTipoAccion.RECHAZAR_COMITE, EnumRolActor.MIEMBRO_COMITE, ""));
        assertEquals("RechazadoPorComite", proyecto.getState().getNombreEstado());
    }

    // ===== TEST 7: FLUJO DE CORRECCIONES =====
    @Test
    public void testFlujoCorrecciones() {
        ProyectoDeGrado proyecto = new ProyectoDeGrado(new EstadoCorreccionesComite());
        
        // De CorreccionesComite vuelve a FormatoADiligenciado
        proyecto.getState().manejarAccion(proyecto,
            new Actions(EnumTipoAccion.CORREGIR_FORMATO_A, EnumRolActor.ESTUDIANTE, ""));
        assertEquals("FormatoADiligenciado", proyecto.getState().getNombreEstado());
    }

    // ===== TEST 8: ACCIÓN INCORRECTA EN ESTADO =====
    @Test
    public void testAccionNoPermitidaEnEstado() {
        ProyectoDeGrado proyecto = new ProyectoDeGrado(new EstadoInicio());
        
        assertThrows(IllegalStateException.class, () -> {
            proyecto.getState().manejarAccion(proyecto,
                new Actions(EnumTipoAccion.APROBAR_COMITE, EnumRolActor.MIEMBRO_COMITE, ""));
        });
    }
}