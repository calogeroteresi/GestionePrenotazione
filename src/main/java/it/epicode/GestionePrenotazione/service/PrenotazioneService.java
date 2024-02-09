package it.epicode.GestionePrenotazione.service;

import it.epicode.GestionePrenotazione.bean.Edificio;
import it.epicode.GestionePrenotazione.bean.Prenotazione;
import it.epicode.GestionePrenotazione.repository.PrenotazioneRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    private final Logger logger = LoggerFactory.getLogger(PrenotazioneService.class);

    public void salvaPrenotazione(Prenotazione prenotazione) {
        try {
            int idPostazione = prenotazione.getPostazione().getId();
            LocalDate dataPrenotazione = prenotazione.getDataPrenotazione();

            prenotazioneRepository.save(prenotazione);
        } catch (Exception e) {
            logger.error("Si è verificato un errore durante il salvataggio della prenotazione", e);
        }
    }

    public void aggiornaPrenotazione(Optional<Edificio> prenotazione) {
        try {
            Prenotazione p = prenotazioneRepository.findById(prenotazione.getId()).orElseThrow(() -> new IllegalArgumentException("Prenotazione non trovata per l'ID: " + prenotazione.getId()));
            p.setDataPrenotazione(prenotazione.getDataPrenotazione());
            p.setPostazione(prenotazione.getPostazione());
            prenotazioneRepository.save(p);
        } catch (Exception e) {
            logger.error("Si è verificato un errore durante l'aggiornamento della prenotazione", e);
        }
    }

    public Prenotazione cercaPrenotazionePerId(int id) {
        try {
            return prenotazioneRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Prenotazione non trovata per l'ID: " + id));
        } catch (Exception e) {
            logger.error("Si è verificato un errore durante la ricerca della prenotazione per ID", e);
            return null;
        }
    }

    public void cancellaPrenotazione(int id) {
        try {
            prenotazioneRepository.deleteById(id);
        } catch (Exception e) {
            logger.error("Si è verificato un errore durante la cancellazione della prenotazione", e);
        }
    }


}
