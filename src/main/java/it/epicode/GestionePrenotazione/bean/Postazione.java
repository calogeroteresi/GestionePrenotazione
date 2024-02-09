package it.epicode.GestionePrenotazione.bean;

import it.epicode.GestionePrenotazione.enums.TipoPostazione;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Entity
@Data
@Table(name = "postazioni")
public class Postazione {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private int id;

    private String descrizione;

    @Enumerated(EnumType.STRING)
    private TipoPostazione tipo;

    private Integer numeroMassimoOccupanti;

    @ManyToOne
    @JoinColumn (name = "edificio_id", nullable = false)
    private Edificio edificio;

    @OneToMany(mappedBy = "postazione", fetch = FetchType.EAGER)
    private List<Prenotazione> prenotazioni;



}
