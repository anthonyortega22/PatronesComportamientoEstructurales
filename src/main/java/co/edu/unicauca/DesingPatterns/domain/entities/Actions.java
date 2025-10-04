package co.edu.unicauca.DesingPatterns.domain.entities;

public class Actions {
    
    private EnumTipoAccion tipo;
    private EnumRolActor actor;
    private String comentario;

    public Actions(EnumTipoAccion tipo, EnumRolActor actor, String comentario) {
        this.tipo = tipo;
        this.actor = actor;
        this.comentario = comentario;
    }

    public EnumTipoAccion getTipo() {
        return tipo;
    }

    public EnumRolActor getActor() {
        return actor;
    }

    public String getComentario() {
        return comentario;
    }
    
    @Override
    public String toString() {
        return "Accion{" +
               "tipo=" + tipo +
               ", actor=" + actor +
               ", comentario='" + comentario + '\'' +
               '}';
    }
}
    

