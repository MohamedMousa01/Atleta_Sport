package it.atletasport.dao.atleta;

import it.atletasport.model.Atleta;

import javax.persistence.EntityManager;
import java.util.List;

public class AtletaDAOImpl implements AtletaDAO {

    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Atleta> list() throws Exception {
        // dopo la from bisogna specificare il nome dell'oggetto (lettera maiuscola) e
        // non la tabella
        return entityManager.createQuery("from Atleta",Atleta.class).getResultList();
    }

    @Override
    public Atleta get(Long id) throws Exception {
        return entityManager.find(Atleta.class, id);
    }

    @Override
    public void update(Atleta atletaInstance) throws Exception {
        if (atletaInstance == null) {
            throw new Exception("Problema valore in input");
        }
        atletaInstance = entityManager.merge(atletaInstance);
    }

    @Override
    public void insert(Atleta atletaInstance) throws Exception {
        if (atletaInstance == null) {
            throw new Exception("Problema valore in input");
        }

        entityManager.persist(atletaInstance);
    }

    @Override
    public void delete(Atleta atletaInstance) throws Exception {
        if (atletaInstance == null) {
            throw new Exception("Problema valore in input");
        }
        entityManager.remove(entityManager.merge(atletaInstance));
    }



    public Long sommaMedaglieAtletiConSportChiusi() throws Exception{

        String jpql = "SELECT SUM(a.numeroMedaglieVinte) " +
                "FROM Atleta a JOIN a.sport s " +
                "WHERE s.dataFine IS NOT NULL AND s.dataFine < CURRENT_DATE";

        Long totale = entityManager.createQuery(jpql, Long.class).getSingleResult();

        return (totale != null) ? totale : 0;

    }




}
