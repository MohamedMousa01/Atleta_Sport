package it.atletasport.services;

import it.atletasport.dao.EntityManagerUtil;
import it.atletasport.dao.atleta.AtletaDAO;
import it.atletasport.dao.sport.SportDAO;
import it.atletasport.model.Atleta;
import it.atletasport.model.Sport;

import javax.persistence.EntityManager;
import java.util.List;

public class AtletaServiceImpl implements AtletaService {


    private AtletaDAO atletaDAO;
    private SportDAO sportDAO;

    @Override
    public void setAtletaDAO( AtletaDAO atletaDAO){this.atletaDAO = atletaDAO;}

    @Override
    public void setSportDAO( SportDAO sportDAO){this.sportDAO = sportDAO;}


    @Override
    public List<Atleta> listAll() throws Exception {
        // questo è come una connection
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            // uso l'injection per il dao
            atletaDAO.setEntityManager(entityManager);

            // eseguo quello che realmente devo fare
            return atletaDAO.list();

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            EntityManagerUtil.closeEntityManager(entityManager);
        }
    }



    @Override
    public void aggiorna(Atleta atletaInstance) throws Exception {
        // questo è come una connection
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            // questo è come il MyConnection.getConnection()
            entityManager.getTransaction().begin();

            // uso l'injection per il dao
            atletaDAO.setEntityManager(entityManager);

            // eseguo quello che realmente devo fare
            atletaDAO.update(atletaInstance);

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
    public void inserisciNuovo(Atleta AtletaInstance) throws Exception {
        // questo è come una connection
        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try {
            // questo è come il MyConnection.getConnection()
            entityManager.getTransaction().begin();

            // uso l'injection per il dao
            atletaDAO.setEntityManager(entityManager);

            // eseguo quello che realmente devo fare
            atletaDAO.insert(AtletaInstance);

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

        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try{
            entityManager.getTransaction().begin();

            atletaDAO.setEntityManager(entityManager);

            Atleta atleta = atletaDAO.get(idUtente);
            atletaDAO.delete(atleta);

            entityManager.getTransaction().commit();

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException(e);
        }

    }



    public void removeAtleta(Long atletaId) throws Exception{

        EntityManager entityManager = EntityManagerUtil.getEntityManager();

        try{

            entityManager.getTransaction().begin();

            atletaDAO.setEntityManager(entityManager);


            Atleta atletaDaRimuovere = atletaDAO.get(atletaId);

            if (atletaDaRimuovere != null) {
                atletaDaRimuovere.getSport().clear();

                atletaDAO.delete(atletaDaRimuovere);
            }

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException(e);
        } finally {
            EntityManagerUtil.closeEntityManager(entityManager);
        }
    }


    @Override
    public void sommaMedaglieAtletiConSportChiusi() throws Exception {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        try {

            atletaDAO.setEntityManager(entityManager);

            Long totale = atletaDAO.sommaMedaglieAtletiConSportChiusi();

            System.out.println("Il totale delle medaglie degli atleti con sport conclusi è: " + totale);

        } catch (Exception e) {
            throw e;
        } finally {
            entityManager.close();
        }
    }



}
