package libreria.lucas.libreria.entidades;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
public class Usuario {
    
    // PARAMETROS --------------------------------------------------------------
    
    @Id
    private Integer dni;
    private String nombre;
    private String apellido;
    private String email;
    private String clave;
    
    @OneToOne
    private Foto foto;
    
    @Temporal (TemporalType.TIMESTAMP)
    private Date alta;
    
    @Temporal (TemporalType.TIMESTAMP)
    private Date baja;
    
    
    
    // CONSTRUCTORES -----------------------------------------------------------
    
    public Usuario() {
    }

    
    
    // GETTER Y SETTERS --------------------------------------------------------
    
    
    
}
