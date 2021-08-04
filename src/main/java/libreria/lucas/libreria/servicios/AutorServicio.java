package libreria.lucas.libreria.servicios;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import libreria.lucas.libreria.entidades.Autor;
import libreria.lucas.libreria.errores.ErrorServicio;
import libreria.lucas.libreria.repositorios.AutorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorServicio {

    @Autowired
    private AutorRepositorio autorRepositorio;

    public void registrarAutor(String nombre) throws ErrorServicio {

        validar(nombre);

        /*segunda validacion, si no existe ya un autor con ese nombre */
        Autor autor = autorRepositorio.buscarPorNombre(nombre);

        if (autor == null) {
            Autor autor1 = new Autor();
            autor1.setNombre(nombre);
            autor1.setAlta(new Date());
            autorRepositorio.save(autor1);
        } else {
            throw new ErrorServicio("Ya existe un autor con ese nombre");
        }
    }

    public void modificarAutor(String nombre, String nombreNuevo) throws ErrorServicio {

        validar(nombre);

        Autor autor = autorRepositorio.buscarPorNombre(nombre);

        if (autor == null) {
            throw new ErrorServicio("No se encontro ningun Autor con ese nombre");
        }

        if (nombreNuevo == null || nombreNuevo.isEmpty()) {
            throw new ErrorServicio("El nombre nuevo del Autor esta vacio");
        }

        autor.setNombre(nombreNuevo);

        autorRepositorio.save(autor);

    }

    private void BajaAutor(String nombre) throws ErrorServicio {

        validar(nombre);

        Autor autor = autorRepositorio.buscarPorNombre(nombre);

        if (autor == null) {
            throw new ErrorServicio("No se encontro ningun Autor con ese nombre");
        }

        autor.setBaja(new Date());

        autorRepositorio.save(autor);

    }

    private void AltaAutor(String nombre) throws ErrorServicio {

        validar(nombre);

        Autor autor = autorRepositorio.buscarPorNombre(nombre);

        if (autor == null) {
            throw new ErrorServicio("No se encontro ningun Autor con ese nombre");
        }

        autor.setBaja(null);

        autorRepositorio.save(autor);

    }

    private void validar(String nombre) throws ErrorServicio {

        if (nombre == null || nombre.isEmpty()) {
            throw new ErrorServicio("El nombre del Autor esta vacio");
        }

    }

}
