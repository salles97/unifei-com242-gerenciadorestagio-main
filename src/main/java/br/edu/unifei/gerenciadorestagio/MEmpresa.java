package br.edu.unifei.gerenciadorestagio;

import javax.persistence.*;

@Entity
public class MEmpresa {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;

    @Column(nullable = false)
    public String razaoSocial;

    public String atividadePrincipal;

    public String tipoEmpresa;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName="id")
    public MEndereco endereco;
}
