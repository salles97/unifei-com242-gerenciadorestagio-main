package br.edu.unifei.gerenciadorestagio;

import com.fasterxml.jackson.annotation.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class MProfessor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;

    @Column(nullable = false )
    public String nome;

    @Column(unique = true)
    public String cpf;

    @Column(unique = true)
    public String rg;

    @Column(unique = true)
    public String matricula;

    public ECampus campus;

    public String telefone;

    @Column(nullable = false )
    public String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName="id")
    public MEndereco endereco;


    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "instituto_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
    @JsonIdentityReference(alwaysAsId=true)
    @JsonProperty("instituto_id")
    public MInstituto instituto;

//    @OneToMany(mappedBy = "professor")
////    @JsonManagedReference
//    public List<MAluno> alunos ;

//    @OneToMany(mappedBy = "professor")
////    @JsonManagedReference
//    public List<MInfoEstagio> infoEstagios ;

//    @JsonIgnore
    public void setTnstituto(MInstituto instituto) {
        this.instituto = instituto;
    }

}
