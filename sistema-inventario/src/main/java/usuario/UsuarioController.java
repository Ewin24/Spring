package usuario;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ch.qos.logback.core.model.Model;

@Controller
public class UsuarioController {
    @GetMapping("/usuario")
    public String listarUsuarios(Model model) {
        return "usuario"; // Devuelve el nombre de la vista, por ejemplo "usuarios.html"
    }
}
