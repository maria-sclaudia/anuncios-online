package io.github.mariasclaudia.anunciosapi.repository;

import io.github.mariasclaudia.anunciosapi.model.entity.AnuncioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnuncioRepository extends JpaRepository<AnuncioModel, Integer> {

    @Query( value = "SELECT * FROM anuncio a WHERE UPPER( a.cliente ) = UPPER( :cliente ) " +
            "AND a.data_inicio >= :dataInicio AND a.data_termino <= :dataFinal", nativeQuery = true)
    List<AnuncioModel> findByPeriod(@Param("dataInicio") String dataInicio,
                                    @Param("dataFinal") String dataFinal,
                                    @Param("cliente") String cliente);
}
