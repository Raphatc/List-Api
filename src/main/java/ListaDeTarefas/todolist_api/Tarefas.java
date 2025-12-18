package ListaDeTarefas.todolist_api;

public class Tarefas {
    private String nomeTarefas;
    private boolean estado;

    // O Spring precisa de um construtor vazio
    public Tarefas() {}

    public Tarefas(String nomeTarefas) {
        this.nomeTarefas = nomeTarefas;
        this.estado = false;
    }

    // Getters e Setters são OBRIGATÓRIOS para o JSON funcionar
    public String getNome() { return nomeTarefas; }
    public void setNome(String nomeTarefas) { this.nomeTarefas = nomeTarefas; }
    public boolean getEstado() { return estado; }
    public void setEstado(boolean estado) { this.estado = estado; }
}
