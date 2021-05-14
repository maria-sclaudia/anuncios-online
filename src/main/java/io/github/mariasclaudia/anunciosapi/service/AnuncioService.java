package io.github.mariasclaudia.anunciosapi.service;

import io.github.mariasclaudia.anunciosapi.model.CalculadoraModel;
import io.github.mariasclaudia.anunciosapi.model.entity.AnuncioModel;
import io.github.mariasclaudia.anunciosapi.repository.AnuncioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
public class AnuncioService {

    @Autowired
    private AnuncioRepository repository;

    public AnuncioModel addAds(AnuncioModel anuncio){
        repository.save(anuncio);

        return anuncio;
    }

    public List<AnuncioModel> listAll() {
        return repository.findAll();
    }

    public CalculadoraModel calculateAds(AnuncioModel anuncio){

        final int visu_anuncio_original = 30,
                visu_compartilhamento   = 40,
                visu_pessoas            = 100,
                cliques_visu            = 12,
                cliques_pessoas         = 20,
                compart_pessoas         = 3,
                compart_sequencia       = 4;

        Double  compartilhamentos = 0.0,
                visualizacoes   = 0.0,
                cliques         = 0.0,
                auxInvestimento = 0.0;
        int     days            = 0;

        days = (int) ChronoUnit.DAYS.between(anuncio.getData_inicio(),anuncio.getData_termino());
        days = (days > 0) ? days : 1;
        auxInvestimento = anuncio.getInvestimento_dia() * days;

        visualizacoes = (auxInvestimento * visu_anuncio_original) * (compart_sequencia * visu_compartilhamento);
        cliques = (visualizacoes / visu_pessoas) * cliques_visu;
        compartilhamentos = (cliques / cliques_pessoas) * compart_pessoas;

        visualizacoes = visualizacoes + (compartilhamentos * visu_compartilhamento);

        CalculadoraModel calculadoraModel = new CalculadoraModel(compartilhamentos.intValue(),
                                                                 cliques.intValue(),
                                                                 visualizacoes.intValue(),
                                                                 auxInvestimento);

        return calculadoraModel;
    }

    public List<CalculadoraModel> genReports(String cliente, String dataInicio, String dataFinal){
        List<AnuncioModel> listAds = repository.findByPeriod(dataInicio, dataFinal, cliente);
        List<CalculadoraModel> calculadoraAds = new ArrayList<>();

        for(AnuncioModel anuncio : listAds){
            CalculadoraModel calculadoraModel = calculateAds(anuncio);
            calculadoraAds.add(calculadoraModel);
        }

        return calculadoraAds;
    }
}
