package libreria.lucas.libreria.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

public class LibrosControlador {
 
    @Controller
    @RequestMapping("/libros")
    public class PortalControlador {

        @GetMapping("/libros")
        public String libros() {
            return "libros.html";
        }

    }


}
