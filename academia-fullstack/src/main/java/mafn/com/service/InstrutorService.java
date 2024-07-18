package mafn.com.service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import mafn.com.dto.CriarInstrutorResquest;
import mafn.com.model.Instrutor;
import mafn.com.repository.InstrutorRepository;

@ApplicationScoped
@Log4j2
public class InstrutorService {

    private InstrutorRepository repository;

    @Inject
    public InstrutorService(InstrutorRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Instrutor criarInstrutor(CriarInstrutorResquest instrutorResquest){
        Instrutor instrutor =  Instrutor.builder()
                .nome(instrutorResquest.getNome())
                .especialidade(instrutorResquest.getEspecialidade())
                .email(instrutorResquest.getEmail())
                .telefone(instrutorResquest.getTelefone())
                .build();

            repository.persist(instrutor);
            log.info("O instrutor '{}' foi persistido com sucesso!" , instrutorResquest.getNome());

        return instrutor;
    }

    public List<Instrutor> listarInstrutores(){
        log.info("Obtendo todos os instrutores");
        return repository.findAll().list();
    }

    public List<Instrutor> listarInstrutoresPorEspecialidade(String especialidade){
        log.info("Obtendo os instrutores pela especialidade '{}' " , especialidade);
        return repository.listarInsturtorPorEspecialidade(especialidade);
    }

    @Transactional
    public boolean atualizarInstrutor(Long id , CriarInstrutorResquest instrutorUpdate){
        Instrutor instrutorFromDb = repository.findById(id);
        if(instrutorFromDb != null){
            instrutorFromDb.setNome(instrutorUpdate.getNome());
            instrutorFromDb.setEspecialidade(instrutorUpdate.getEspecialidade());
            instrutorFromDb.setEmail(instrutorUpdate.getEmail());
            instrutorFromDb.setTelefone(instrutorUpdate.getTelefone());
            log.info("O instrutor '{}' foi atualizado com sucesso!" , instrutorUpdate.getNome());
            return true;
        }

        log.info("O instrutor de id '{}' não existe!", id);
        return false;

    }

    @Transactional
    public boolean deletarInstrutor(Long id){
        Instrutor instrutorFromDb = repository.findById(id);
        if(instrutorFromDb != null){
            repository.deleteById(id);
            log.info("Instrutor de id '{}' deletado com sucesso!" ,id);
            return true;
        }

        log.info("O instrutor de id '{}' não existe!", id);
        return false;
    }



    
    
}
