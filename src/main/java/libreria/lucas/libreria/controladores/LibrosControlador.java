package libreria.lucas.libreria.controladores;

import libreria.lucas.libreria.entidades.Autor;
import libreria.lucas.libreria.entidades.Editorial;
import libreria.lucas.libreria.errores.ErrorServicio;
import libreria.lucas.libreria.servicios.AutorServicio;
import libreria.lucas.libreria.servicios.EditorialServicio;
import libreria.lucas.libreria.servicios.LibroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/libros")
public class LibrosControlador {

    
    @Autowired
    private LibroServicio libroservicio; 
    
    @Autowired
    private AutorServicio autorservicio;
    
    @Autowired
    private EditorialServicio editorialservicio;
    
    @GetMapping("/agregarlibro")
    public String agregarlibro(ModelMap modelo, ModelMap modelo2) {
        
        modelo.put("autores", autorservicio.listarAutores());
        
        modelo2.put("editoriales", editorialservicio.listarEditoriales());
        
        return "agregarlibro.html";
    }
    
    @GetMapping("/buscarporautor")
    public String buscarporautor() {
        return "buscarporautor.html";
    }
    
    @PostMapping("/guardarLibro")
    public String guardarAutor(ModelMap modelo, @RequestParam String isbn, @RequestParam String titulo, @RequestParam Integer anio, @RequestParam Integer ejemplares, @RequestParam Integer prestados, @RequestParam Integer idautor, @RequestParam Integer ideditorial) {
        
        //Agarro el ID y busco el autor
        Autor autor = autorservicio.buscarPorId(idautor);
        
        //Agarro el Id y busco la editorial
        Editorial editorial = editorialservicio.buscarPorId(ideditorial);
        
        //Recibo el ISBN y lo parseo a Long
        try {
            
            Long isbnLong = Long.parseLong(isbn);
            libroservicio.registrarLibro(isbnLong, titulo, anio, ejemplares, prestados, autor, editorial);
            
            modelo.put("exito","Libro cargado exitosamente");
            
        } catch(ErrorServicio er) {
            modelo.put("error",er.getMessage());
            return "agregarlibro.html";
        }
        
        return "agregarlibro.html";
    }
    
    @GetMapping("/listarlibros")
    public String listarlibros(ModelMap modelo){
        
        modelo.put("libros", libroservicio.listarlibros());
        
        return "listalibros.html";
    }
    
    @GetMapping("/listalibrosmodificar")
    public String listarlibrosmodificar(ModelMap modelo){
        
        modelo.put("libros", libroservicio.listarlibros());
        
        return "listalibrosmodificar.html";
    }
    
    @GetMapping("/modificarlibro/{isbn}")
    public String modificarlibro(@PathVariable Long isbn, ModelMap modelo, ModelMap modelo2){
        
        modelo.put("libro", libroservicio.buscarPorId(isbn));
        
        modelo.put("autores", autorservicio.listarAutores());
        
        modelo2.put("editoriales", editorialservicio.listarEditoriales());
        
        return "modificarlibro.html";
    }
    
    @PostMapping("/guardarmodificado")
    public String guardarmodificado(ModelMap modelo, @RequestParam String isbn, @RequestParam String titulo, @RequestParam Integer anio, @RequestParam Integer ejemplares, @RequestParam Integer prestados, @RequestParam Integer idautor, @RequestParam Integer ideditorial){
        
        //Agarro el ID y busco el autor
        Autor autor = autorservicio.buscarPorId(idautor);
        
        //Agarro el Id y busco la editorial
        Editorial editorial = editorialservicio.buscarPorId(ideditorial);
        
        //Recibo el ISBN y lo parseo a Long
        try {
            
            Long isbnLong = Long.parseLong(isbn);
            libroservicio.modificarLibro(isbnLong, titulo, anio, ejemplares, prestados, autor, editorial);
            
            modelo.put("exito","Libro modificado exitosamente");
            
        } catch(ErrorServicio er) {
            modelo.put("error",er.getMessage());
            return "mensajeguardado.html";
        }
        
        return "mensajeguardado.html";
    }

}
