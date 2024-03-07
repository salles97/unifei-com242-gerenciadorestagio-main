package br.edu.unifei.gerenciadorestagio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MEndereco {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;

    public String logradouro;

    public Integer numero;

    public String complemento;

    public String cidade;

    public String cep;

}
