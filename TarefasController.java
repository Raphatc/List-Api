package ListaDeTarefas.todolist_api;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController 
@RequestMapping("/tarefas") 
@CrossOrigin(origins = "*") 
public class TarefasController {

    private List<Tarefas> lista = new ArrayList<>();

    @GetMapping
    public List<Tarefas> listar() {
        return lista; 
    }
    @PostMapping
    public void adicionar(@RequestBody Tarefas tarefa) {  
        lista.add(tarefa);
    }
    @DeleteMapping("/{id}")
    public void remover(@PathVariable int id) {
        if (id >= 0 && id < lista.size()) {
            lista.remove(id);
        }
    }
}
