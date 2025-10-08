package Test;

import co.edu.unicauca.DesingPatterns.domain.entities.ProyectoDeGrado;
import co.edu.unicauca.DesingPatterns.domain.entities.ProyectoDePrioridad;
import co.edu.unicauca.DesingPatterns.domain.state.EstadoInicio;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para el Patrón Decorator aplicado a ProyectoDeGrado.
 * 
 * Se valida que el decorador ProyectoDePrioridad extienda la funcionalidad
 * del objeto ProyectoDeGrado sin modificar su estructura ni comportamiento base.
 * 
 * @author CRISTHIAN TORRES
 */
public class TestPatronDecorator {
    
    /**
     * Verifica que la descripción del proyecto base se obtenga correctamente.
     */
    @Test
    public void testDescripcionProyectoBase() {
        ProyectoDeGrado proyecto = new ProyectoDeGrado(new EstadoInicio());
        proyecto.setDescripcion("Sistema de Monitoreo Ambiental");

        String descripcionEsperada = "Sistema de Monitoreo Ambiental";
        assertEquals(descripcionEsperada, proyecto.getDescripcion(),
                "La descripción del proyecto base debe coincidir con la esperada");
    }

    /**
     * Verifica que el decorador añada la etiqueta [Alta Prioridad] correctamente.
     */
    @Test
    public void testDescripcionProyectoDePrioridad() {
        ProyectoDeGrado proyecto = new ProyectoDeGrado(new EstadoInicio());
        proyecto.setDescripcion("Sistema de Monitoreo Ambiental");

        ProyectoDeGrado decorado = new ProyectoDePrioridad(proyecto);

        String descripcionEsperada = "Sistema de Monitoreo Ambiental [Alta Prioridad]";
        assertEquals(descripcionEsperada, decorado.getDescripcion(),
                "El decorador no añadió correctamente la etiqueta de alta prioridad");
    }

    /**
     * Verifica que el decorador no modifique la descripción original del proyecto base.
     */
    @Test
    public void testProyectoBaseNoSeModifica() {
        ProyectoDeGrado proyecto = new ProyectoDeGrado(new EstadoInicio());
        proyecto.setDescripcion("Sistema de Monitoreo Ambiental");

        ProyectoDeGrado decorado = new ProyectoDePrioridad(proyecto);

        assertEquals("Sistema de Monitoreo Ambiental", proyecto.getDescripcion(),
                "El decorador no debe alterar la descripción original");
        assertEquals("Sistema de Monitoreo Ambiental [Alta Prioridad]", decorado.getDescripcion(),
                "El decorador debe añadir la etiqueta correctamente");
    }

    /**
     * Verifica que el estado del proyecto se mantenga igual en el decorador.
     */
    @Test
    public void testEstadoSeMantieneEnDecorador() {
        EstadoInicio estado = new EstadoInicio();
        ProyectoDeGrado proyecto = new ProyectoDeGrado(estado);
        ProyectoDeGrado decorado = new ProyectoDePrioridad(proyecto);

        assertSame(proyecto.getState(), decorado.getState(),
                "El estado del proyecto debe mantenerse igual después de aplicar el decorador");
    }
}
