package br.com.alyson.desafiostefanini.controller;

import br.com.alyson.desafiostefanini.repository.filter.PeopleFilter;
import br.com.alyson.desafiostefanini.model.People;
import br.com.alyson.desafiostefanini.service.PeopleService;
import br.com.alyson.desafiostefanini.service.exception.BusinessException;
import br.com.alyson.desafiostefanini.util.ApplicationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "consultaPeopleBean")
@ViewScoped
@Component
public class ConsultaPeopleBean implements Serializable {

    private static final long serialVersionUID = -324720886550372946L;

    @Autowired
    private PeopleService peopleService;

    private PeopleFilter peopleFilter;
    private List<People> peoplesFilter;

    private People peopleSelecionado;

    private List<String> countries;
    private List<String> cities;
    private List<String> sexs;

    public ConsultaPeopleBean(){
        peopleFilter = new PeopleFilter();
    }

    public void filter(){
        peoplesFilter = peopleService.filter(peopleFilter);
    }

    public List<People> getPeoplesFilter() {
        return peoplesFilter;
    }

    public PeopleFilter getPeopleFilter() {
        return peopleFilter;
    }

    public void setPeopleFilter(PeopleFilter peopleFilter) {
        this.peopleFilter = peopleFilter;
    }

    public void inicializar() {
        if (ApplicationUtil.isNotPostback()) {
            loaderCities();
            loaderCountries();
            loaderSex();
        }
    }

    public void excluir() {
        try {
            peopleService.delete(peopleSelecionado);
            peoplesFilter.remove(peopleSelecionado);

            ApplicationUtil.addInfoMessage("Pessoa " + peopleSelecionado.getName()
                    + " excluída com sucesso.");
        } catch (BusinessException ne) {
            ApplicationUtil.addErrorMessage(ne.getMessage());
        }
    }

    public void loaderCities() {
        cities = new ArrayList<>();

        cities.add("João Pessoa");
        cities.add("Recife");
        cities.add("São Paulo");
    }

    public void loaderCountries() {
        countries = new ArrayList<>();

        countries.add("Brasil");
        countries.add("Estados Unidos");
        countries.add("Argentina");
    }

    public void loaderSex() {
        sexs = new ArrayList<>();

        sexs.add("Masculino");
        sexs.add("Feminino");
    }

    public List<String> getCities() {
        return cities;
    }

    public List<String> getCountries() {
        return countries;
    }

    public List<String> getSexs() {
        return sexs;
    }

    public People getPeopleSelecionado() {
        return peopleSelecionado;
    }

    public void setPeopleSelecionado(People peopleSelecionado) {
        this.peopleSelecionado = peopleSelecionado;
    }
}
