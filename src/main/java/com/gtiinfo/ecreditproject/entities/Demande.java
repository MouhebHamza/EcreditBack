package com.gtiinfo.ecreditproject.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;


@Entity
@Data
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
    private Set<PieceJointe> pieceJointes;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;



    @OneToMany(mappedBy = "demande", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Garentie> garenties;


    @OneToOne(mappedBy = "demande", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private EtatDemande etatDemande;
}
