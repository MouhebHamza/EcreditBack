package com.gtiinfo.ecreditproject.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EtatDemandeDTO {
    private Long id;
    private String etape;
    private String enAttente;
    private Long demandeId;
}
