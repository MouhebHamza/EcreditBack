package com.gtiinfo.ecreditproject.entities;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@Table(name = "garenties")
public class Garentie implements Serializable {
    @Id
    @SequenceGenerator(name = "garentie_seq", sequenceName = "GARENTIE_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "garentie_seq")
    private Long id;
    private String natureGarentie;
    private String typeGarentie;
    private int montantGarentie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "demande_id")
    private Demande demande;
}