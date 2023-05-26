package com.gtiinfo.ecreditproject.dto;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.gtiinfo.ecreditproject.entities.Garentie;
import com.gtiinfo.ecreditproject.entities.PieceJointe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DemandeDTO {

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


}
