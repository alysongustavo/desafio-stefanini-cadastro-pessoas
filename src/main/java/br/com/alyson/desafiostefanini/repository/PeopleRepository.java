package br.com.alyson.desafiostefanini.repository;

import br.com.alyson.desafiostefanini.model.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PeopleRepository extends JpaRepository<People, Long> {

    public Optional<People> findByNameIgnoreCase(String name);
}
