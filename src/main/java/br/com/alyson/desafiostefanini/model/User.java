package br.com.alyson.desafiostefanini.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class User {

    @Id
    @Getter @Setter
    @GeneratedValue(strategy= GenerationType.AUTO, generator="my_role_user_gen")
    @SequenceGenerator(name="my_role_seq_gen", sequenceName="SEQ_USER_ID")
    private Long id;

    @Getter @Setter
    @NotBlank
    @Size(max = 100)
    private String name;

    @Getter @Setter
    @NotBlank
    @Size(max = 100)
    @Email
    private String email;

    @Getter @Setter
    @NotBlank
    @Size(max = 255)
    private String passwords;

    @Getter @Setter
    @NotBlank
    @Size(max = 100)
    private String status;

    @ManyToMany
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    @Getter
    @Setter
    private Set<Role> roles;


}
