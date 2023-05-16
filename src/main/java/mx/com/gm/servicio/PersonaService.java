package mx.com.gm.servicio;

import mx.com.gm.domain.Persona;

import java.util.List;

public interface PersonaService {
    public List<Persona> listarPersonas();

    public void guardar(Persona persona);//los void no devuelven ningun valor si no que realizan una accion

    public void eliminar(Persona persona);

    public Persona encontrarPersona(Persona persona);
}
