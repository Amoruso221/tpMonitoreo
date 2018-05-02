package com.company.tpMonitoreo.controller;

import com.company.tpMonitoreo.model.Log;

import com.company.tpMonitoreo.repository.repositoryInterface;
import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class logController {

    @Autowired
    public repositoryInterface dao;

    @RequestMapping(value = "/")
    public void data(@RequestHeader(value = "User-Agent") String userAgent){
        String nombreNavegador = obtenerNombreNavegador(userAgent);
        String sistemaOperativo = obtenerSistemaOperativo(userAgent);
        Log log = new Log(sistemaOperativo, nombreNavegador);
        dao.save(log);
    }

    private String obtenerNombreNavegador(String userAgent){
        UserAgent datos = UserAgent.parseUserAgentString(userAgent);
        Browser browser = datos.getBrowser();
        String browserName = browser.getName();

        return browserName;
    }

    private String obtenerSistemaOperativo(String userAgent){
        UserAgent datos = UserAgent.parseUserAgentString(userAgent);
        OperatingSystem os = datos.getOperatingSystem();
        String nombreSistemaOperativo = os.getName();

        return nombreSistemaOperativo;
    }

    //Devuelve todos los Logs
    @RequestMapping(value = "/traerTodos")
    public List<Log> traerTodos(){
        List<Log> lista = dao.findAll();

        return lista;
    }

    //Navegador mas utilizado
    @RequestMapping(value = "/navegador")
    public String navegadorMasUtilizado(){
        String navegador;
        int countChrome = 0;
        int countExplorer = 0;
        List<Log> lista = traerTodos();

        for(Log e : lista){
            if (e.getNavegador().equals("Chrome")){
                countChrome++;
            }
                else{
                countExplorer++;
            }
        }

        if(countChrome > countExplorer){
            navegador = "Chrome";
        }
            else{
            navegador = "Internet Explorer";
        }

        return navegador;
    }

    //Sistema Operativo mas utilizado
    @RequestMapping(value = "/sistemaOperativo")
    public String sistemaMasUtilizado(){
        List<Log> lista = traerTodos();
        int countWindows = 0;
        int countLinux = 0;
        String SO;

        for(Log e : lista){
            if(e.getSistemaOperativo().equals("Windows 10")){
                countWindows++;
            }
                else
                    countLinux++;
        }

        if(countWindows > countLinux)
            SO = "Windows 10";
        else
            SO = "Linux";

        return SO;
    }

    //Sistema operativo con navegador mas utilizado
    @RequestMapping(value = "/sistemaynavegador")
    public String sistemaConNavegador(){
        List<Log> lista = traerTodos();
        int countWindowsYchrome = 0;
        int countWindowsYexplorer = 0;
        String masUsado;

        for(Log e : lista){
            if (e.getSistemaOperativo().equals("Windows 10") && e.getNavegador().equals("Chrome"))
                countWindowsYchrome++;
            else
                countWindowsYexplorer++;
        }

        if (countWindowsYchrome > countWindowsYexplorer)
            masUsado = "Windows 10 y chrome";
            else
                masUsado = "Windows 10 e internet explorer";

        return masUsado;
    }
}
