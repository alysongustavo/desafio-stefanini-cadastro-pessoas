package br.com.alyson.desafiostefanini.service;

import br.com.alyson.desafiostefanini.model.Role;
import br.com.alyson.desafiostefanini.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class RoleService implements Serializable {

    private static final long serialVersionUID = 8313677676082660585L;

    @Autowired
    private RoleRepository roleRepository;

    public List<Role> findAll(){
        return roleRepository.findAll();
    }
}
