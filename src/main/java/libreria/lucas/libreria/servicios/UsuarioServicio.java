package libreria.lucas.libreria.servicios;

import java.util.Date;
import java.util.Optional;
import javax.transaction.Transactional;
import libreria.lucas.libreria.entidades.FotoPerfil;
import libreria.lucas.libreria.entidades.Usuario;
import libreria.lucas.libreria.errores.ErrorServicio;
import libreria.lucas.libreria.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class UsuarioServicio {

    @Autowired
    private UsuarioRepositorio usuariorepositorio;
    
    @Autowired
    private FotoPerfilServicio fotoperfilservicio;

    @Transactional
    public void nuevousuario(Integer dni, String nombre, String apellido, String email, String clave, String clave2, MultipartFile fotoperfil) throws ErrorServicio {

        if (dni == null) {
            throw new ErrorServicio("El DNI no puede estar vacio");
        }
        //Parseo el dni a Long para poder usar el findbyID que solo admite longs
        Long dniLong = Long.valueOf(dni);

        if (nombre == null || nombre.isEmpty()) {
            throw new ErrorServicio("Tiene que ingresar un nombre");
        }

        if (apellido == null || apellido.isEmpty()) {
            throw new ErrorServicio("Tiene que ingresar un apellido");
        }

        if (email == null || email.isEmpty()) {
            throw new ErrorServicio("Tiene que ingresar un email");
        }
        
        
        
        

        if (clave == null || clave.isEmpty()) {
            throw new ErrorServicio("Tiene que ingresar una clave");
        }
        
        
        

        if (clave2 == null || clave2.isEmpty()) {
            throw new ErrorServicio("Tiene que ingresar una clave");
        }
        
        
        

        
        FotoPerfil foto = new FotoPerfil();
        if (fotoperfil != null) {
            foto = fotoperfilservicio.guardar(fotoperfil);
        }

        Usuario usuario = new Usuario();

        usuario.setDni(dni);
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setEmail(email);
        usuario.setClave(clave);
        usuario.setFotoperfil(foto);
        usuario.setAlta(new Date());
        
        System.out.println(usuario.getDni());
        System.out.println(usuario.getNombre());
        System.out.println(usuario.getApellido());
        
        usuariorepositorio.save(usuario);

    }

}
