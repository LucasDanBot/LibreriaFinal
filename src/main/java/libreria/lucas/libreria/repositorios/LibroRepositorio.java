package libreria.lucas.libreria.repositorios;

import java.util.List;
import libreria.lucas.libreria.entidades.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepositorio extends JpaRepository<Libro, Long>{
    
    /*
    @Query("SELECT l FROM Libro l WHERE l.baja <=> :null")
    public List<Libro> buscarPorNombre ();
    */
    
}
