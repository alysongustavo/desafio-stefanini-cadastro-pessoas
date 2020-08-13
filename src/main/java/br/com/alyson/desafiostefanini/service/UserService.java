package br.com.alyson.desafiostefanini.service;

import br.com.alyson.desafiostefanini.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class UserService implements Serializable {

    private static final long serialVersionUID = 2441327132706237044L;

    @Autowired
    private UserRepository userRepository;
}
