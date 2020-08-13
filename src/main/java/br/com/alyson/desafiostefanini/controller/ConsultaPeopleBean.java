package br.com.alyson.desafiostefanini.controller;

import br.com.alyson.desafiostefanini.model.People;
import br.com.alyson.desafiostefanini.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "consultaPeopleBean")
@RequestScoped
@Component
public class ConsultaPeopleBean implements Serializable {

    private static final long serialVersionUID = -324720886550372946L;

    @Autowired
    private PeopleService peopleService;

    private List<People> pessoas = new ArrayList<>();

    @PostConstruct
    public void init(){
        this.pessoas = peopleService.findAll();
    }

    public List<People> getPessoas() {
        return pessoas;
    }

}
