package libreria.lucas.libreria.entidades;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Foto {
    
    // PARAMETROS --------------------------------------------------------------
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String nombre;
    private String mime;
    
    @Lob @Basic(fetch = FetchType.Lazy)
    private byte[] contenido;

    
    // CONSTRUCTORES -----------------------------------------------------------

    public Foto() {
    }

    public Foto(Integer id, String nombre, String mime, byte[] contenido) {
        this.id = id;
        this.nombre = nombre;
        this.mime = mime;
        this.contenido = contenido;
    }
    
    
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

    public String getMime() {
        return mime;
    }

    public void setMime(String mime) {
        this.mime = mime;
    }

    public byte[] getContenido() {
        return contenido;
    }

    public void setContenido(byte[] contenido) {
        this.contenido = contenido;
    }
    
    
    
}
