package mx.com.gm.web;


import lombok.extern.slf4j.Slf4j;
import mx.com.gm.domain.Persona;
import mx.com.gm.servicio.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@Slf4j
public class ControladorInicio {

    @Autowired
    //private PersonaDao personaDao; en lugar de injectar un objeto de tipo personaDao que es la capa de datos
    private PersonaService personaService;//ahora lo que injectaremos sera nuestra capa de servicio, nuestra capa logica
    @GetMapping("/")
    public String inicio(Model model){
        var personas = personaService.listarPersonas();

        log.info("Ejecutando el controlador Spring MVC");
       model.addAttribute("personas", personas);
        return "index";
    }
    @GetMapping("/agregar")
    public String agregar(Persona persona){
        return "modificar";
    }

    @PostMapping("/guardar")
    public String guardar(Persona persona){
        personaService.guardar(persona);
        return "redirect:/";
    }

    @GetMapping("/editar/{idPersona}")
    public String editar(Persona persona, Model model){
        persona = personaService.encontrarPersona(persona);
        model.addAttribute("persona" ,persona);
        return "modificar";
    }

    @GetMapping("/eliminar")
    public String eliminar(Persona persona){
    personaService.eliminar(persona);
    return "redirect:/";
    }
}

