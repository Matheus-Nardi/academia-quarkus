Você foi contratado para desenvolver uma API REST para gerenciar uma academia de ginástica. A API deve permitir o gerenciamento de alunos, instrutores, treinos e avaliações físicas.

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
4. **Gerenciamento de Avaliações Físicas**
    - Cadastro de avaliações físicas com informações: aluno, data da avaliação, peso, altura, percentual de gordura e observações.
    - Atualização das informações das avaliações físicas.
    - Remoção de avaliações físicas.
    - Listagem de todas as avaliações físicas.
    - Busca de avaliações físicas por aluno.

### Regras de Negócio

1. **Cadastro de Alunos**
    - Todos os campos são obrigatórios.
    - O e-mail deve ser único para cada aluno.
2. **Cadastro de Instrutores**
    - Todos os campos são obrigatórios.
    - O e-mail deve ser único para cada instrutor.
3. **Cadastro de Treinos**
    - O nome do treino deve ser único.
4. **Cadastro de Avaliações Físicas**
    - Uma avaliação física deve estar vinculada a um aluno existente.
    - A data da avaliação não pode ser no futuro.

### Estrutura do Projeto

1. **Entidades**
    - `Aluno`
    - `Instrutor`
    - `Treino`
    - `AvaliacaoFisica`
2. **Recursos**
    - `AlunoResource`
    - `InstrutorResource`
    - `TreinoResource`
    - `AvaliacaoFisicaResource`
3. **Serviços**
    - `AlunoService`
    - `InstrutorService`
    - `TreinoService`
    - `AvaliacaoFisicaService`
4. **Repositórios**
    - `AlunoRepository`
    - `InstrutorRepository`
    - `TreinoRepository`
    - `AvaliacaoFisicaRepository`

### Endpoints

1. **AlunoResource**
    - `POST /alunos`: Cadastro de alunos.
    - `PUT /alunos/{id}`: Atualização de informações do aluno.
    - `DELETE /alunos/{id}`: Remoção de aluno.
    - `GET /alunos`: Listagem de todos os alunos.
    - `GET /alunos/{nome}`: Busca de alunos por nome.
2. **InstrutorResource**
    - `POST /instrutores`: Cadastro de instrutores.
    - `PUT /instrutores/{id}`: Atualização de informações do instrutor.
    - `DELETE /instrutores/{id}`: Remoção de instrutor.
    - `GET /instrutores`: Listagem de todos os instrutores.
    - `GET /instrutores/{nome}`: Busca de instrutores por nome.
3. **TreinoResource**
    - `POST /treinos`: Cadastro de treinos.
    - `PUT /treinos/{id}`: Atualização de informações do treino.
    - `DELETE /treinos/{id}`: Remoção de treino.
    - `GET /treinos`: Listagem de todos os treinos.
    - `GET /treinos/{nome}`: Busca de treinos por nome.
4. **AvaliacaoFisicaResource**
    - `POST /avaliacoes`: Cadastro de avaliações físicas.
    - `PUT /avaliacoes/{id}`: Atualização de informações da avaliação física.
    - `DELETE /avaliacoes/{id}`: Remoção de avaliação física.
    - `GET /avaliacoes`: Listagem de todas as avaliações físicas.
    - `GET /avaliacoes/{aluno}`: Busca de avaliações físicas por aluno.
