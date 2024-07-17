package mafn.com.repository;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import mafn.com.model.Aluno;

@ApplicationScoped
public class AlunoRepository implements PanacheRepository<Aluno> {

    public List<Aluno> listarAlunosPorNome(String nome){
      return find("nome like ?1", "%" + nome + "%").list();
    }
}
