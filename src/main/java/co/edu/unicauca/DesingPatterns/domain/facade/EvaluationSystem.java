package co.edu.unicauca.DesingPatterns.domain.facade;

import co.edu.unicauca.DesingPatterns.domain.entities.ProyectoDeGrado;

public class EvaluationSystem {
    
    public boolean evaluate(ProyectoDeGrado project) {
        System.out.println("Evaluating project: " + project.getTitulo());
        return Math.random() > 0.3; // 70% probability of approval
    }

    
}
