package it.atletasport.services;

import it.atletasport.dao.EntityManagerUtil;
import it.atletasport.dao.atleta.AtletaDAO;
import it.atletasport.dao.sport.SportDAO;
import it.atletasport.model.Atleta;
import it.atletasport.model.Sport;

import javax.persistence.EntityManager;
import java.util.List;

public class SportServiceImpl implements SportService{

    private AtletaDAO atletaDAO;
    private SportDAO sportDAO;

    @Override
    public void setAtletaDAO( AtletaDAO atletaDAO){this.atletaDAO = atletaDAO;}

    @Override
    public void setSportDAO( SportDAO sportDAO){this.sportDAO = sportDAO;}


    @Override
    public List<Sport> listAll() throws Exception {
        // questo è come una connection
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            // uso l'injection per il dao
            sportDAO.setEntityManager(entityManager);

            // eseguo quello che realmente devo fare
            return sportDAO.list();

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            EntityManagerUtil.closeEntityManager(entityManager);
        }
    }



    @Override
    public void aggiorna(Sport sportInstance) throws Exception {
        // questo è come una connection
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            // questo è come il MyConnection.getConnection()
            entityManager.getTransaction().begin();

            // uso l'injection per il dao
            sportDAO.setEntityManager(entityManager);

            // eseguo quello che realmente devo fare
            sportDAO.update(sportInstance);

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            throw e;
        } finally {
            EntityManagerUtil.closeEntityManager(entityManager);
        }

    }


    @Override
    public void inserisciNuovo(Sport sportInstance) throws Exception {
        // questo è come una connection
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            // questo è come il MyConnection.getConnection()
            entityManager.getTransaction().begin();

            // uso l'injection per il dao
            sportDAO.setEntityManager(entityManager);

            // eseguo quello che realmente devo fare
            sportDAO.insert(sportInstance);

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            throw e;
        } finally {
            EntityManagerUtil.closeEntityManager(entityManager);
        }

    }


    @Override
    public void rimuovi(Long idUtente) throws Exception {
        // TODO Auto-generated method stub



    }


}
