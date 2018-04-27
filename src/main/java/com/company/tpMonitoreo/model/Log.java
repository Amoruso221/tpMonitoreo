package com.company.tpMonitoreo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;


@Entity
public class Log {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String sistemaOperativo;
    private String navegador;
    private LocalDateTime fecha;

    protected Log(){}

    public Log(String sistemaOperativo, String navegador){
        this.sistemaOperativo = sistemaOperativo;
        this.navegador = navegador;
        this.fecha = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public String getNavegador() {
        return navegador;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

}
