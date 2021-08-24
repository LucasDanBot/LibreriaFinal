package libreria.lucas.libreria.servicios;


import java.io.IOException;
import javax.transaction.Transactional;
import libreria.lucas.libreria.entidades.FotoPerfil;
import libreria.lucas.libreria.errores.ErrorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import libreria.lucas.libreria.repositorios.FotoPerfilRepositorio;


@Service
public class FotoPerfilServicio {
    
    @Autowired
    private FotoPerfilRepositorio fotoperfilRepositorio;
    
    
    @Transactional
    public FotoPerfil guardar(MultipartFile fotoperfil) throws ErrorServicio {
        System.out.println("PASO 5");
        if (fotoperfil != null) {
            System.out.println("PASO 6");
            try {
                FotoPerfil foto = new FotoPerfil();
                foto.setMime(fotoperfil.getContentType());
                foto.setNombre(fotoperfil.getName());
                foto.setContenido(fotoperfil.getBytes());
                System.out.println("PASO 7");
                return fotoperfilRepositorio.save(foto);

            } catch (IOException e) {
                throw new ErrorServicio("No se pudo leer el archivo que intenta cargar");
            }
        }
        System.out.println("No entro a nada");
        return null;

    }
    
    @Transactional
    public FotoPerfil modificarfoto(MultipartFile archivo, Integer id) throws ErrorServicio {
        
        if (archivo != null) {

            try {
                FotoPerfil foto = new FotoPerfil();
                
                foto.setId(id);
                
                foto.setMime(archivo.getContentType());
                foto.setNombre(archivo.getName());
                foto.setContenido(archivo.getBytes());

                return fotoperfilRepositorio.save(foto);

            } catch (Exception e) {
                throw new ErrorServicio("No se pudo leer el archivo que intenta cargar");
            }
        }
        
        return null;
    }
    
}
