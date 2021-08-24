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
    private FotoPerfil fotoperfil;
    
    @Temporal (TemporalType.TIMESTAMP)
    private Date alta;
    
    @Temporal (TemporalType.TIMESTAMP)
    private Date baja;
    
    
    
    // CONSTRUCTORES -----------------------------------------------------------
    
    public Usuario() {
    }

    public Usuario(Integer dni, String nombre, String apellido, String email, String clave, FotoPerfil fotoperfil, Date alta, Date baja) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.clave = clave;
        this.fotoperfil = fotoperfil;
        this.alta = alta;
        this.baja = baja;
    }
    
    // GETTER Y SETTERS --------------------------------------------------------

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public FotoPerfil getFotoperfil() {
        return fotoperfil;
    }

    public void setFotoperfil(FotoPerfil fotoperfil) {
        this.fotoperfil = fotoperfil;
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
