package libreria.lucas.libreria.repositorios;

import java.util.List;
import libreria.lucas.libreria.entidades.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepositorio extends JpaRepository<Libro, Long>{
    
    @Query("SELECT l FROM Libro l WHERE l.autor.nombre = :nombre")
    public List<Libro> buscarPorNombre (@Param("nombre") String nombre);
    
    @Query("SELECT l FROM Libro l WHERE l.baja IS NOT NULL")
    public List<Libro> buscarPorNombreNoActivos ();
    
    @Query("SELECT l FROM Libro l WHERE l.baja IS NULL")
    public List<Libro> buscarPorNombreActivos ();
    
    
    
}
