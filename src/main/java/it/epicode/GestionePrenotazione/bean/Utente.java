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
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int id;

    private String username;

    @Column(name = "nome_completo")
    private String nomeCompleto;

    private String email;

    @OneToMany(mappedBy = "utente", fetch = FetchType.EAGER)
    private List<Prenotazione> prenotazioni;

}
