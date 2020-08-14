package br.com.alyson.desafiostefanini.repository.filter;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class PeopleFilter implements Serializable {

    private static final long serialVersionUID = 8169487273701710708L;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String cpf;

    @Getter
    @Setter
    private String sex;

    @Getter
    @Setter
    private String naturalness;


}
