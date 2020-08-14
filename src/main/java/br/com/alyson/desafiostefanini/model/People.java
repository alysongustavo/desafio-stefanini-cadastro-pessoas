package br.com.alyson.desafiostefanini.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "PEOPLE")
public class People implements Serializable {

    private static final long serialVersionUID = 9024448305550910580L;

    @Id
    @Getter @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @NotNull
    private Date birthday;

    @Getter @Setter
    @NotBlank
    @Size(max = 100)
    private String naturalness;

    @Getter @Setter
    @NotBlank
    @Size(max = 100)
    private String nationality;

    @NotBlank
    @Size(max = 100)
    @CPF
    private String cpf;

    @Getter @Setter
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_created", nullable = false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date dateCreated;

    @Getter @Setter
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_updated", nullable = false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date dateUpdated;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf =  cpf.replaceAll("\\.","").replaceAll("\\/","").replace("-","");;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        People other = (People) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
