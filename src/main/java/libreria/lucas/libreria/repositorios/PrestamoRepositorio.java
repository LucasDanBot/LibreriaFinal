package libreria.lucas.libreria.repositorios;

import libreria.lucas.libreria.entidades.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrestamoRepositorio extends JpaRepository<Prestamo, Integer>{
    
}
