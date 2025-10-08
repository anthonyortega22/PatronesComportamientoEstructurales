package co.edu.unicauca.DesingPatterns.domain.facade;

import co.edu.unicauca.DesingPatterns.domain.entities.ProyectoDeGrado;

public class EvaluatorsAssignment {
    
    public boolean assign(ProyectoDeGrado project) {
        System.out.println("Assigning evaluators for project: " + project.getTitulo());
        // Simula disponibilidad de evaluadores (80% probabilidad)
        boolean assigned = Math.random() > 0.2;
        return assigned;
    }
    
}
