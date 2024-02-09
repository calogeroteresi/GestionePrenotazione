package it.epicode.GestionePrenotazione.service;

import it.epicode.GestionePrenotazione.bean.Utente;
import it.epicode.GestionePrenotazione.repository.UtenteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtenteService {

    @Autowired
    private UtenteRepository utenteRepository;

    private final Logger logger = LoggerFactory.getLogger(UtenteService.class);

    public void salvaUtente(Utente utente) {
        try {
            utenteRepository.save(utente);
        } catch (Exception e) {
            logger.error("Si è verificato un errore durante il salvataggio dell'utente", e);
        }
    }

    public void aggiornaUtente(Utente utente) {
        try {
            Utente u = utenteRepository.findById(utente.getId()).orElseThrow(() -> new IllegalArgumentException("Utente non trovato per l'ID: " + utente.getId()));
            u.setEmail(utente.getEmail());
            u.setUsername(utente.getUsername());
            u.setNomeCompleto(utente.getNomeCompleto());
            utenteRepository.save(u);
        } catch (Exception e) {
            logger.error("Si è verificato un errore durante l'aggiornamento dell'utente", e);
        }
    }

    public Utente cercaUtentePerId(int id) {
        try {
            return utenteRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Utente non trovato per l'ID: " + id));
        } catch (Exception e) {
            logger.error("Si è verificato un errore durante la ricerca dell'utente per ID", e);
            return null;
        }
    }

    public void cancellaUtente(int id) {
        try {
            utenteRepository.deleteById(id);
        } catch (Exception e) {
            logger.error("Si è verificato un errore durante la cancellazione dell'utente", e);
        }
    }
}
