package mafn.com.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import mafn.com.model.Treino;

@ApplicationScoped
public class TreinoRepository implements PanacheRepository<Treino> {

}
