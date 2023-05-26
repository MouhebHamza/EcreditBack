package com.gtiinfo.ecreditproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GarentieDTO {
    private Long id;
    private String natureGarentie;
    private String typeGarentie;
    private int montantGarentie;
    private Long demandeId;
}
