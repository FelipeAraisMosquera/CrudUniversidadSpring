package mx.com.gm.servicio;

import mx.com.gm.dao.PersonaDao;
import mx.com.gm.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service//viene y busca el @service en la implemetacion de PersonaService
public class PersonaServiceImpl implements PersonaService{

    //Implementa los metodos que estan definidos en la interfaz
    @Autowired
    private PersonaDao personaDao;//instancia de nuestra clase de tipo personaDao(objeto)

    @Override
    @Transactional(readOnly = true)
    public List<Persona> listarPersonas() {
        return (List<Persona>) personaDao.findAll();//utilizamos la variable de tipo personaDao
    //(List<Persona>): findAll regresa un tipo object, y se le hace un cast para que se pueda convertir a una lista
    }

    @Override
    @Transactional//sin ningun otro parametro
    public void guardar(Persona persona) {
        personaDao.save(persona);
    }

    @Override
    @Transactional
    public void eliminar(Persona persona) {
        personaDao.delete(persona);

    }

    @Override
    @Transactional(readOnly = true)
    public Persona encontrarPersona(Persona persona) {
      return personaDao.findById(persona.getIdPersona()).orElse(null);//si no encuentra el objeto, regresa un null
    }
}
