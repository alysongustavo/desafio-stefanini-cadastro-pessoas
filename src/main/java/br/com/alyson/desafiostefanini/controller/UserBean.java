package br.com.alyson.desafiostefanini.controller;

import br.com.alyson.desafiostefanini.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;

@ManagedBean(name = "userBean")
@RequestScoped
public class UserBean implements Serializable {

    private static final long serialVersionUID = 1003758470882075226L;

}
