package br.edu.unifei.gerenciadorestagio;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class MInfoEstagio {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;

//    @OneToOne(cascade = CascadeType.ALL)
//    public MEmpresa empresa;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "aluno_matricula", referencedColumnName="id")
    public MAluno aluno;

//    @OneToOne(cascade = CascadeType.ALL)
//    public MProfessor professor;

    public Integer semestre;

    public Integer cargaExigida;

    public Date dataInicio;

    public Date dataPrevistoTermino;

    public String nomeOrientador;

    public String formacaoOrientador;

    public String cargoOrientador;

    public String emailOrientador;

    public String telefoneOrientador;

    public String localEstagio;

    public Integer diasTrabalhoSemanal;

    public Integer cargaDiaria;

    public String projetoRelacionado;

    public String tipoBolsa;

    public Number valorBolsa;

    public String descricaoAntividade;

    public String definicaoCronograma;

    public String descricaoResultados;

    public String descricaoMeios;

    public String descricaoDisciplinas;

    public Integer professor_id;
//
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "professor_id", referencedColumnName="id")
////    @JsonBackReference
//    public MProfessor professor;
//
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "instituto_id", referencedColumnName="id")
//    @JsonBackReference(value = "instituto_projeto")
//    public MInstituto instituto;
//
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "empresa_id", referencedColumnName="id")
////    @JsonBackReference
//    public MEmpresa empresa;

    // NAO por isso ainda nao. Simplficar por enquanto.
//    public MAluno projeto;

    public void setAluno(MAluno aluno) {
        this.aluno = aluno;
    }



}
