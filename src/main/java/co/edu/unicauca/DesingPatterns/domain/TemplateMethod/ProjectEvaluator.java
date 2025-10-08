package co.edu.unicauca.DesingPatterns.domain.TemplateMethod;

import co.edu.unicauca.DesingPatterns.domain.entities.ProyectoDeGrado;

/**
 * Clase template que define un flujo común de evaluación de proyectos de grado,
 * permitiendo que distintas estrategias de evaluación personalicen algunos pasos.
 * 
 * Implementa el patrón Template Method para estandarizar el proceso de evaluación
 * mientras permite flexibilidad en la implementación de cada criterio específico.
 * 
 * @author CRISTHIAN TORRES
 */
public abstract class ProjectEvaluator {
    
    /**
     * Método template que define el flujo de evaluación.
     * Este método es FINAL para garantizar que el orden de ejecución
     * no pueda ser alterado por las subclases.
     * 
     * @param proyecto El proyecto de grado a evaluar
     */
    public final void evaluate(ProyectoDeGrado proyecto) {
        System.out.println("\n🔍 Iniciando evaluación del proyecto...");
        System.out.println("══════════════════════════════════════════════════");
        
        // Paso 1: Revisar el planteamiento del problema
        reviewProblem(proyecto);
        
        // Paso 2: Revisar los objetivos del proyecto
        reviewGoals(proyecto);
        
        // Paso 3: Revisar el alcance del proyecto
        reviewScope(proyecto);
        
        // Paso 4: Tomar la decisión final
        makeDecision(proyecto);
        
        System.out.println("══════════════════════════════════════════════════");
        System.out.println("✅ Evaluación completada\n");
    }
    
    /**
     * Método abstracto para revisar el planteamiento del problema.
     * Cada estrategia de evaluación debe implementar sus propios criterios.
     * 
     * @param proyecto El proyecto a evaluar
     */
    protected abstract void reviewProblem(ProyectoDeGrado proyecto);
    
    /**
     * Método abstracto para revisar los objetivos del proyecto.
     * Cada estrategia de evaluación debe implementar sus propios criterios.
     * 
     * @param proyecto El proyecto a evaluar
     */
    protected abstract void reviewGoals(ProyectoDeGrado proyecto);
    
    /**
     * Método abstracto para revisar el alcance del proyecto.
     * Cada estrategia de evaluación debe implementar sus propios criterios.
     * 
     * @param proyecto El proyecto a evaluar
     */
    protected abstract void reviewScope(ProyectoDeGrado proyecto);
    
    /**
     * Método abstracto para tomar la decisión final de evaluación.
     * Cada estrategia de evaluación debe implementar su propia lógica de decisión.
     * 
     * @param proyecto El proyecto a evaluar
     */
    protected abstract void makeDecision(ProyectoDeGrado proyecto);
}