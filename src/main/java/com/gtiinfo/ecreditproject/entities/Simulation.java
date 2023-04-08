package com.gtiinfo.ecreditproject.entities;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Simulation {



    @Id
    @SequenceGenerator(name = "simulation_seq", sequenceName = "SIMULATION_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "simulation_seq")
    private Long id;
    private String nom;
    private String prenom;
    private String TypePieceIdentite;
    private String NumPieceIdentité;
    private String numCompte;
    private LocalDateTime dateCompte;
    private LocalDateTime dateNaissance;
    private String sitFamiliale;
    private String sitMedicale;
    private String sitProfessionnel;
    private String GSM;
    private String TypeCredit;
    private int montant;
    private int nbreEcheance;
    private String PayementPar;
    private int salaireAnnuel;
    private int autreRevenu;
    private String sitLogement;
    @Column(name = "Resultat")

    private String resultat;
}
