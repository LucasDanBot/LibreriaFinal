package libreria.lucas.libreria.repositorios;

import libreria.lucas.libreria.entidades.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface AutorRepositorio extends JpaRepository<Autor, Integer>{
    
    @Query("SELECT c FROM Autor c WHERE c.nombre = :nombre")
    public Autor buscarPorNombre (@Param("nombre") String nombre);
    /*
    @Query("SELECT c FROM Autor c WHERE UPPER(c.nombre) = :UPPER(nombre)")
    public List<Autor> buscarPorNombre (@Param("nombre") String nombre);
    */
    
    
}
