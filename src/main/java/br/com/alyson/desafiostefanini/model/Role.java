package br.com.alyson.desafiostefanini.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Role {

    @Id
    @Getter @Setter
    @GeneratedValue(strategy= GenerationType.AUTO, generator="my_role_seq_gen")
    @SequenceGenerator(name="my_role_seq_gen", sequenceName="SEQ_ROLE_ID")
    private Long id;

    @Getter @Setter
    @NotBlank
    @Size(max = 100)
    private String name;
}
