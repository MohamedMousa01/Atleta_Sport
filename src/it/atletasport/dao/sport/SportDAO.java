package it.atletasport.dao.sport;

import it.atletasport.dao.IBaseDAO;
import it.atletasport.model.Sport;

import java.util.List;

public interface SportDAO extends IBaseDAO<Sport> {

    public List<Sport> trovaSportConDateinvertite() throws Exception;

}
