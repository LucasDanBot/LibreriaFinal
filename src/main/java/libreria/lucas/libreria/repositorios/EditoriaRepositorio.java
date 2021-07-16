package libreria.lucas.libreria.repositorios;

import libreria.lucas.libreria.entidades.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditoriaRepositorio extends JpaRepository<Editorial, Integer>{
    
}
