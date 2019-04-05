/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package br.com.sampaiodias.dsp2019.aulas1316.ap.model;

import br.com.sampaiodias.dsp2019.aulas1316.ap.create.TableCreateCargo;
import br.com.sampaiodias.dsp2019.aulas1316.ap.query.ConsultaCargo;
import br.com.sampaiodias.dsp2019.aulas1316.ap.query.ConsultaDepartamento;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Lucas Sampaio Dias
 */
public class Lotacao {
    
    private Long id;
    private Date dataInicial;
    private Date dataFinal;
    private Cargo cargo;
    private Departamento departamento;
    
    public static final SimpleDateFormat DATE_FORMAT = 
            new SimpleDateFormat("dd/MM/yyyy");
    
    public Lotacao(Long id, Cargo cargo, Departamento departamento, 
            Date dataInicial, Date dataFinal) {
        this.id = id;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.cargo = cargo;
        this.departamento = departamento;
    }
    
    public Lotacao(Long id, Long idCargo, Long idDepartamento,
            String dataInicial, String dataFinal) throws Exception {
        this.id = id;
        setCargo(idCargo);
        setDepartamento(idDepartamento);
        setDataInicial(dataInicial);
        setDataFinal(dataFinal);
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataInicial() {
        return dataInicial;
    }
    
    public String getDataInicialToString() {
        Calendar c = Calendar.getInstance();
        c.setTime(getDataInicial());
        return getDiaFormatado(c.get(Calendar.DAY_OF_MONTH)) + "/" + 
                getDiaFormatado(c.get(Calendar.MONTH) + 1) + "/" + 
                c.get(Calendar.YEAR);
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }
    
    public void setDataInicial(String dataInicial) throws ParseException {
        setDataInicial(DATE_FORMAT.parse(dataInicial));
    }

    public Date getDataFinal() {
        return dataFinal;
    }
    
    public String getDataFinalToString() {
        Calendar c = Calendar.getInstance();
        c.setTime(getDataFinal());
        return getDiaFormatado(c.get(Calendar.DAY_OF_MONTH)) + "/" + 
                getDiaFormatado(c.get(Calendar.MONTH) + 1) + "/" + 
                c.get(Calendar.YEAR);
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }
    
    public void setDataFinal(String dataFinal) throws ParseException {
        setDataFinal(DATE_FORMAT.parse(dataFinal));
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
    
    public void setCargo(Long id) throws Exception {
        Cargo c = new ConsultaCargo().consultaPorId(id);
        setCargo(c);
    }

    public Departamento getDepartamento() {
        return departamento;
    }
    
    public void setDepartamento(Long id) throws Exception {
        Departamento d = new ConsultaDepartamento().consultaPorId(id);
        setDepartamento(d);
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
    
    private String getDiaFormatado(int dia) {
        if (dia >= 10) {
            return "" + dia;
        }
        return "0" + dia;
    } 
}
