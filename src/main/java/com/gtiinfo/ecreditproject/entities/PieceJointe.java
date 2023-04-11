package com.gtiinfo.ecreditproject.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;


@Entity
@Data
public class PieceJointe implements Serializable {
    @Id
    @SequenceGenerator(name = "piece_jointe_seq", sequenceName = "PIECE_JOINTE_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "piece_jointe_seq")
    private Long id;
    private String fileName;
    private String chemin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "demande_id")
    private Demande demande;
}