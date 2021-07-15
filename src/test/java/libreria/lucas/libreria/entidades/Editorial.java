package libreria.lucas.libreria.entidades;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Editorial {
    
    // PARAMETROS --------------------------------------------------------------
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto genera este valor 1,2,3.... n
    private Integer id;
    private String nombre;
    
    @Temporal (TemporalType.TIMESTAMP)
    private Date alta;
    
    @Temporal (TemporalType.TIMESTAMP)
    private Date baja;
    
    
    // CONSTRUCTORES -----------------------------------------------------------

    
    
    // GETTER Y SETTERS --------------------------------------------------------

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getAlta() {
        return alta;
    }

    public void setAlta(Date alta) {
        this.alta = alta;
    }

    public Date getBaja() {
        return baja;
    }

    public void setBaja(Date baja) {
        this.baja = baja;
    }
    
    
    
}
