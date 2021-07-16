package libreria.lucas.libreria.repositorios;

import libreria.lucas.libreria.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositorio  extends JpaRepository<Cliente, Long>{
    
}
