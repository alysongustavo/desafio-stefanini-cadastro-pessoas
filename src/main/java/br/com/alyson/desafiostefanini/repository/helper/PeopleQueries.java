package br.com.alyson.desafiostefanini.repository.helper;

import br.com.alyson.desafiostefanini.repository.filter.PeopleFilter;
import br.com.alyson.desafiostefanini.model.People;

import java.util.List;
import java.util.Optional;

public interface PeopleQueries {

    public List<People> filtrar(PeopleFilter filter);
}
