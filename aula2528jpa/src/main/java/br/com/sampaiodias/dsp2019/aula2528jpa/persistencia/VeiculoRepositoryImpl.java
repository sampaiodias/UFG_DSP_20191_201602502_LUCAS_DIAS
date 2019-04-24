/*
 * Copyright (c) 2019.
 * Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */

package br.com.sampaiodias.dsp2019.aula2528jpa.persistencia;

import br.com.sampaiodias.dsp2019.aula2528jpa.model.Veiculo;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

/**
 * @author Lucas Sampaio Dias
 */
public class VeiculoRepositoryImpl implements VeiculoRepository {
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory(
            "br.com.sampaiodias.dsp2019.aula2528jpa");
    private EntityManager em;
    
    public VeiculoRepositoryImpl() {
        em = emf.createEntityManager();
    }

    @Override
    public Veiculo create(Veiculo veiculo) {
        em.getTransaction().begin();
        em.persist(veiculo);
        em.getTransaction().commit();
        return veiculo;
    }

    @Override
    public Veiculo read(Long id) {
        //em.getTransaction().begin();
        Veiculo v = em.find(Veiculo.class, id);
        //em.getTransaction().commit();
        return v;
    }

    @Override
    public List<Veiculo> findByName(String name) {
        Query query = em.createQuery(
                "Select v from Veiculo v where v.nome like :name");
        query.setParameter("name", name);
        return query.getResultList();
    }

    @Override
    public Veiculo update(Veiculo veiculo) {
        em.getTransaction().begin();
        veiculo = em.merge(veiculo);
        em.getTransaction().commit();
        return veiculo;
    }

    @Override
    public void delete(Veiculo veiculo) {
        em.getTransaction().begin();
        em.remove(veiculo);
        em.getTransaction().commit();
    }

    @Override
    public void close() {
        emf.close();
    }

}
