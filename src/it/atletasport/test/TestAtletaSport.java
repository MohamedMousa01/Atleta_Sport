package it.atletasport.test;

import it.atletasport.dao.MyDAOFactory;
import it.atletasport.dao.atleta.AtletaDAO;
import it.atletasport.dao.atleta.AtletaDAOImpl;
import it.atletasport.dao.sport.SportDAO;
import it.atletasport.model.Atleta;
import it.atletasport.model.Sport;
import it.atletasport.model.TipoSport;
import it.atletasport.services.AtletaService;
import it.atletasport.services.MyServiceFactory;
import it.atletasport.services.SportService;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static it.atletasport.model.TipoSport.CALCIO;

public class TestAtletaSport {

    public static void main(String[] args){

        AtletaService atletaService = MyServiceFactory.getAtletaServiceInstance();
        SportService sportService = MyServiceFactory.getSportServiceInstance();


        try{
            System.out.println("Sono presenti " + atletaService.listAll().size() + " atleti");

//            testInserisciNuovoAtleta(atletaService);
//            System.out.println("Sono presenti " + atletaService.listAll().size() + " atleti");
//
//            testRimuoviAtleta(atletaService);
//            System.out.println("Sono presenti " + atletaService.listAll().size() + " atleti");
//
//            testUpdateAtleta(atletaService);
//            System.out.println("Sono presenti " + atletaService.listAll().size() + " atleti");

              testCollegaSportAdAtleta( sportService, atletaService);
              System.out.println("Sono presenti " + atletaService.listAll().size() + " atleti");

        } catch (Exception e){
            e.printStackTrace();
        }

    }





     private static void testInserisciNuovoAtleta(AtletaService atletaServiceInstance) throws Exception {
        System.out.println(".......testInserisciNuovoAtleta inizio.............");

        Atleta atletaNuovo = new Atleta("Mario","Rossi", LocalDate.of(2002,03,14), "001", 3);

        atletaServiceInstance.inserisciNuovo(atletaNuovo);
        if (atletaNuovo.getId() == null)
            throw new RuntimeException("testInserisciNuovoUtente fallito ");

        System.out.println(".......testInserisciNuovoUtente fine: PASSED.............");
    }


    private static void testRimuoviAtleta(AtletaService atletaServiceInstance) throws Exception{

        System.out.println("---------testRimuoviAtleta inzio----------");

        Atleta atletaNuovo = new Atleta("Marco","Bianchi", LocalDate.of(2000,02,04), "002", 4 );

        int res1 = atletaServiceInstance.listAll().size();

        atletaServiceInstance.inserisciNuovo(atletaNuovo);
        Long idAtletaNuovo = atletaNuovo.getId();
        if(atletaNuovo.getId() == null)
            throw new RuntimeException("testRimuoviAtleta fallito");

        atletaServiceInstance.rimuovi(idAtletaNuovo);
        int res2 = atletaServiceInstance.listAll().size();
        if(res1 != res2)
            throw new RuntimeException("testRimuoviAtleta fallito");
        else{
            System.out.println("testRimuoviAtleta SUCCESS");
        }
    }



    private static void testUpdateAtleta(AtletaService atletaServiceInstance) throws Exception{

        System.out.println("---------testRimuoviAtleta inzio----------");

        Atleta atletaNuovo1 = new Atleta("Marco","Bianchi", LocalDate.of(2000,02,04), "002", 4 );
        String nome1 = atletaNuovo1.getNome();
        atletaServiceInstance.inserisciNuovo(atletaNuovo1);

        atletaNuovo1.setNome("Paolo");

        atletaServiceInstance.aggiorna(atletaNuovo1);
        String nome2 = atletaNuovo1.getNome();

        if( nome1 == nome2 )
            throw new RuntimeException("testUpdateAtleta FALLITO");

    }




    private static void testCollegaSportAdAtleta( SportService sportServiceInstance, AtletaService atletaServiceInstance) throws Exception{

        System.out.println("---------testCollegaSportAdAtleta inzio----------");

        AtletaDAO atletaDAO = MyDAOFactory.getAtletaDAOInstance();
        SportDAO sportDAO = MyDAOFactory.getSportDAOInstance();

        sportServiceInstance.setAtletaDAO(atletaDAO);
        sportServiceInstance.setSportDAO(sportDAO);

        Sport sport1 = new Sport("BASKET", LocalDate.of(2025,9,15),LocalDate.of(2026,6,8));
        sportServiceInstance.inserisciNuovo(sport1);

        Set<Sport> sport = new HashSet<>(0);
        sport.add(sport1);
        Atleta atleta1 = new Atleta("Francesco" , "Ventura", LocalDate.of(1995,01,01), "007", 4, sport);
        atletaServiceInstance.inserisciNuovo(atleta1);

        Long idSport1 = sport1.getId();
        Long idAtleta1 = atleta1.getId();

        sportServiceInstance.collegaSportAdAtleta(idAtleta1, sport1);

        System.out.println("---------Fine testCollegaSportAdAtleta--------");
    }


}
