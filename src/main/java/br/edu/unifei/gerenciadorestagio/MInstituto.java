package br.edu.unifei.gerenciadorestagio;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.DoubleStream;

@Entity
public class MInstituto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;
    @Column(unique = true, nullable = false)
    public String nome;
    @Column(unique = true, nullable = false)
    public String sigla;

    /** Cursos*/
    @OneToMany(mappedBy = "instituto", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JsonManagedReference(value = "instituto_curso")
    public Set<MCurso> cursos = new HashSet<>();

    /** Professores*/
    @OneToMany(mappedBy = "instituto")
//    @JsonManagedReference(value = "instituto_professor")
    public List<MProfessor> professores ;

    /** Projetos*/
//    @OneToMany(mappedBy = "instituto")
//    @JsonManagedReference(value = "instituto_projeto")
//    public List<MInfoEstagio> projetos ;

//    public MInstituto() {}

}
