package br.com.alyson.desafiostefanini.service;

import br.com.alyson.desafiostefanini.repository.filter.PeopleFilter;
import br.com.alyson.desafiostefanini.model.People;
import br.com.alyson.desafiostefanini.repository.PeopleRepository;
import br.com.alyson.desafiostefanini.service.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import java.util.Date;

@Service
public class PeopleService implements Serializable {

    private static final long serialVersionUID = 7260432110926832960L;

    @Autowired
    private PeopleRepository peopleRepository;

    @Transactional
    public People save(People people) throws BusinessException{

        Optional<People> peopleExist = peopleRepository.findByNameIgnoreCaseOrEmailOrCpf(people.getName(), people.getEmail(), people.getCpf());

        if(peopleExist.isPresent()){
            throw new BusinessException("Já existe uma pessoa com os dados informado.");
        }

        if(people.getId() != null){
            people.setDateUpdated(people.getDateCreated());
        }else{
            people.setDateCreated(new Date());
            people.setDateUpdated(new Date());
        }

        return peopleRepository.save(people);


    }

    public List<People> findAll(){
        return peopleRepository.findAll();
    }

    public List<People> filter(PeopleFilter peopleFilter){
        List<People> listPeople = peopleRepository.filtrar(peopleFilter);

        return listPeople;
    }

    @Transactional
    public void delete(People people){
        peopleRepository.delete(people);
    }

    public People findById(Long id){

        Optional<People> peopleExist = peopleRepository.findById(id);

        if(!peopleExist.isPresent()){
            throw new BusinessException("Já existe uma pessoa com o nome informado.");
        }

        return  peopleExist.get();

    }

    public People findByNameIgnoreCase(String name){
        return peopleRepository.findByNameIgnoreCase(name).get();
    }


}
