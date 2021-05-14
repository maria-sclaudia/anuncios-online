package io.github.mariasclaudia.anunciosapi;

import io.github.mariasclaudia.anunciosapi.model.CalculadoraModel;
import io.github.mariasclaudia.anunciosapi.model.entity.AnuncioModel;
import io.github.mariasclaudia.anunciosapi.repository.AnuncioRepository;
import io.github.mariasclaudia.anunciosapi.service.AnuncioService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "spring.main.allow-bean-definition-overriding=true")
public class AnuncioServiceTest {

    @TestConfiguration
    static class AnuncioServiceTestConfiguration{

        @Bean
        public AnuncioService anuncioService(){
            return new AnuncioService();
        }
    }

    @Autowired
    AnuncioService service;

    @MockBean
    AnuncioRepository repository;

    @Before
    public void setup(){
        AnuncioModel anuncio = new AnuncioModel();
        anuncio.setId(1);
        anuncio.setNome_anuncio("Anuncio da Maria");
        anuncio.setCliente("Maria");
        anuncio.setData_inicio(LocalDate.parse("2021-05-11"));
        anuncio.setData_termino(LocalDate.parse("2021-05-11"));
        anuncio.setInvestimento_dia(1.00);

        List<AnuncioModel> anuncioModelList = new ArrayList<>();
        anuncioModelList.add(anuncio);

        Mockito.when(repository.findByPeriod(anuncio.getData_inicio().toString(),
                                            anuncio.getData_termino().toString(),
                                            anuncio.getCliente()))
                    .thenReturn(anuncioModelList);
    }

    @Test
    public void anuncioTestServiceCaculateAds(){

        List<CalculadoraModel> calculadoraModelList = new ArrayList<>();
        calculadoraModelList = service.genReports("Maria", "2021-05-11", "2021-05-11");

        Assertions.assertEquals(calculadoraModelList.get(0).getCompartilhamentos(), 86);
        Assertions.assertEquals(calculadoraModelList.get(0).getCliques(), 576);
        Assertions.assertEquals(calculadoraModelList.get(0).getVisualizacoes(), 8256);
        Assertions.assertEquals(calculadoraModelList.get(0).getTotal_investido(), 1);
    }
}
