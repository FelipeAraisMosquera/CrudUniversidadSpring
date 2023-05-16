package mx.com.gm.dao;


import mx.com.gm.domain.Persona;
import org.springframework.data.repository.CrudRepository;

//CrudRepositoryz<(nombre de la entidad o tabla), (tipo de llave primaria)),
public interface PersonaDao extends CrudRepository<Persona, Long> {
// de aqui es de donde salen algunos de los metodos, para generar el crud
    //como el findAll(); etc

}
