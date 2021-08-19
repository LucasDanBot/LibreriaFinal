package libreria.lucas.libreria.servicios;

import javax.transaction.Transactional;
import libreria.lucas.libreria.entidades.Foto;
import libreria.lucas.libreria.errores.ErrorServicio;
import libreria.lucas.libreria.repositorios.FotoPortadaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FotoPortadaServicio {

    @Autowired
    private FotoPortadaRepositorio fotoportadarepositorio;

    @Transactional
    public Foto guardar(MultipartFile archivo) throws ErrorServicio {

        if (archivo != null) {

            try {
                Foto foto = new Foto();
                foto.setMime(archivo.getContentType());
                foto.setNombre(archivo.getName());
                foto.setContenido(archivo.getBytes());

                return fotoportadarepositorio.save(foto);

            } catch (Exception e) {
                throw new ErrorServicio("No se pudo leer el archivo que intenta cargar");
            }
        }
        
        return null;

    }
    
    @Transactional
    public Foto modificarfoto(MultipartFile archivo, Integer id) throws ErrorServicio {
        
        if (archivo != null) {

            try {
                Foto foto = new Foto();
                
                foto.setId(id);
                
                foto.setMime(archivo.getContentType());
                foto.setNombre(archivo.getName());
                foto.setContenido(archivo.getBytes());

                return fotoportadarepositorio.save(foto);

            } catch (Exception e) {
                throw new ErrorServicio("No se pudo leer el archivo que intenta cargar");
            }
        }
        
        return null;
        
        
        
    }

}
