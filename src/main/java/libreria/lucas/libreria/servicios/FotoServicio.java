package libreria.lucas.libreria.servicios;

import java.util.Optional;
import libreria.lucas.libreria.entidades.Foto;
import libreria.lucas.libreria.errores.ErrorServicio;
import libreria.lucas.libreria.repositorios.FotoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class FotoServicio {
    
    @Autowired
    private FotoRepositorio fotoRepositorio;
    
    private Foto guardar(MultipartFile archivo) throws ErrorServicio {
        
        if(archivo != null){
            
            try{
                Foto foto = new Foto();
                foto.setMime(archivo.getContentType());
                foto.setNombre(archivo.getName());
                foto.setContenido(archivo.getBytes());
                
                return fotoRepositorio.save(foto);
                 
            } catch(Exception e) {
                System.err.println(e.getMessage());
            }
             
        }
        return null;
    }
    
    
    private Foto actualizar(Integer idFoto, MultipartFile archivo) throws ErrorServicio {
        
        if(archivo != null){
            
            try{
                
                Foto foto = new Foto();
                
                if (idFoto != null) {
                    Optional<Foto> respuesta = fotoRepositorio.findById(idFoto);
                    if(respuesta.isPresent()){
                        foto = respuesta.get();  //porque no funciona el foto = respuesta? que guarda en realidad respuesta?
                    }
                }
                
                foto.setMime(archivo.getContentType());
                foto.setNombre(archivo.getName());
                foto.setContenido(archivo.getBytes());
                
                return fotoRepositorio.save(foto);
                 
            } catch(Exception e) {
                System.err.println(e.getMessage());
            }
             
        }
        return null;  
    }
    
    
}
