package com.gtiinfo.ecreditproject.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


@Entity
@Getter
@Setter
@Data
@Table(name = "demandes")
public class Demande implements Serializable {

    @Id
    @SequenceGenerator(name = "demande_seq", sequenceName = "DEMANDE_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "demande_seq")
    private Long id;
    private String nom;
    private String prenom;
    private String typePieceIdentite;
    private String numPieceIdentite;
    private String numCompte;
    private String GSM;
    private LocalDateTime dateCompte;
    private LocalDateTime dateNaissance;
    private String typeCredit;
    private int montant;
    private int nbreEcheance;

    @OneToMany(mappedBy = "demande", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<PieceJointe> pieceJointes= new HashSet<>();


    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "simulation_id")
    private Simulation simulation;


    @OneToMany(mappedBy = "demande", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Garentie> garenties= new HashSet<>();


    @OneToOne(mappedBy = "demande", cascade  = CascadeType.PERSIST

    )
    private EtatDemande etatDemande;
}
