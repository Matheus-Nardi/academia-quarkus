package mafn.com.repository;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import mafn.com.model.Instrutor;

@ApplicationScoped
public class InstrutorRepository implements PanacheRepository<Instrutor> {


    public List<Instrutor> listarInsturtorPorEspecialidade(String especialidade){
        return find("especialidade like ?1" , "%" + especialidade + "%").list();
    }
}
