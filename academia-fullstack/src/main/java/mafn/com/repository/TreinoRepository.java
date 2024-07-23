package mafn.com.repository;

import java.time.LocalDate;
import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import mafn.com.model.Treino;

@ApplicationScoped
public class TreinoRepository implements PanacheRepository<Treino> {

    public List<Treino> listarTreinoPorData(LocalDate data){
        return find("DATE(dataHora) = ?1" ,data).list();
    }
    public List<Treino> listarTreinoPorNome(String nome){
        return find("nome like ?1", "%" + nome + "%").list();
    }
}
