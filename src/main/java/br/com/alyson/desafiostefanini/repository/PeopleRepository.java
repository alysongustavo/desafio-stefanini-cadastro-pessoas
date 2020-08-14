package br.com.alyson.desafiostefanini.repository;

import br.com.alyson.desafiostefanini.model.People;
import br.com.alyson.desafiostefanini.repository.helper.PeopleQueries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PeopleRepository extends JpaRepository<People, Long>, PeopleQueries {

    public Optional<People> findByNameIgnoreCase(String name);

    public Optional<People> findByNameIgnoreCaseOrEmailOrCpf(String name, String email, String cpf);
}
