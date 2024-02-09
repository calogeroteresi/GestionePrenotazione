package it.epicode.GestionePrenotazione.repository;

import it.epicode.GestionePrenotazione.bean.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UtenteRepository  extends JpaRepository<Utente, Integer> {
}
