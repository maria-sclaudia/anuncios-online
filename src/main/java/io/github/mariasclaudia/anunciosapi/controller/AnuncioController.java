package io.github.mariasclaudia.anunciosapi.controller;

import io.github.mariasclaudia.anunciosapi.model.CalculadoraModel;
import io.github.mariasclaudia.anunciosapi.model.entity.AnuncioModel;
import io.github.mariasclaudia.anunciosapi.repository.AnuncioRepository;
import io.github.mariasclaudia.anunciosapi.service.AnuncioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class AnuncioController {

    @Autowired
    private AnuncioRepository repository;
    @Autowired
    private AnuncioService service;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AnuncioModel> addAds(@RequestBody AnuncioModel anuncio){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addAds(anuncio));
    }

    @GetMapping("/filter-all")
    public ResponseEntity< List<AnuncioModel> > listAll(){
        return ResponseEntity.ok(service.listAll());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/custom")
    public ResponseEntity< List<CalculadoraModel> > reportsAds(@RequestParam(value= "cliente") String cliente,
                                                               @RequestParam(value= "dataInicio") String dataInicio,
                                                               @RequestParam(value= "dataFinal") String dataFinal){

        List<CalculadoraModel> listCalculadora = service.genReports(cliente, dataInicio, dataFinal);

        return ResponseEntity.ok(listCalculadora);
    }
}
