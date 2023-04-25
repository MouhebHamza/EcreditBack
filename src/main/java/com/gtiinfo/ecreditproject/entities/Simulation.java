package com.gtiinfo.ecreditproject.entities;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "simulations")
public class Simulation implements Serializable {



    @Id
    @SequenceGenerator(name = "simulation_seq", sequenceName = "SIMULATION_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "simulation_seq")
    private Long id;
    private String nom;
    private String prenom;
    private String typePieceIdentite;
    private String numPieceIdentite;
    private String numCompte;
    private LocalDateTime dateCompte;
    private LocalDateTime dateNaissance;
    private String sitFamiliale;
    private String sitMedicale;
    private String sitProfessionnel;
    private String gsm;
    private String typeCredit;
    private int montant;
    private int nbreEcheance;
    private String payementPar;
    private int salaireAnnuel;
    private int autreRevenu;
    private String sitLogement;
    @Column(name = "Resultat")

    private String resultat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "simulation", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Demande> demandes= new HashSet<>();

}
