package co.edu.unicauca.DesingPatterns.domain.TemplateMethod;

import co.edu.unicauca.DesingPatterns.domain.entities.ProyectoDeGrado;

/**
 * Evaluador concreto para proyectos de Investigación.
 * 
 * Esta estrategia se enfoca en evaluar el rigor científico,
 * la originalidad de la propuesta, la metodología de investigación
 * y el potencial de contribución al conocimiento académico.
 * 
 * @author CRISTHIAN TORRES
 */
public class ResearchProjectEvaluator extends ProjectEvaluator {
    
    @Override
    protected void reviewProblem(ProyectoDeGrado proyecto) {
        System.out.println("🔬 [INVESTIGACIÓN] Revisando planteamiento del problema:");
        System.out.println("   - Verificando relevancia científica y académica");
        System.out.println("   - Evaluando estado del arte y revisión bibliográfica");
        System.out.println("   - Analizando originalidad y contribución al conocimiento");
        System.out.println("   - Validando pregunta de investigación");
        System.out.println("   ✓ Problema con fundamento teórico sólido");
    }
    
    @Override
    protected void reviewGoals(ProyectoDeGrado proyecto) {
        System.out.println("🎯 [INVESTIGACIÓN] Revisando objetivos:");
        System.out.println("   - Validando coherencia con pregunta de investigación");
        System.out.println("   - Verificando claridad y especificidad");
        System.out.println("   - Evaluando alcanzabilidad en tiempo académico (9 meses)");
        System.out.println("   - Analizando contribución científica esperada");
        System.out.println("   ✓ Objetivos alineados con estándares de investigación académica");
    }
    
    @Override
    protected void reviewScope(ProyectoDeGrado proyecto) {
        System.out.println("📏 [INVESTIGACIÓN] Revisando alcance:");
        System.out.println("   - Verificando metodología de investigación propuesta");
        System.out.println("   - Evaluando recursos técnicos y de laboratorio requeridos");
        System.out.println("   - Validando cronograma de actividades investigativas");
        System.out.println("   - Analizando viabilidad de experimentos/pruebas");
        System.out.println("   - Revisando plan de publicación de resultados");
        System.out.println("   ✓ Alcance apropiado para investigación de pregrado");
    }
    
    @Override
    protected void makeDecision(ProyectoDeGrado proyecto) {
        System.out.println("⚖️  [INVESTIGACIÓN] Decisión final:");
        System.out.println("   - Evaluando rigor metodológico");
        System.out.println("   - Verificando viabilidad científica");
        System.out.println("   - Validando potencial de publicación");
        System.out.println("   - Revisando aprobación del director de investigación");
        
        // Simulación de decisión (en producción vendría de una lógica real)
        boolean aprobado = evaluarCriteriosInvestigacion();
        
        if (aprobado) {
            System.out.println("   ✅ PROYECTO APROBADO para Trabajo de Investigación");
            System.out.println("   📚 Puede proceder a fase de desarrollo investigativo");
            System.out.println("   💡 Se recomienda planificar publicación de resultados");
        } else {
            System.out.println("   ❌ PROYECTO REQUIERE REFORMULACIÓN");
            System.out.println("   📝 Se sugiere fortalecer marco teórico y metodología");
        }
    }
    
    /**
     * Método auxiliar para simular la evaluación de criterios de investigación.
     * En un sistema real, esto evaluaría métricas académicas específicas.
     * 
     * @return true si el proyecto cumple los criterios de investigación
     */
    private boolean evaluarCriteriosInvestigacion() {
        // Simulación: 75% de probabilidad de aprobación para investigación
        // (ligeramente más estricto que práctica profesional)
        return Math.random() > 0.25;
    }
}
