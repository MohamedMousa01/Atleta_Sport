package it.atletasport.services;

import it.atletasport.dao.atleta.AtletaDAO;
import it.atletasport.dao.sport.SportDAO;
import it.atletasport.model.Atleta;

import java.util.List;

public interface AtletaService {


    public void setAtletaDAO(AtletaDAO atletaDAO);
    public void setSportDAO(SportDAO sportDAO);

    public List<Atleta> listAll() throws Exception;

    public void aggiorna(Atleta utenteInstance) throws Exception;

    public void inserisciNuovo(Atleta utenteInstance) throws Exception;

    public void rimuovi(Long idUtente) throws Exception;


}
