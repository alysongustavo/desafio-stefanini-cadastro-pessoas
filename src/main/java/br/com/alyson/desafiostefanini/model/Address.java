package br.com.alyson.desafiostefanini.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Address {

    @Id
    @Getter @Setter
    @GeneratedValue(strategy= GenerationType.AUTO, generator="my_address_seq_gen")
    @SequenceGenerator(name="my_address_seq_gen", sequenceName="SEQ_ADDRESS_ID")
    private Long id;

    @Getter @Setter
    @NotBlank
    @Size(max = 100)
    private String name;

    @ManyToOne
    @Getter @Setter
    private People people;

    @Getter @Setter
    @NotBlank
    @Size(max = 100)
    private String country;

    @Getter @Setter
    @NotBlank
    @Size(max = 30)
    private String state;

    @Getter @Setter
    @NotBlank
    @Size(max = 100)
    private String city;

    @Getter @Setter
    @NotBlank
    @Size(max = 100)
    private  String neighborhood;

    @Getter @Setter
    @NotBlank
    @Size(max = 100)
    private String street;

    @Getter @Setter
    private Integer numbers;

    @Getter @Setter
    private String complement;

}
