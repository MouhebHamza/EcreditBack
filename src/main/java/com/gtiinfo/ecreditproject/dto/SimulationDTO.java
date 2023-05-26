package com.gtiinfo.ecreditproject.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SimulationDTO {
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
    private String resultat;
    private Long userId;
    private Set<Long> demandesIds;
}
