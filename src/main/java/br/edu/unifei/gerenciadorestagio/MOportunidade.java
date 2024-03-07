package br.edu.unifei.gerenciadorestagio;

import br.edu.unifei.gerenciadorestagio.MEmpresa;

import javax.persistence.*;


@Entity
public class MOportunidade {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;

    @Column(nullable = false)
    public String nome;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "empresa_id", referencedColumnName = "id")
    public MEmpresa fornecedor;

    @Override
    public String toString() {
        return String.format("{" +
                "id: \"%s\"," +
                "nome: \"%s\"," +
                "empresa: {" +
                    "id: \"%s\"," +
                    "razaoSocial: \"%s\"," +
                    "atividadePrincipal: \"%s\"," +
                    "tipoEmpresa: \"%s\"," +
                    "endereco: {" +
                        "id: \"%s\"," +
                        "logradouro: \"%s\"," +
                        "numero: \"%s\"," +
                        "complemento: \"%s\"," +
                        "cidade: \"%s\"," +
                        "cep: \"%s\"" +
                    "}" +
                "}" +
            "}",
            id.toString(),
            nome,
            fornecedor.id.toString(),
            fornecedor.razaoSocial,
            fornecedor.atividadePrincipal,
            fornecedor.tipoEmpresa,
            fornecedor.endereco.id.toString(),
            fornecedor.endereco.logradouro,
            fornecedor.endereco.numero.toString(),
            fornecedor.endereco.complemento,
            fornecedor.endereco.cidade,
            fornecedor.endereco.cep);
    }
}


