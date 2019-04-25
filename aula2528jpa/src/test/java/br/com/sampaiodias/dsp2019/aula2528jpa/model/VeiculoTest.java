/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package br.com.sampaiodias.dsp2019.aula2528jpa.model;

import br.com.sampaiodias.dsp2019.aula2528jpa.persistencia.VeiculoRepository;
import br.com.sampaiodias.dsp2019.aula2528jpa.persistencia.VeiculoRepositoryImpl;
import java.sql.SQLException;
import org.apache.log4j.Logger;
import org.h2.tools.Server;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Lucas Sampaio Dias
 */
public class VeiculoTest {
    
    Logger logger = Logger.getLogger(VeiculoTest.class.getName());

    Server server = null;
    VeiculoRepository repository;

    @BeforeEach
    public void setup() throws SQLException {
        server = Server.createTcpServer().start();
        repository = new VeiculoRepositoryImpl();
    }

    @Test
    public void testCreate() {
        Veiculo v = criarVeiculo();
        System.out.println("ID: " + v.getId());
        Assertions.assertTrue(true);
    }
    
    @Test
    public void testGet() {
        Veiculo v = criarVeiculo();
        Veiculo veiculo = repository.read(v.getId());
        System.out.println("Modelo: " + veiculo.getModelo());
        Assertions.assertTrue(true);
    }
    
    @Test
    public void testDelete() {
        Veiculo v = criarVeiculo();
        Veiculo veiculo = repository.read(v.getId());
        if(veiculo != null){
            repository.delete(veiculo);
            System.out.println("Veículo removido");
        }

        Veiculo novoVeiculo = repository.read(1L);
        Assertions.assertTrue(novoVeiculo == null);
    }
    
    @Test
    public void testUpdate() {
        Veiculo v = criarVeiculo();
        Veiculo veiculo = repository.read(v.getId());
        veiculo.setAnoFabricacao(2005);
        repository.update(veiculo);
        Assertions.assertTrue(repository.read(
                veiculo.getId()).getAnoFabricacao().equals(2005));
    }

    private Veiculo criarVeiculo() {
        Veiculo veiculo = new Veiculo();
        veiculo.setMarca("Marca A");
        veiculo.setModelo("Modelo A");
        veiculo.setAnoFabricacao(2000);
        veiculo.setAnoModelo(2000);
        veiculo.setPotenciaMotor(100);
        
        Veiculo v = repository.create(veiculo);
        return v;
    }
}
