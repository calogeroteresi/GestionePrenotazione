package it.epicode.GestionePrenotazione.bean;

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
@Table (name="edifici")

public class Edificio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private int id;

    private String nome;

    private String indirizzo;

    private String citta;

    @OneToMany(mappedBy = "edificio", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Postazione> postazioni;

}
