const API_URL = "http://localhost:8080/tarefas";

window.onload = carregarTarefas;

function carregarTarefas() {
    const lista = document.getElementById("lista-tarefas");
    const msgVazia = document.getElementById("mensagem-vazia");
    lista.innerHTML = ""; 

    fetch(API_URL)
    .then(resposta => resposta.json())
    .then(tarefas => {
        if (tarefas.length === 0) {
            msgVazia.style.display = "block";
        } else {
            msgVazia.style.display = "none";
        }

        tarefas.forEach((tarefa, index) => {
            let item = document.createElement("li");
            
            let texto = document.createElement("span");
            texto.innerText = tarefa.nome;

            let botaoApagar = document.createElement("button");
            botaoApagar.innerText = "🗑️";
            botaoApagar.className = "btn-delete";
            botaoApagar.title = "Apagar tarefa";
            
            botaoApagar.onclick = function() {
                deletarTarefa(index);
            };

            item.appendChild(texto);
            item.appendChild(botaoApagar);
            lista.appendChild(item);
        });
    })
    .catch(erro => console.error(erro));
}

function adicionarTarefa() {
    let inputTarefa = document.getElementById("nova-tarefa");
    let nomeTarefa = inputTarefa.value;

    if (!nomeTarefa) return alert("Escreva algo!");

    fetch(API_URL, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ nome: nomeTarefa }) 
    })
    .then(() => {
        inputTarefa.value = ""; 
        carregarTarefas(); 
    });
}

function deletarTarefa(id) {
    fetch(`${API_URL}/${id}`, {
        method: "DELETE"
    })
    .then(() => {
        carregarTarefas();
    })
    .catch(erro => console.error(erro));
}