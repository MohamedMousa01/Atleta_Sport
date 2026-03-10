package it.atletasport.test;

import it.atletasport.model.Atleta;
import it.atletasport.services.AtletaService;
import it.atletasport.services.MyServiceFactory;
import it.atletasport.services.SportService;

import java.time.LocalDate;

public class TestAtletaSport {

    public static void main(String[] args){

        AtletaService atletaService = MyServiceFactory.getAtletaServiceInstance();
        SportService sportService = MyServiceFactory.getSportServiceInstance();


        try{
            System.out.println("Sono presenti " + atletaService.listAll().size() + " atleti");

            testInserisciNuovoAtleta(atletaService);
            System.out.println("Sono presenti " + atletaService.listAll().size() + " atleti");

            testRimuoviAtleta(atletaService);
            System.out.println("Sono presenti " + atletaService.listAll().size() + " atleti");

            testUpdateAtleta(atletaService);
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





}
