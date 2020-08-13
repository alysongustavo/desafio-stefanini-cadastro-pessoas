package br.com.alyson.desafiostefanini.service;

import br.com.alyson.desafiostefanini.model.People;
import br.com.alyson.desafiostefanini.repository.PeopleRepository;
import br.com.alyson.desafiostefanini.service.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
public class PeopleService implements Serializable {

    private static final long serialVersionUID = 7260432110926832960L;

    @Autowired
    private PeopleRepository peopleRepository;

    @Transactional
    public People salvar(People people) throws BusinessException{

        Optional<People> peopleExistente = peopleRepository.findByNameIgnoreCase(people.getName());

        if(peopleExistente.isPresent()){
            throw new BusinessException("Já existe uma pessoa com o NOME informado.");
        }


        return peopleRepository.saveAndFlush(people);


    }

    public List<People> findAll(){
        return peopleRepository.findAll();
    }


}
