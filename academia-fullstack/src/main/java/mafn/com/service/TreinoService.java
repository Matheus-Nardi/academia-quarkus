package mafn.com.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.arjuna.ats.jta.exceptions.RollbackException;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import mafn.com.dto.CriarTreinoRequest;
import mafn.com.dto.TreinoResponse;
import mafn.com.model.Aluno;
import mafn.com.model.Instrutor;
import mafn.com.model.Treino;
import mafn.com.repository.AlunoRepository;
import mafn.com.repository.InstrutorRepository;
import mafn.com.repository.TreinoRepository;

@ApplicationScoped
@Log4j2
public class TreinoService {

    private TreinoRepository repository;
    private InstrutorRepository instrutorRepository;
    private AlunoRepository alunoRepository;

   
    @Inject
    public TreinoService(TreinoRepository repository, InstrutorRepository instrutorRepository,
            AlunoRepository alunoRepository) {
        this.repository = repository;
        this.instrutorRepository = instrutorRepository;
        this.alunoRepository = alunoRepository;
    }

    @Transactional
    public Treino criarTreino(CriarTreinoRequest treinoRequest){

        Instrutor instrutor = instrutorRepository.findById(treinoRequest.getInstrutor());
        Aluno aluno = alunoRepository.findById(treinoRequest.getAluno());
       Treino treino = Treino.builder()
        .nome(treinoRequest.getNome())
        .descricao(treinoRequest.getDescricao())
        .duracao(treinoRequest.getDuracao())
        .dificuldade(treinoRequest.getDificuldade())
        .instrutor(instrutor)
        .aluno(aluno)
        .dataHora(LocalDateTime.now())
        .build();

        try{
            repository.persist(treino);
            log.info("O treino foi persistido com sucesso!");
        }catch(RollbackException e){
            log.info("Houve um erro ao persistir o treino '{}'" , e);
        }
        return treino;
    }

    public List<TreinoResponse> listarTreinos(){
        List<Treino> treinos = repository.findAll().list();
        return treinos.stream()
                        .map(this::toTreinoResponse)
                        .collect(Collectors.toList());
    }

    private TreinoResponse toTreinoResponse(Treino treino){
        return TreinoResponse.builder()
            .nomeTreino(treino.getNome())
            .nomeAluno(treino.getAluno().getNome())
            .nomeInstrutor(treino.getInstrutor().getNome())
            .dataHora(treino.getDataHora())
            .duracao(treino.getDuracao())
            .dificuldade(treino.getDificuldade())
            .descricaoTreino(treino.getDescricao())
            .build();
            
    }

    
}
