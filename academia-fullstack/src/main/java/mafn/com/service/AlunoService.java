package mafn.com.service;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import mafn.com.dto.CriarAlunoRequest;
import mafn.com.model.Aluno;
import mafn.com.repository.AlunoRepository;
import mafn.com.utils.exepctions.UniqueEmaillExcpetion;

@ApplicationScoped
@Log4j2
public class AlunoService {

    private AlunoRepository repository;
    
    @Inject
    public AlunoService(AlunoRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Aluno criarAluno( CriarAlunoRequest alunoRequest) {
        Aluno aluno = Aluno.builder()
                .nome(alunoRequest.getNome())
                .idade(alunoRequest.getIdade())
                .peso(alunoRequest.getPeso())
                .altura(alunoRequest.getAltura())
                .email(alunoRequest.getEmail())
                .telefone(alunoRequest.getTelefone())
                .build();
        try{
            repository.persist(aluno);
            log.info("O aluno {} foi persistido com sucesso!", aluno.getNome());
            return aluno;
        }catch(ConstraintViolationException e){
            throw new UniqueEmaillExcpetion("O email já está em uso!");
        }
    }

    public List<Aluno> listarAlunos() {
        log.info("Retornando todos os alunos");
        return repository.findAll().list();
    }

    public List<Aluno> listarAlunosPorNome(String nome) {
        log.info("Retornando os alunos que contenham no nome '{}'", nome);
        return repository.listarAlunosPorNome(nome);
    }

    public boolean atualizarAluno(Long id , CriarAlunoRequest alunoRequestUpdate){
        Aluno alunoFromDB = repository.findById(id);

        if(alunoFromDB != null){
            alunoFromDB.setNome(alunoRequestUpdate.getNome());
            alunoFromDB.setIdade(alunoRequestUpdate.getIdade());
            alunoFromDB.setPeso(alunoRequestUpdate.getPeso());
            alunoFromDB.setAltura(alunoRequestUpdate.getAltura());
            alunoFromDB.setEmail(alunoRequestUpdate.getEmail());
            alunoFromDB.setTelefone(alunoRequestUpdate.getTelefone());
            log.info("Aluno de id '{}' atualizado com sucesso!" ,id);
            return true;
        }

        log.info("O aluno de id '{}'' não existe" , id);
        return false;
    }

    public boolean deletarAluno(Long id){
        if(repository.findById(id) != null){
            repository.deleteById(id);
            log.info("Aluno de id '{}' deletado com sucessos!", id);
            return true;
        }

        log.info("O aluno de id '{}'' não existe" , id);
        return false;
    }
}
