package io.github.mariasclaudia.anunciosapi.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CalculadoraModel {

    private Integer compartilhamentos;
    private Integer cliques;
    private Integer visualizacoes;
    private Double total_investido;

    public CalculadoraModel(Integer compartilhamentos,
                            Integer cliques,
                            Integer visualizacoes,
                            Double total_investido) {
        this.compartilhamentos = compartilhamentos;
        this.cliques = cliques;
        this.visualizacoes = visualizacoes;
        this.total_investido = total_investido;
    }
}
