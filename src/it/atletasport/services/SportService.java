package it.atletasport.services;

import it.atletasport.dao.atleta.AtletaDAO;
import it.atletasport.dao.sport.SportDAO;
import it.atletasport.model.Sport;

import java.util.List;

public interface SportService {

    public void setAtletaDAO(AtletaDAO atletaDAO);
    public void setSportDAO(SportDAO sportDAO);

    public List<Sport> listAll() throws Exception;

    public void aggiorna(Sport utenteInstance) throws Exception;

    public void inserisciNuovo(Sport utenteInstance) throws Exception;

    public void rimuovi(Long idUtente) throws Exception;


}
