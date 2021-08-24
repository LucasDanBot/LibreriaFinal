package libreria.lucas.libreria.controladores;


import libreria.lucas.libreria.errores.ErrorServicio;
import libreria.lucas.libreria.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;



@Controller
@RequestMapping("/usuario")
public class UsuarioControlador {
    
    @Autowired
    private UsuarioServicio usuarioservicio;
    
    @GetMapping("/nuevousuarioform")
    public String nuevousuarioform() {
        
        return "nuevousuarioform.html";
        
    }
    
    @PostMapping("/guardarusuario")
    public String guardarusuario(@RequestParam Integer dni, @RequestParam String nombre, @RequestParam String apellido, @RequestParam String email, @RequestParam String clave, @RequestParam String clave2, MultipartFile fotoperfil) throws ErrorServicio{
        
        try {
        usuarioservicio.nuevousuario(dni, nombre, apellido, email, clave, clave2, fotoperfil);
        } catch (Exception e){
            e.printStackTrace();
        }
        
        return "index.html";
    }
    
    
}
