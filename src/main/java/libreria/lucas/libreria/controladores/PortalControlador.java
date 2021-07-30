package libreria.lucas.libreria.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/")
public class PortalControlador {
    
    
    @GetMapping("/")
    public String index(){
        return "index.html";
    }
    
    @GetMapping("/libros")
    public String libros(){
        return "libros.html";
    }
    
    
}
