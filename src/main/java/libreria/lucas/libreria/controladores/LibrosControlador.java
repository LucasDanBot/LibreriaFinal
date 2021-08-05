package libreria.lucas.libreria.controladores;

import libreria.lucas.libreria.errores.ErrorServicio;
import libreria.lucas.libreria.servicios.AutorServicio;
import libreria.lucas.libreria.servicios.LibroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
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
    
    @GetMapping("/agregarlibro")
    public String agregarlibro(ModelMap modelo) {
        
        modelo.put("autores", autorservicio.listarAutores());
        
        return "agregarlibro.html";
    }
    
    @GetMapping("/buscarporautor")
    public String buscarporautor() {
        return "buscarporautor.html";
    }
    
    @PostMapping("/guardarLibro")
    public String guardarAutor(ModelMap modelo, @RequestParam String isbn, @RequestParam String titulo, @RequestParam Integer anio, @RequestParam Integer ejemplares, @RequestParam Integer prestados, @RequestParam Integer idautor, @RequestParam Integer ideditorial) {
        /*
        System.out.println("ISBN: " + isbn);
        System.out.println("Titulo: " + titulo);
        System.out.println("Año: " + anio);
        System.out.println("Ejemplares: " + ejemplares);
        System.out.println("Prestados: " + prestados);
        System.out.println("Autor: " + autor);
        System.out.println("Editorial: " + editorial);
        */
        
        
        /*
        try {
            
            Long isbnLong = Long.parseLong(isbn);
            libroservicio.registrarLibro(isbnLong, titulo, anio, ejemplares, prestados, autor, editorial);
        
        } catch(ErrorServicio er) {
            modelo.put("error",er.getMessage());
            return "/libros/agregarlibro.html";
        }
        */
        return "/index.html";
    }

}
