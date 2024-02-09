package it.epicode.GestionePrenotazione.service;

import it.epicode.GestionePrenotazione.bean.Edificio;
import it.epicode.GestionePrenotazione.repository.EdificioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EdificioService {

    @Autowired
    private EdificioRepository edificioRepository;
    private final Logger logger = LoggerFactory.getLogger("gestionePrenotazione");


    public void salvaEdificio(Edificio e) {
        try {
            edificioRepository.save(e);
        } catch (Exception exception) {
            logger.error(exception.getMessage());
        }
    }

    public void aggiornaEdificio(Edificio e) {
        try {
            Edificio edificio = edificioRepository.findById(e.getId()).get();
            edificio.setNome(e.getNome());
            edificio.setCitta(e.getCitta());
            edificio.setIndirizzo(e.getIndirizzo());
            edificioRepository.save(edificio);
        } catch (Exception exception) {
            logger.error(exception.getMessage());
        }
    }

    public Optional<Edificio> cercaEdificioPerId(int id) {
        try {
            return edificioRepository.findById(id);
        } catch (Exception ex) {
            logger.error("Errore durante la ricerca dell'edificio per ID", ex);
            return Optional.empty();
        }
    }

    public void eliminaEdificio(int id) {
        try {
            edificioRepository.deleteById(id);
        } catch (Exception e) {
            logger.error("Errore durante l'eliminazione dell'edificio con ID: " + id, e);
        }
    }
}
