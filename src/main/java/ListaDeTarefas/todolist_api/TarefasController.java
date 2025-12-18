package ListaDeTarefas.todolist_api;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController // Diz: "Eu sou um controlador da Web"
@RequestMapping("/tarefas") // Diz: "Respondo quando acessarem /tarefas"
@CrossOrigin(origins = "*") // Libero o acesso
public class TarefasController {

    // Nossa lista agora vive aqui na memória do servidor
    private List<Tarefas> lista = new ArrayList<>();

    // Método GET: Alguém quer VER a lista (Substitui o "exibirTarefas")
    @GetMapping
    public List<Tarefas> listar() {
        return lista; // O Spring transforma isso em JSON automaticamente!
    }

    // Método POST: Alguém quer CRIAR uma tarefa (Substitui o "addTarefas")
    @PostMapping
    public void adicionar(@RequestBody Tarefas tarefa) {
        // @RequestBody pega o JSON que o site enviou e transforma em Java
        lista.add(tarefa);
    }
    // Método POST: Alguém quer Deletar uma tarefa(Substitui o "delTarefas")
    @DeleteMapping("/{id}")
    public void remover(@PathVariable int id) {
        if (id >= 0 && id < lista.size()) {
            lista.remove(id);
        }
    }
}