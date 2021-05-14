package io.github.mariasclaudia.anunciosapi.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "anuncio")
public class AnuncioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome_anuncio",length = 50)
    private String nome_anuncio;

    @Column(length = 50)
    private String cliente;

    @Column
//    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate data_inicio;

    @Column
//    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate data_termino;

    @Column
    private Double investimento_dia;
}
