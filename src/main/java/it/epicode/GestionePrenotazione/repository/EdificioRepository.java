package it.epicode.GestionePrenotazione.repository;

import it.epicode.GestionePrenotazione.bean.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EdificioRepository extends JpaRepository<Edificio, Integer> {
}
