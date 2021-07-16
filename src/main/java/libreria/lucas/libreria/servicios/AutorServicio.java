package libreria.lucas.libreria.servicios;

import java.util.Date;
import libreria.lucas.libreria.entidades.Autor;
import libreria.lucas.libreria.repositorios.AutorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AutorServicio {
    
    @Autowired
    private AutorRepositorio autorRepositorio;
    
    public void registrarAutor (String nombre) {
        
        Autor autor = new Autor();
        
        autor.setNombre(nombre);
        autor.setAlta(new Date());
        
        autorRepositorio.save(autor);
    }
    
    private void darBajaAutor (String nombre) {
        
        Autor autor = autorRepositorio.buscarPorNombre(nombre);
        
        autor.setBaja(new Date());
        
        autorRepositorio.save(autor);
        
        
    }
    
    
}
