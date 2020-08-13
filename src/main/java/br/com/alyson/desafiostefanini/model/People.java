package br.com.alyson.desafiostefanini.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class People {

    @Id
    @Getter @Setter
    @GeneratedValue(strategy= GenerationType.AUTO, generator="my_people_seq_gen")
    @SequenceGenerator(name="my_people_seq_gen", sequenceName="SEQ_PEOPLE_ID")
    private Long id;

    @Getter @Setter
    @NotBlank
    @Size(max = 100)
    private String name;

    @Getter @Setter
    @NotBlank
    @Size(max = 100)
    private String sex;

    @Getter @Setter
    @NotBlank
    @Size(max = 100)
    @Email
    private String email;

    @Getter @Setter
    @Temporal(TemporalType.DATE)
    @NotBlank
    private Date birthday;

    @Getter @Setter
    @NotBlank
    @Size(max = 100)
    private String naturalness;

    @Getter @Setter
    @NotBlank
    @Size(max = 100)
    private String nationality;

    @Getter @Setter
    @NotBlank
    @Size(max = 100)
    @CPF
    private String cpf;

}
