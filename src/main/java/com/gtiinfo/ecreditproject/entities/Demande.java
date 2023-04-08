package com.gtiinfo.ecreditproject.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@Data
public class Demande {

    @Id
    @SequenceGenerator(name = "demande_seq", sequenceName = "DEMANDE_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "demande_seq")
    private Long id;
    private String nom;
    private String prenom;
    private String TypePieceIdentite;
    private String NumPieceIdentité;
    private String numCompte;
    private String GSM;
    private LocalDateTime dateCompte;
    private LocalDateTime dateNaissance;
    private String TypeCredit;
    private int montant;
    private int nbreEcheance;

    @OneToMany(mappedBy = "demande")
    private List<PieceJointe> pieceJointes;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;



    @OneToOne(mappedBy = "demande", cascade = CascadeType.ALL)
    private Garentie garentie;

    @OneToOne(mappedBy = "demande", cascade = CascadeType.ALL)
    private EtatDemande etatDemande;
}
