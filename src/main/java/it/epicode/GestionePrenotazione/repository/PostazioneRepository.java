package it.epicode.GestionePrenotazione.repository;

import it.epicode.GestionePrenotazione.bean.Postazione;
import it.epicode.GestionePrenotazione.enums.TipoPostazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PostazioneRepository  extends JpaRepository<Postazione, Integer> {



    @Query("SELECT p FROM Postazione p WHERE p.tipo = :tipo AND p.edificio.citta = :citta")
    public List<Postazione> findByTipoAndCitta(TipoPostazione tipo, String citta);





}
