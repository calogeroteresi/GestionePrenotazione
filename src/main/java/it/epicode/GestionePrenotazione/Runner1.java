package it.epicode.GestionePrenotazione;
import it.epicode.GestionePrenotazione.bean.Edificio;
import it.epicode.GestionePrenotazione.bean.Postazione;
import it.epicode.GestionePrenotazione.bean.Prenotazione;
import it.epicode.GestionePrenotazione.bean.Utente;
import it.epicode.GestionePrenotazione.service.EdificioService;
import it.epicode.GestionePrenotazione.service.PostazioneService;
import it.epicode.GestionePrenotazione.service.PrenotazioneService;
import it.epicode.GestionePrenotazione.service.UtenteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Optional;

@Component
public class Runner1 implements CommandLineRunner {

    @Autowired
    private EdificioService edificioService;
    @Autowired
    private PostazioneService postazioneService;

    @Autowired
    private PrenotazioneService prenotazioneService;

    @Autowired
    private UtenteService utenteService;

    private Logger logger = LoggerFactory.getLogger("gestionePrenotazione");

    @Override
    public void run(String... args) throws Exception {
        logger.info("Avvio del metodo run...");
//
//        Utente u2 = new Utente();
//        u2.setEmail("c.t@gmail.com");
//        u2.setNomeCompleto("Calogero Teresi");
//        u2.setUsername("Calogero1");
//
//        utenteService.salvaUtente(u2);
//
//
//        Edificio edificio = new Edificio();
//        edificio.setNome("Edificio1");
//        edificio.setCitta("Città1");
//        edificio.setIndirizzo("Indirizzo1");
//        edificioService.salvaEdificio(edificio);
//
//        // Creazione di una postazione nell'edificio creato
//        Postazione postazione = new Postazione();
//        postazione.setDescrizione("Postazione1");
//        postazione.setEdificio(edificio);
//        postazioneService.salvaPostazione(postazione);
//
//        // Creazione di una prenotazione per l'utente u2 nella postazione creata
//        Prenotazione prenotazione = new Prenotazione();
//        prenotazione.setDataPrenotazione(LocalDate.now());
//        prenotazione.setUtente(u2);
//        prenotazione.setPostazione(postazione);
//        prenotazioneService.salvaPrenotazione(prenotazione);


        Optional<Edificio> edificio1 = edificioService.cercaEdificioPerId(1);
        edificio1.ifPresent(edificio -> {
            edificio.setNome("Nuovo Nome Edificio");
            edificioService.salvaEdificio(edificio);
        });

        Optional<Postazione> postazione1 = postazioneService.cercaPostazionePerId(1);
        Utente utente1 = utenteService.cercaUtentePerId(1);
        Prenotazione prenotazione1 = prenotazioneService.cercaPrenotazionePerId(1);


        prenotazioneService.aggiornaPrenotazione(edificio1);
        //prenotazioneService.eliminaPrenotazione(1);
        //utenteService.eliminaUtente(1);
        //edificioService.eliminaEdificio(1);
        //edificioService.eliminaEdificio(1);


        logger.info("Metodo run completato.");
    }


}
