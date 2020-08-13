package br.com.alyson.desafiostefanini.controller;

import br.com.alyson.desafiostefanini.model.People;
import br.com.alyson.desafiostefanini.service.PeopleService;
import br.com.alyson.desafiostefanini.service.exception.BusinessException;
import br.com.alyson.desafiostefanini.util.ApplicationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "peopleBean")
@RequestScoped
@Component
public class PeopleBean implements Serializable {

    private static final long serialVersionUID = 8864064990188002326L;

    @Autowired
    private PeopleService peopleService;

    private People peopleCadastrar = null;

    private List<String> countries;
    private List<String> cities;

    public PeopleBean(){
        limpar();
    }

    public void inicializar() {
        if (ApplicationUtil.isNotPostback()) {
            carregarCities();
            carregarCountries();
        }
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
        this.peopleCadastrar = new People();
    }

    public void salvar(){

        try{
            peopleService.salvar(this.peopleCadastrar);
            limpar();

            ApplicationUtil.addInfoMessage("Pessoa salva com sucesso");
        }catch (BusinessException exception){
            ApplicationUtil.addErrorMessage(exception.getMessage());
        }

    }

    public People getPeopleCadastrar() {
        return peopleCadastrar;
    }

    public void setPeopleCadastrar(People peopleCadastrar) {
        this.peopleCadastrar = peopleCadastrar;
    }

    public List<String> getCities() {
        return cities;
    }

    public List<String> getCountries() {
        return countries;
    }

}
