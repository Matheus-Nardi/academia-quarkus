package mafn.com.repository;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import mafn.com.dto.TreinoResponse;
import mafn.com.model.Treino;

@ApplicationScoped
public class TreinoRepository implements PanacheRepository<Treino> {

    @PersistenceContext
    private EntityManager entityManager;

    public List<TreinoResponse> findTreinoResponses() {
        String jpql = "SELECT new mafn.com.dto.TreinoResponse(" +
                      "t.nome, a.nome, i.nome, t.dataHora, t.duracao, t.dificuldade) " +
                      "FROM Treino t " +
                      "JOIN t.aluno a " +
                      "JOIN t.instrutor i";
        TypedQuery<TreinoResponse> query = entityManager.createQuery(jpql, TreinoResponse.class);
        return query.getResultList();
    }
}
