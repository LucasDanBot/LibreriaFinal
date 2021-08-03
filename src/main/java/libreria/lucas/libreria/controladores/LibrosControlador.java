package libreria.lucas.libreria.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/libros")
public class LibrosControlador {

    @GetMapping("/agregarlibro")
    public String agregarlibro() {
        return "agregarlibro.html";
    }
    
    @GetMapping("/buscarporautor")
    public String buscarporautor() {
        return "buscarporautor.html";
    }
    
    
    @PostMapping("/guardarLibro")
    public String guardarAutor(@RequestParam String isbn, @RequestParam String titulo, @RequestParam String anio, @RequestParam String ejemplares, @RequestParam String prestados, @RequestParam String autor, @RequestParam String editorial) {
        System.out.println("ISBN: " + isbn);
        System.out.println("Titulo: " + titulo);
        System.out.println("Año: " + anio);
        System.out.println("Ejemplares: " + ejemplares);
        System.out.println("Prestados: " + prestados);
        System.out.println("Autor: " + autor);
        System.out.println("Editorial: " + editorial);
        return "libros.html";
    }

}
