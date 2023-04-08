package com.gtiinfo.ecreditproject.entities;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Garentie {
    @Id
    @SequenceGenerator(name = "garentie_seq", sequenceName = "GARENTIE_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "garentie_seq")
    private Long id;
    private String natureGarentie;
    private String typeGarentie;
    private int montantGarentie;

    @OneToOne
    @JoinColumn(name = "demande_id")
    private Demande demande;
}