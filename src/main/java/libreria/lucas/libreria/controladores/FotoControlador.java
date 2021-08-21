package libreria.lucas.libreria.controladores;

import java.util.logging.Level;
import java.util.logging.Logger;
import libreria.lucas.libreria.entidades.Libro;
import libreria.lucas.libreria.errores.ErrorServicio;
import libreria.lucas.libreria.servicios.LibroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/foto")
public class FotoControlador {

    @Autowired
    private LibroServicio libroservicio;

    @GetMapping("/fotoportada/{isbn}")
    public ResponseEntity<byte[]> fotoPortada(@PathVariable Long isbn) throws ErrorServicio {
        try {

            Libro libro = libroservicio.buscarPorId(isbn);

            if (libro.getFoto() == null) {
                throw new ErrorServicio("El libro no tiene foto");
            }

            byte[] foto = libro.getFoto().getContenido();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG);

            return new ResponseEntity<>(foto, headers, HttpStatus.OK);
        } catch (ErrorServicio er) {
            Logger.getLogger(FotoControlador.class.getName()).log(Level.SEVERE, null, er);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}