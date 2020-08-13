package br.com.alyson.desafiostefanini.controller;

import br.com.alyson.desafiostefanini.model.Role;
import br.com.alyson.desafiostefanini.service.RoleService;
import br.com.alyson.desafiostefanini.util.ApplicationExceptionHandler;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "roleBean")
@RequestScoped
@Component
public class RoleBean implements Serializable {

    private static Logger LOG = LoggerFactory.getLogger(ApplicationExceptionHandler.class);

    private static final long serialVersionUID = 1992100705234801866L;

    @Autowired
    @Getter
    private RoleService roleService;

    private List<Role> roles = new ArrayList<>();

    @PostConstruct
    public void init(){
        roles = this.roleService.findAll();

        LOG.debug(roles.toString());

    }

    public List<Role> getRoles() {
        return roles;
    }
}
