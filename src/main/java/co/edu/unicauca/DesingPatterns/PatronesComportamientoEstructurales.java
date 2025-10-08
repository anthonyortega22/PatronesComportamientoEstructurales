package co.edu.unicauca.DesingPatterns;

import co.edu.unicauca.DesingPatterns.domain.adapter.ExternalService;
import co.edu.unicauca.DesingPatterns.domain.adapter.Company;
import co.edu.unicauca.DesingPatterns.domain.adapter.CompanyDataProvider;
import co.edu.unicauca.DesingPatterns.domain.adapter.ExternalServiceAdapter;
import co.edu.unicauca.DesingPatterns.domain.entities.*;
import co.edu.unicauca.DesingPatterns.domain.state.*;
import co.edu.unicauca.DesingPatterns.domain.TemplateMethod.ProjectEvaluator;
import co.edu.unicauca.DesingPatterns.domain.TemplateMethod.ProfessionalPracticeEvaluator;
import co.edu.unicauca.DesingPatterns.domain.TemplateMethod.ResearchProjectEvaluator;

public class PatronesComportamientoEstructurales {

    
    public static void main(String[] args) {
        System.out.println("=== PRUEBA DEL SISTEMA DE PROYECTOS DE GRADO ===\n");
        
        // 1. Crear un nuevo proyecto en estado INICIO
        ProyectoDeGrado proyecto = new ProyectoDeGrado(new EstadoInicio());
        System.out.println("📝 Proyecto creado. Estado actual: " + proyecto.getState().getNombreEstado());
        
        try {
            // === FASE 1: FORMULARIO A ===
            System.out.println("\n--- FASE 1: FORMULARIO A ---");
            
            // Estudiante presenta Formato A
            ejecutarAccion(proyecto, new Actions(
                EnumTipoAccion.PRESENTAR_FORMATO_A, 
                EnumRolActor.ESTUDIANTE, 
                "Formato A completado con la propuesta de investigación"
            ));
            
            // Tutor presenta al coordinador
            ejecutarAccion(proyecto, new Actions(
                EnumTipoAccion.PRESENTAR_ANTEPROYECTO,
                EnumRolActor.TUTOR,
                "Proyecto listo para revisión del coordinador"
            ));
            
            // Coordinador envía al comité
            ejecutarAccion(proyecto, new Actions(
                EnumTipoAccion.EVALUAR_COMITE,
                EnumRolActor.COORDINADOR,
                "Enviando a evaluación del comité curricular"
            ));
            
            // Comité aprueba el formato A
            ejecutarAccion(proyecto, new Actions(
                EnumTipoAccion.APROBAR_COMITE,
                EnumRolActor.MIEMBRO_COMITE,
                "Formato A cumple con los requisitos, aprobado"
            ));
            
            // === FASE 2: ANTEPROYECTO ===
            System.out.println("\n--- FASE 2: ANTEPROYECTO ---");
            
            // Estudiante inicia anteproyecto
            ejecutarAccion(proyecto, new Actions(
                EnumTipoAccion.INICIAR_ANTEPROYECTO,
                EnumRolActor.ESTUDIANTE,
                "Iniciando escritura del anteproyecto"
            ));
            
            // Tutor presenta anteproyecto a jefatura
            ejecutarAccion(proyecto, new Actions(
                EnumTipoAccion.PRESENTAR_ANTEPROYECTO,
                EnumRolActor.TUTOR,
                "Anteproyecto completo para evaluación del departamento"
            ));
            
            // Jefe de departamento envía a evaluación
            ejecutarAccion(proyecto, new Actions(
                EnumTipoAccion.EVALUAR_DEPARTAMENTO,
                EnumRolActor.JEFE_DEPARTAMENTO,
                "Asignando evaluadores del departamento"
            ));
            
            // Evaluador del departamento aprueba
            ejecutarAccion(proyecto, new Actions(
                EnumTipoAccion.APROBAR_DEPARTAMENTO,
                EnumRolActor.EVALUADOR_DEPARTAMENTO,
                "Anteproyecto cumple con los estándares académicos"
            ));
            
            // === FASE 3: CONSEJO DE FACULTAD ===
            System.out.println("\n--- FASE 3: CONSEJO DE FACULTAD ---");
            
            // Consejo de facultad aprueba
            ejecutarAccion(proyecto, new Actions(
                EnumTipoAccion.APROBAR_CONSEJO,
                EnumRolActor.CONSEJO_FACULTAD,
                "Proyecto aprobado en sesión del consejo de facultad"
            ));
            
            // Consejo emite resolución
            ejecutarAccion(proyecto, new Actions(
                EnumTipoAccion.EMITIR_RESOLUCION,
                EnumRolActor.CONSEJO_FACULTAD,
                "Resolución No. 2024-001 emitida"
            ));
            
            // === FASE 4: DESARROLLO ===
            System.out.println("\n--- FASE 4: DESARROLLO ---");
            
            // Estudiante inicia desarrollo
            ejecutarAccion(proyecto, new Actions(
                EnumTipoAccion.INICIAR_DESARROLLO,
                EnumRolActor.ESTUDIANTE,
                "Iniciando los 9 meses de desarrollo del proyecto"
            ));
            
            // Estudiante finaliza monografía
            ejecutarAccion(proyecto, new Actions(
                EnumTipoAccion.FINALIZAR_MONOGRAFIA,
                EnumRolActor.ESTUDIANTE,
                "Monografía y productos finalizados"
            ));
            
            // Tutor presenta a decanatura
            ejecutarAccion(proyecto, new Actions(
                EnumTipoAccion.PRESENTAR_DECANATURA,
                EnumRolActor.TUTOR,
                "Documentación completa presentada a decanatura"
            ));
            
            // === FASE 5: SUSTENTACIÓN ===
            System.out.println("\n--- FASE 5: SUSTENTACIÓN ---");
            
            // Decano asigna fecha de sustentación
            ejecutarAccion(proyecto, new Actions(
                EnumTipoAccion.ASIGNAR_FECHA_SUSTENTACION,
                EnumRolActor.DECANO,
                "Sustentación programada para 15 de Diciembre, 2024"
            ));
            
            // Estudiante realiza sustentación
            ejecutarAccion(proyecto, new Actions(
                EnumTipoAccion.REALIZAR_SUSTENTACION,
                EnumRolActor.ESTUDIANTE,
                "Sustentación pública realizada exitosamente"
            ));
            
            // Jurado aprueba la sustentación
            ejecutarAccion(proyecto, new Actions(
                EnumTipoAccion.APROBAR_SUSTENTACION,
                EnumRolActor.JURADO,
                "Proyecto aprobado por unanimidad. Felicitaciones"
            ));
            
            System.out.println("\n🎓 ¡PROYECTO DE GRADO COMPLETADO EXITOSAMENTE!");
            
        } catch (Exception e) {
            System.out.println("\n❌ Error: " + e.getMessage());
            System.out.println("Estado final: " + proyecto.getState().getNombreEstado());
        }
        
        // Prueba de acciones inválidas
        System.out.println("\n=== PRUEBA DE VALIDACIONES ===");
        try {
            // Intentar una acción no permitida en estado final
            ejecutarAccion(proyecto, new Actions(
                EnumTipoAccion.PRESENTAR_FORMATO_A,
                EnumRolActor.ESTUDIANTE,
                "Esta acción debería fallar"
            ));
        } catch (Exception e) {
            System.out.println("✅ Validación funcionando: " + e.getMessage());
        }
        
        // ==========================================================
        // 🔄 INTEGRACIÓN DEL PATRÓN ADAPTER
        // ==========================================================
        System.out.println("\n=== PRUEBA DE INTEGRACIÓN CON SERVICIO EXTERNO (ADAPTER) ===");

        // Creamos el servicio externo que retorna datos en formato JSON
        ExternalService externalService = new ExternalService();
        // Creamos el adaptador para convertir el JSON a un objeto Company
        CompanyDataProvider adapter = new ExternalServiceAdapter(externalService);
        // Obtenemos la empresa adaptada
        Company empresa = adapter.getCompany();

        System.out.println("✅ Datos de empresa adaptados correctamente:");
        System.out.println("Nombre de empresa: " + empresa.getName());
        System.out.println("Representación completa: " + empresa);

        // ==========================================================
        //  PATRÓN DECORATOR
        // ==========================================================
        System.out.println("\n=== PRUEBA DEL PATRÓN DECORATOR ===");

        ProyectoDeGrado proyectoNormal = new ProyectoDeGrado(new EstadoInicio());
        ProyectoDeGrado proyectoPrioritario = new ProyectoDePrioridad(proyectoNormal);

        System.out.println("Descripción del proyecto normal:");
        System.out.println("➡️ " + proyectoNormal.getDescripcion());

        System.out.println("Descripción del proyecto con prioridad:");
        System.out.println("🚨 " + proyectoPrioritario.getDescripcion());
        
        // ==========================================================
// 📋 INTEGRACIÓN DEL PATRÓN TEMPLATE METHOD
// ==========================================================
System.out.println("\n=== PRUEBA DEL PATRÓN TEMPLATE METHOD ===");
System.out.println("Evaluación de proyectos según modalidad\n");

// Crear dos proyectos de ejemplo para evaluar
ProyectoDeGrado proyectoPractica = new ProyectoDeGrado(new EstadoFormatoADiligenciado());
proyectoPractica.setDescripcion("Sistema de Gestión de Inventarios para Empaques del Cauca");

ProyectoDeGrado proyectoInvestigacion = new ProyectoDeGrado(new EstadoFormatoADiligenciado());
proyectoInvestigacion.setDescripcion("Aplicación de Machine Learning para Predicción de Demanda");

// === EVALUACIÓN DE PRÁCTICA PROFESIONAL ===
System.out.println("═══════════════════════════════════════════════════════════");
System.out.println("📊 MODALIDAD: PRÁCTICA PROFESIONAL");
System.out.println("Proyecto: " + proyectoPractica.getDescripcion());
System.out.println("═══════════════════════════════════════════════════════════");

ProjectEvaluator evaluadorPractica = new ProfessionalPracticeEvaluator();
evaluadorPractica.evaluate(proyectoPractica);

// === EVALUACIÓN DE TRABAJO DE INVESTIGACIÓN ===
System.out.println("\n═══════════════════════════════════════════════════════════");
System.out.println("🔬 MODALIDAD: TRABAJO DE INVESTIGACIÓN");
System.out.println("Proyecto: " + proyectoInvestigacion.getDescripcion());
System.out.println("═══════════════════════════════════════════════════════════");

ProjectEvaluator evaluadorInvestigacion = new ResearchProjectEvaluator();
evaluadorInvestigacion.evaluate(proyectoInvestigacion);

System.out.println("\n✅ Patrón Template Method aplicado exitosamente");
System.out.println("   - Se mantiene el flujo de evaluación consistente");
System.out.println("   - Cada modalidad personaliza sus criterios específicos");
        
    
    }
    
    private static void ejecutarAccion(ProyectoDeGrado proyecto, Actions accion) {
        System.out.println("\n➡️ Ejecutando acción: " + accion.getTipo() + " por " + accion.getActor());
        System.out.println("Comentario: " + accion.getComentario());
        proyecto.getState().manejarAccion(proyecto, accion);
        System.out.println("✅ Estado actual: " + proyecto.getState().getNombreEstado());
    }
}


    
    
    
    

    
