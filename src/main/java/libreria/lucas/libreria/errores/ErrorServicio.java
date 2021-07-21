package libreria.lucas.libreria.errores;

public class ErrorServicio extends Exception{
    
    public ErrorServicio(String msj) {
        
        // Le pasamos a la super clase el msj...
        super(msj);
        
    }
     
}
