
package co.edu.unicauca.DesingPatterns.domain.TemplateMethod;

import co.edu.unicauca.DesingPatterns.domain.entities.ProyectoDeGrado;

/**
 * Evaluador concreto para proyectos de Práctica Profesional.
 * 
 * Esta estrategia se enfoca en evaluar la aplicabilidad práctica,
 * el impacto empresarial y la viabilidad de implementación en un
 * contexto real de la industria.
 * 
 * @author CRISTHIAN TORRES
 */
public class ProfessionalPracticeEvaluator extends ProjectEvaluator {
    
    @Override
    protected void reviewProblem(ProyectoDeGrado proyecto) {
        System.out.println("📊 [PRÁCTICA PROFESIONAL] Revisando planteamiento del problema:");
        System.out.println("   - Verificando relevancia empresarial del problema");
        System.out.println("   - Evaluando impacto en procesos organizacionales");
        System.out.println("   - Analizando necesidad real de la empresa");
        System.out.println("   ✓ Problema orientado a solución práctica empresarial");
    }
    
    @Override
    protected void reviewGoals(ProyectoDeGrado proyecto) {
        System.out.println("🎯 [PRÁCTICA PROFESIONAL] Revisando objetivos:");
        System.out.println("   - Validando alineación con necesidades de la empresa");
        System.out.println("   - Verificando viabilidad de implementación");
        System.out.println("   - Evaluando resultados medibles y entregables concretos");
        System.out.println("   ✓ Objetivos orientados a resultados empresariales tangibles");
    }
    
    @Override
    protected void reviewScope(ProyectoDeGrado proyecto) {
        System.out.println("📏 [PRÁCTICA PROFESIONAL] Revisando alcance:");
        System.out.println("   - Verificando tiempo disponible en la empresa (6 meses)");
        System.out.println("   - Evaluando recursos empresariales disponibles");
        System.out.println("   - Validando factibilidad técnica en contexto real");
        System.out.println("   - Analizando beneficios esperados para la organización");
        System.out.println("   ✓ Alcance realista para práctica empresarial");
    }
    
    @Override
    protected void makeDecision(ProyectoDeGrado proyecto) {
        System.out.println("⚖️  [PRÁCTICA PROFESIONAL] Decisión final:");
        System.out.println("   - Evaluando coherencia entre problema, objetivos y alcance");
        System.out.println("   - Verificando aprobación del supervisor empresarial");
        System.out.println("   - Validando cumplimiento de normativa académica");
        
        // Simulación de decisión (en producción vendría de una lógica real)
        boolean aprobado = evaluarCriterios();
        
        if (aprobado) {
            System.out.println("   ✅ PROYECTO APROBADO para Práctica Profesional");
            System.out.println("   💼 Puede proceder a firma de convenio empresa-universidad");
        } else {
            System.out.println("   ❌ PROYECTO REQUIERE AJUSTES");
            System.out.println("   📝 Se solicitan correcciones antes de aprobación");
        }
    }
    
    /**
     * Método auxiliar para simular la evaluación de criterios.
     * En un sistema real, esto evaluaría múltiples métricas.
     * 
     * @return true si el proyecto cumple los criterios mínimos
     */
    private boolean evaluarCriterios() {
        // Simulación: 80% de probabilidad de aprobación para práctica profesional
        return Math.random() > 0.2;
    }
}