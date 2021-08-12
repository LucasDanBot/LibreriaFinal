package libreria.lucas.libreria.controladores;

import libreria.lucas.libreria.errores.ErrorServicio;
import libreria.lucas.libreria.servicios.AutorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/autores")
public class AutorControlador {
    
    
    @Autowired
    private AutorServicio autorservicio;
    
    @GetMapping("/agregarautor")
    public String agregarautor(){
        return "agregarautor.html";
    }
    
    @PostMapping("/guardarautor")
    public String guardarAutor(ModelMap modelo, String nombre) {
        
        try{
            autorservicio.registrarAutor(nombre);
        } catch (ErrorServicio er) {
            modelo.put("error",er.getMessage());
            return "agregarautor.html";
        }
        modelo.put("exito", "Autor cargado con exito!");
        return "agregarautor.html";
    }
    
    @GetMapping("/listarautores")
    public String listarautores(){
        
        
        
        return "listaautores.html";
    }
    
}
