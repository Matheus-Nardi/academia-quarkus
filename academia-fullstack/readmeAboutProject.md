Você foi contratado para desenvolver uma API REST para gerenciar uma academia . A API deve permitir o gerenciamento de alunos, instrutores e treinos.

1. **Gerenciamento de Alunos**
    - Cadastro de alunos com informações: nome, idade, peso, altura, e-mail e telefone.
    - Atualização das informações dos alunos.
    - Remoção de alunos.
    - Listagem de todos os alunos.
    - Busca de alunos por nome.
2. **Gerenciamento de Instrutores**
    - Cadastro de instrutores com informações: nome, especialidade, e-mail e telefone.
    - Atualização das informações dos instrutores.
    - Remoção de instrutores.
    - Listagem de todos os instrutores.
    - Busca de instrutores por nome.
3. **Gerenciamento de Treinos**
    - Cadastro de treinos com informações: nome do treino, descrição, duração e nível de dificuldade.
    - Atualização das informações dos treinos.
    - Remoção de treinos.
    - Listagem de todos os treinos.
    - Busca de treinos por nome.

### Regras de Negócio

1. **Cadastro de Alunos**
    - Todos os campos são obrigatórios.
    - O e-mail deve ser único para cada aluno.
2. **Cadastro de Instrutores**
    - Todos os campos são obrigatórios.
    - O e-mail deve ser único para cada instrutor.
3. **Cadastro de Treinos**
    - O nome do treino deve ser único.

### Estrutura do Projeto


1. **AlunoController**
    - `POST /alunos`: Cadastro de alunos.
    - `PUT /alunos/{id}`: Atualização de informações do aluno.
    - `DELETE /alunos/{id}`: Remoção de aluno.
    - `GET /alunos`: Listagem de todos os alunos.
    - `GET /alunos/{nome}`: Busca de alunos por nome.
2. **InstrutorController**
    - `POST /instrutores`: Cadastro de instrutores.
    - `PUT /instrutores/{id}`: Atualização de informações do instrutor.
    - `DELETE /instrutores/{id}`: Remoção de instrutor.
    - `GET /instrutores`: Listagem de todos os instrutores.
    - `GET /instrutores/{nome}`: Busca de instrutores por nome.
    - `GET /instrutores/filtros`: Listagem de instrutores por queryParam. Exemplo especialidades.
3. **TreinoControleler**
    - `POST /treinos`: Cadastro de treinos.
    - `PUT /treinos/{id}`: Atualização de informações do treino.
    - `DELETE /treinos/{id}`: Remoção de treino.
    - `GET /treinos`: Listagem de todos os treinos.
    - `GET /treinos/filtros`: Listagem de treinos por queryParam. Exemplo data do treino.
