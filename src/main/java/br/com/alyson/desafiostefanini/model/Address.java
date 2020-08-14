package br.com.alyson.desafiostefanini.model;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "ADDRESS")
public class Address implements Serializable {

    private static final long serialVersionUID = -6467827889068379584L;

    @Id
    @Getter @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Getter @Setter
    @Column(name = "date_created", nullable = false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date dateCreated;

    @Getter @Setter
    @Column(name = "date_updated", nullable = false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date dateUpdated;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;

        Address address = (Address) o;

        return getId().equals(address.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
