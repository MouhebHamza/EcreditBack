package com.gtiinfo.ecreditproject.entities;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@Data
@Table(name = "etat_demandes")
public class EtatDemande implements Serializable {


    @Id
    @SequenceGenerator(name = "etat_demande_seq", sequenceName = "ETAT_DEMANDE_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "etat_demande_seq")
    private Long id;
    private String etape;
    private String enAttente;

    @OneToOne(optional = false)
    @PrimaryKeyJoinColumn
    private Demande demande;
}