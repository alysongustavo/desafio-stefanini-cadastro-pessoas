package br.com.alyson.desafiostefanini.controller;

import br.com.alyson.desafiostefanini.model.People;
import br.com.alyson.desafiostefanini.service.PeopleService;
import br.com.alyson.desafiostefanini.service.exception.BusinessException;
import br.com.alyson.desafiostefanini.util.ApplicationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "peopleBean")
@ViewScoped
@Component
public class PeopleBean implements Serializable {

    private static final long serialVersionUID = 8864064990188002326L;

    @Autowired
    private PeopleService peopleService;

    private People people;

    private List<String> countries;
    private List<String> cities;

    public PeopleBean(){
        limpar();
    }

    public void inicializar() {
        limpar();

        carregarCities();
        carregarCountries();
    }

    public void carregar() {
        if (this.people == null) {
            limpar();
        }

        carregarCities();
        carregarCountries();
    }

    public void carregarCities() {
        cities = new ArrayList<>();

        cities.add("João Pessoa");
        cities.add("Recife");
        cities.add("São Paulo");
    }

    public void carregarCountries() {
        countries = new ArrayList<>();

        countries.add("Brasil");
        countries.add("Estados Unidos");
        countries.add("Argentina");
    }

    private void limpar(){
        this.people = new People();
    }

    public void salvar(){

        try{
            this.people = peopleService.save(this.people);
            limpar();

            ApplicationUtil.addInfoMessage("Pessoa salva com sucesso");
        }catch (BusinessException exception){
            ApplicationUtil.addErrorMessage(exception.getMessage());
        }

    }

    public List<String> getCities() {
        return cities;
    }

    public List<String> getCountries() {
        return countries;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }
}
