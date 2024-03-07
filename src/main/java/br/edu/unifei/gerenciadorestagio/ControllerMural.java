package br.edu.unifei.gerenciadorestagio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("oportunidade")
public class ControllerMural {

    public final IROportunidade oportunidades;
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public ControllerMural(IROportunidade oportunidades) {
        this.oportunidades = oportunidades;
    }

    @PostMapping("add")
    @ResponseStatus(HttpStatus.CREATED)
    public MOportunidade adicionarOportunidade(@RequestBody MOportunidade oportunidade) {
        oportunidades.save(oportunidade);
        kafkaTemplate.send("nova-oportunidade", oportunidade.toString());
        return oportunidade;
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Iterable getOportunidades() {
        return oportunidades.findAll();
    }

}
