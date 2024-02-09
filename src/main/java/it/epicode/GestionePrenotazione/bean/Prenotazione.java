package it.epicode.GestionePrenotazione.bean;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Slf4j
@Data
@Entity
@Table(
        name = "prenotazioni",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"id_utente", "data_prenotazione"}),
                @UniqueConstraint(columnNames = {"id_postazione", "data_prenotazione"})
        })
public class Prenotazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int id;

    @Column(name = "data_prenotazione")
    private LocalDate dataPrenotazione;

    @ManyToOne
    @JoinColumn(name = "postazione_id")
    private Postazione postazione;

    @ManyToOne
    @JoinColumn(name ="utente_id")
    private Utente utente;


}
