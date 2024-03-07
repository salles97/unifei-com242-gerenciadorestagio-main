package br.edu.unifei.gerenciadorestagio;

import javax.persistence.*;

@Entity
public class MCoordenador {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;

    @Column(nullable = false)
    public String nome;

    @Column(unique = true)
    public String cpf;

    @Column(unique = true)
    public String rg;

    public ECampus campus;
    public String email;
    public String telefone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instituto_id", referencedColumnName="id")
    public MInstituto instituto;
    public String senha;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName="id")
    public MEndereco endereco;
}
