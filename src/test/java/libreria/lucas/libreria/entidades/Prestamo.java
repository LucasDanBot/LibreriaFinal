package libreria.lucas.libreria.entidades;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Prestamo {
    
    // PARAMETROS --------------------------------------------------------------
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto genera este valor 1,2,3.... n
    private Integer id;
    // La consigna dice String para que sea un generador alfanumerico, pero el profesor dijo que lo hagamos con integer.
    
    @Temporal(TemporalType.DATE) // Se debe implemetar porque MySQL tiene muchos tipos de fechas
    private Date fecha;
    
    @Temporal(TemporalType.DATE)
    private Date devolucion;
    
    @ManyToOne
    private Libro libro;
    
    @ManyToOne
    private Cliente cliente;
    
    // CONSTRUCTORES -----------------------------------------------------------

    

    // GETTER Y SETTERS --------------------------------------------------------

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getDevolucion() {
        return devolucion;
    }

    public void setDevolucion(Date devolucion) {
        this.devolucion = devolucion;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
    
}
