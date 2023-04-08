package com.gtiinfo.ecreditproject.entities;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class PieceJointe {
    @Id
    @SequenceGenerator(name = "piece_jointe_seq", sequenceName = "PIECE_JOINTE_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "piece_jointe_seq")
    private Long id;
    private String fileName;
    private String chemin;

    @ManyToOne
    @JoinColumn(name = "demande_id")
    private Demande demande;
}