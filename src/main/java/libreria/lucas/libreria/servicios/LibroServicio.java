package libreria.lucas.libreria.servicios;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import libreria.lucas.libreria.entidades.Autor;
import libreria.lucas.libreria.entidades.Editorial;
import libreria.lucas.libreria.entidades.Libro;
import libreria.lucas.libreria.errores.ErrorServicio;
import libreria.lucas.libreria.repositorios.LibroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class LibroServicio {
    
    @Autowired
    private LibroRepositorio libroRepositorio;
    
    public void registrarLibro (Long isbn, String titulo, Integer anio, Integer ejemplares, Integer prestados, Autor autor, Editorial editorial) throws ErrorServicio {
        
        if (isbn == null) {
            throw new ErrorServicio("El ISBN no puede estar vacio");
        }
        
        // Verifico que no existe ya un Libro con ese ISBN en la base de datos.
        Optional<Libro> L = libroRepositorio.findById(isbn);
            
        if(L.isPresent()) {
            throw new ErrorServicio("El ISBN ingresado ya existe");
        }
        
        if (titulo == null || titulo.isEmpty()) {
            throw new ErrorServicio("El Titulo no puede estar vacio");
        }
        
        if (anio == null) {
            throw new ErrorServicio("El anio no puede estar vacio");
        }
        
        if (ejemplares == null) {
            throw new ErrorServicio("Tiene que ingresar cuanto ejemplares llegaron");
        }
        
        if (prestados == null || prestados > ejemplares) {
            throw new ErrorServicio("El numero de ejemplares prestados no puede estar vacio o ser mayor que el numero de ejemplares");
        }
        
        if (autor == null) {
            throw new ErrorServicio("Debe seleccionar un autor");
        }
        
        if (autor == null) {
            throw new ErrorServicio("Debe seleccionar un autor");
        }
        
        Libro libro = new Libro();
        
        libro.setIsbn(isbn);
        libro.setTitulo(titulo);
        libro.setAnio(anio);
        libro.setEjemplares(ejemplares);
        libro.setPrestados(prestados);
        libro.setAlta(new Date());
        libro.setAutor(autor);
        libro.setEditorial(editorial);
        
        libroRepositorio.save(libro);
        
    }
    
    public List<Libro> listarlibros () {
        
        List<Libro> listalibros = libroRepositorio.findAll();
        
        // Sort.by("Titulo")
        
        return listalibros;
        
    }
    
    public Libro buscarPorId (Long id) {
        
        Optional<Libro> libro1 = libroRepositorio.findById(id);

        Libro libro = libro1.get();

        return libro;
    }
    
    
    
    
    
}
