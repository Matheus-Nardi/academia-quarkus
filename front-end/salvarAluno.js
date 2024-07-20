const baseUrl = "http://localhost:8080/alunos";

function criarAluno() {
  const nome = document.getElementById("nome").value;
  const idade = document.getElementById("idade").value;
  const peso = document.getElementById("peso").value;
  const altura = document.getElementById("altura").value;
  const email = document.getElementById("email").value;
  const telefone = document.getElementById("telefone").value;
  const aluno = {
    nome: nome,
    idade: idade,
    peso: peso,
    altura: altura,
    email: email,
    telefone: telefone,
  };

  return aluno;
}



function salvarAluno() {
  const aluno = criarAluno();
  fetch(baseUrl, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(aluno),
  })
    .then((response) => response.json())
    .then((data) => {
      console.log("Sucesso:", data);
      alert("O aluno foi salvo com sucesso!");
    })
    .catch((error) => {
      console.error("Erro:", error);
      alert("Erro ao salvar o aluno!")
    });
}
