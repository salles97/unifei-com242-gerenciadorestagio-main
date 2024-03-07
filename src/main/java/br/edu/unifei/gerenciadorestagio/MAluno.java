package br.edu.unifei.gerenciadorestagio;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class MAluno {
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

//    @Column(nullable = false )
//    public String curso;

    public ECampus campus;

    public String telefone;

    @Column(nullable = false )
    public String email;

    @Column(nullable = false)
    public Long professorId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName="id")
    @JsonBackReference
    public MEndereco endereco;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "curso_id", referencedColumnName="id")
    @JsonBackReference(value = "cursoAluno")
    public MCurso curso;

//    @Column(nullable = false)
//    public Long cursoId;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "professor_id", referencedColumnName="id")
////    @JsonBackReference
//    public MProfessor professor;

//    public MInfoEstagio projeto;
//
//    public void setProjeto(MInfoEstagio projeto) {
//        this.projeto = projeto;
//    }

}
