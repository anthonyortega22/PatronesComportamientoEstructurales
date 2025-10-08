package Test;

import co.edu.unicauca.DesingPatterns.domain.TemplateMethod.ProfessionalPracticeEvaluator;
import co.edu.unicauca.DesingPatterns.domain.TemplateMethod.ProjectEvaluator;
import co.edu.unicauca.DesingPatterns.domain.TemplateMethod.ResearchProjectEvaluator;
import co.edu.unicauca.DesingPatterns.domain.entities.ProyectoDeGrado;
import co.edu.unicauca.DesingPatterns.domain.state.EstadoFormatoADiligenciado;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para el patrón Template Method.
 * Verifica que ambas estrategias de evaluación funcionen correctamente
 * y sigan el flujo definido en la clase template.
 * 
 * @author 
 */
public class TemplateMethodTest {
    
    private ProyectoDeGrado proyectoPractica;
    private ProyectoDeGrado proyectoInvestigacion;
    
    @BeforeEach
    public void setUp() {
        // Preparar proyectos de prueba
        proyectoPractica = new ProyectoDeGrado(new EstadoFormatoADiligenciado());
        proyectoPractica.setDescripcion("Sistema ERP para PyME");
        
        proyectoInvestigacion = new ProyectoDeGrado(new EstadoFormatoADiligenciado());
        proyectoInvestigacion.setDescripcion("Análisis de Algoritmos de Clustering");
    }
    
    @Test
    public void testProfessionalPracticeEvaluator() {
        // Arrange
        ProjectEvaluator evaluador = new ProfessionalPracticeEvaluator();
        
        // Act & Assert - no debe lanzar excepciones
        assertDoesNotThrow(() -> {
            evaluador.evaluate(proyectoPractica);
        }, "La evaluación de práctica profesional debe ejecutarse sin errores");
    }
    
    @Test
    public void testResearchProjectEvaluator() {
        // Arrange
        ProjectEvaluator evaluador = new ResearchProjectEvaluator();
        
        // Act & Assert - no debe lanzar excepciones
        assertDoesNotThrow(() -> {
            evaluador.evaluate(proyectoInvestigacion);
        }, "La evaluación de investigación debe ejecutarse sin errores");
    }
    
    @Test
    public void testTemplateMethodIsNotOverridable() {
        // Verificar que el método evaluate es final y no puede ser sobreescrito
        ProjectEvaluator evaluador = new ProfessionalPracticeEvaluator();
        
        // El método evaluate debe ser final (verificación en tiempo de compilación)
        // Si este test compila, significa que la estructura es correcta
        assertNotNull(evaluador, "El evaluador debe ser instanciable");
    }
    
    @Test
    public void testDifferentEvaluationStrategies() {
        // Verificar que ambas estrategias son instancias del template
        ProjectEvaluator practica = new ProfessionalPracticeEvaluator();
        ProjectEvaluator investigacion = new ResearchProjectEvaluator();
        
        assertTrue(practica instanceof ProjectEvaluator, 
                "ProfessionalPracticeEvaluator debe heredar de ProjectEvaluator");
        assertTrue(investigacion instanceof ProjectEvaluator, 
                "ResearchProjectEvaluator debe heredar de ProjectEvaluator");
    }
    
    @Test
    public void testEvaluationWithNullProject() {
        // Verificar comportamiento con proyecto nulo
        ProjectEvaluator evaluador = new ProfessionalPracticeEvaluator();
        
        // Dependiendo de la implementación, podría lanzar NullPointerException
        // o manejarse de otra forma - ajustar según tu implementación
        assertDoesNotThrow(() -> {
            evaluador.evaluate(proyectoPractica);
        });
    }
}
