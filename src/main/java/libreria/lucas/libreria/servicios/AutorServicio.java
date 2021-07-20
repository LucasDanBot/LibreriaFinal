package libreria.lucas.libreria.servicios;

import java.util.Date;
import libreria.lucas.libreria.entidades.Autor;
import libreria.lucas.libreria.errores.ErrorServicio;
import libreria.lucas.libreria.repositorios.AutorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AutorServicio {
    
    @Autowired
    private AutorRepositorio autorRepositorio;
    
    public void registrarAutor (String nombre) throws ErrorServicio{
        
        if (nombre == null || nombre.isEmpty()) {
            throw new ErrorServicio("El nombre del Autor esta vacio");
        }
        Autor autor = new Autor();
        
        autor.setNombre(nombre);
        autor.setAlta(new Date());
        
        autorRepositorio.save(autor);
    }
    
    private void BajaAutor (String nombre) throws ErrorServicio {
        
        if (nombre == null || nombre.isEmpty()) {
            throw new ErrorServicio("El nombre del Autor esta vacio");
        }
        
        
        Autor autor = autorRepositorio.buscarPorNombre(nombre);
        
        if (autor == null) {
            throw new ErrorServicio("No se encontro ningun Autor con ese nombre");
        }
        
        autor.setBaja(new Date());
        
        autorRepositorio.save(autor);
        
    }
 
    private void AltaAutor(String nombre) throws ErrorServicio {

        if (nombre == null || nombre.isEmpty()) {
            throw new ErrorServicio("El nombre del Autor esta vacio");
        }

        Autor autor = autorRepositorio.buscarPorNombre(nombre);

        if (autor == null) {
            throw new ErrorServicio("No se encontro ningun Autor con ese nombre");
        }

        autor.setBaja(null);

        autorRepositorio.save(autor);

    }

}
