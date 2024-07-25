
# Academia Quarkus 💪🏼

Um projeto que busca desenvolver uma API de academia, na qual é possível realizar um CRUD de Aluno, Instrutor e Treino.

O objetivo é entender melhor os métodos HTTP e como funciona parte do backend.

## Rodando Localmente 🛠️

Para instalar o projeto, siga os passos abaixo:

### Pré-requisitos

- Java JDK (versão 21 ou superior)
- Maven (versão 3.9.7 ou superior)

### Passos

1. Clone o repositório:

   ```sh
   git clone https://github.com/Matheus-Nardi/academia-quarkus
   ```

2. Entre no diretório do repositório:

   ```sh
   cd academia-quarkus
   ```

3. Baixe as dependências:

   ```sh
   mvn clean install
   ```

4. Rode a aplicação localmente:

   ```sh
   ./mvnw compile quarkus:dev
   ```

Agora você pode acessar as rotas. Exemplo:

    http://localhost:8080/alunos

## Stack Utilizada 🖥️

**Back-end:** Java, Quarkus, Maven

**Banco de Dados:** PostgreSQL, H2

**Testes das Rotas da API:** Insomnia

## Estrutura de Pastas 📂 

```
/src                     # Código fonte principal da aplicação
    /controller          # Controle das rotas HTTP
    /dto                 # Responsável por modelar Responses e Requests
    /model               # Responsável por modelar as entidades
    /repository          # Responsável pelo acesso ao banco de dados
    /service             # Responsável pelo intermédio entre repository e controller
    /utils               # Classes e métodos utilitários

/test                    # Testes automatizados
```

## Futuras Melhorias 🚀

⬜ Adicionar mais testes unitários

⬜ Documentação com Swagger

⬜ Autenticação e Segurança

