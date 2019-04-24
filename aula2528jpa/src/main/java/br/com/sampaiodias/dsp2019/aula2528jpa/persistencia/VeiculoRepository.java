/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package br.com.sampaiodias.dsp2019.aula2528jpa.persistencia;

import br.com.sampaiodias.dsp2019.aula2528jpa.model.Veiculo;
import java.util.List;

/**
 * @author Lucas Sampaio Dias
 */
public interface VeiculoRepository {
    Veiculo create(Veiculo veiculo);
    Veiculo read(Long id);
    List<Veiculo> findByName(String name);
    Veiculo update(Veiculo veiculo);
    void delete(Veiculo veiculo);
    void close();
}
