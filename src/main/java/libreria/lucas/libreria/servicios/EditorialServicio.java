package libreria.lucas.libreria.servicios;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import libreria.lucas.libreria.entidades.Editorial;
import libreria.lucas.libreria.errores.ErrorServicio;
import libreria.lucas.libreria.repositorios.EditorialRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EditorialServicio {
    
    @Autowired
    private EditorialRepositorio editorialrespositorio;
    
    @Transactional
    public void registrarEditorial (String nombre) throws ErrorServicio{
        
        validar(nombre);
        
        Editorial editorial = editorialrespositorio.buscarPorNombre(nombre);
        
        if (editorial == null) {
            Editorial edi1 = new Editorial();
            edi1.setNombre(nombre);
            edi1.setAlta(new Date());
            editorialrespositorio.save(edi1);
        } else {
            throw new ErrorServicio("Ya existe una editorial con ese nombre");
        }
        
    }
    

    @Transactional
    public void modificarEditorial(String nombre, String nombreNuevo) throws ErrorServicio {

        validar(nombre);

        Editorial editorial = editorialrespositorio.buscarPorNombre(nombre);

        if (editorial == null) {
            throw new ErrorServicio("No se encontro ninguna Editorial con ese nombre");
        }

        if (nombreNuevo == null || nombreNuevo.isEmpty()) {
            throw new ErrorServicio("El nombre nuevo de la Editorial esta vacio");
        }

        editorial.setNombre(nombreNuevo);

        editorialrespositorio.save(editorial);

    }

    @Transactional
    private void BajaEditorial(String nombre) throws ErrorServicio {

        validar(nombre);

        Editorial editorial = editorialrespositorio.buscarPorNombre(nombre);

        if (editorial == null) {
            throw new ErrorServicio("No se encontro ninguna Editorial con ese nombre");
        }

        editorial.setBaja(new Date());

        editorialrespositorio.save(editorial);

    }

    @Transactional
    private void AltaEditorial(String nombre) throws ErrorServicio {

        validar(nombre);

        Editorial editorial = editorialrespositorio.buscarPorNombre(nombre);

        if (editorial == null) {
            throw new ErrorServicio("No se encontro ninguna Editorial con ese nombre");
        }

        editorial.setBaja(null);

        editorialrespositorio.save(editorial);

    }

    
    private void validar(String nombre) throws ErrorServicio {

        if (nombre == null || nombre.isEmpty()) {
            throw new ErrorServicio("El nombre del Autor esta vacio");
        }

    }
    
    
    public List<Editorial> listarEditoriales() {
        
        List<Editorial> editoriales = editorialrespositorio.findAll();
        for (Editorial editoriale : editoriales) {
            System.out.println(editoriale.getNombre());
        }
        return editoriales;
        
    }
    
    
    public Editorial buscarPorId (Integer id) {
        
        Optional<Editorial> editorial1 = editorialrespositorio.findById(id);
        
        Editorial editorial = editorial1.get();
        
        return editorial;
    }
    
    
}
