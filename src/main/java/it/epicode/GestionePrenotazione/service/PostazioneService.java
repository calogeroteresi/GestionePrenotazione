package it.epicode.GestionePrenotazione.service;

import it.epicode.GestionePrenotazione.bean.Postazione;
import it.epicode.GestionePrenotazione.enums.TipoPostazione;
import it.epicode.GestionePrenotazione.repository.PostazioneRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostazioneService {

    @Autowired
    private PostazioneRepository postazioneRepository;
    private final Logger logger = LoggerFactory.getLogger("gestionePrenotazione");

    public void salvaPostazione(Postazione postazione) {
        try {
            postazioneRepository.save(postazione);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    public void aggiornaPostazione(Postazione postazione) {
        Optional<Postazione> optionalPostazione = postazioneRepository.findById(postazione.getId());
        if (optionalPostazione.isPresent()) {
            Postazione p = optionalPostazione.get();
            p.setDescrizione(postazione.getDescrizione());
            p.setNumeroMassimoOccupanti(postazione.getNumeroMassimoOccupanti());
            p.setTipo(postazione.getTipo());
            postazioneRepository.save(p);
        } else {

            throw new IllegalArgumentException("Postazione non trovata per l'ID: " + postazione.getId());
        }
    }

    public Optional<Postazione> cercaPostazionePerId(int id) {
        try {
            return postazioneRepository.findById(id);
        } catch (Exception e) {
            logger.error("Non è stato trovato nulla");
            return Optional.empty();
        }
    }

    public void cancellaPostazione(int id) {
        try {
            postazioneRepository.deleteById(id);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    public List<Postazione> cercaPostazionePerTipoECitta(TipoPostazione tipo, String citta){
        return postazioneRepository.findByTipoAndCitta(tipo, citta);
    }
}
