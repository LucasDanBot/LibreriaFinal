package libreria.lucas.libreria.servicios;

import libreria.lucas.libreria.repositorios.EditorialRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EditorialServicio {
    
    @Autowired
    private EditorialRepositorio editorialrespositorio;
    
    
    
}
