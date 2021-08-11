package libreria.lucas.libreria.controladores;

import libreria.lucas.libreria.errores.ErrorServicio;
import libreria.lucas.libreria.servicios.EditorialServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/editoriales")
public class EditorialControlador {

    @Autowired
    private EditorialServicio editorialservicio;

    @GetMapping("/agregareditorial")
    public String agregareditorial() {
        return "agregareditorial.html";
    }

    @PostMapping("/guardareditorial")
    public String guardareditorial(ModelMap modelo, String nombre) {

        try {
            editorialservicio.registrarEditorial(nombre);
        } catch (ErrorServicio er) {
            modelo.put("error", er.getMessage());
            return "/agregareditorial";
        }
        modelo.put("exito", "Editorial cargada con exito!");
        return "/agregareditorial";
    }

}
