package br.edu.unifei.gerenciadorestagio;

import com.fasterxml.jackson.annotation.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class MCurso implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;

    @Column(unique = true)
    public String codigo;

    @Column(unique = true)
    public String nome;

    public EPeriodo periodo;

//    @OneToMany()
//    public List<MAluno> alunos = new ArrayList<MAluno>();
    @OneToMany(mappedBy = "curso")
    @JsonManagedReference(value = "cursoAluno")
    public List<MAluno> alunos ;

//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "instituto_id", referencedColumnName="id")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "instituto_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
    @JsonIdentityReference(alwaysAsId=true)
    @JsonProperty("instituto_id")
//    @JsonBackReference(value = "instituto_curso")
    public MInstituto instituto;

    public void setTnstituto(MInstituto instituto) {
        this.instituto = instituto;
    }
}
