package it.atletasport.dao.sport;

import it.atletasport.model.Atleta;
import it.atletasport.model.Sport;

import javax.persistence.EntityManager;
import java.util.List;

public class SportDAOImpl implements SportDAO{

    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<Sport> list() throws Exception {
        // dopo la from bisogna specificare il nome dell'oggetto (lettera maiuscola) e
        // non la tabella
        return entityManager.createQuery("from Sport",Sport.class).getResultList();
    }

    @Override
    public Sport get(Long id) throws Exception {
        return entityManager.find(Sport.class, id);
    }

    @Override
    public void update(Sport sportInstance) throws Exception {
        if (sportInstance == null) {
            throw new Exception("Problema valore in input");
        }
        sportInstance = entityManager.merge(sportInstance);
    }

    @Override
    public void insert(Sport sportInstance) throws Exception {
        if (sportInstance == null) {
            throw new Exception("Problema valore in input");
        }

        entityManager.persist(sportInstance);
    }

    @Override
    public void delete(Sport sportInstance) throws Exception {
        if (sportInstance == null) {
            throw new Exception("Problema valore in input");
        }
        entityManager.remove(entityManager.merge(sportInstance));
    }


}
