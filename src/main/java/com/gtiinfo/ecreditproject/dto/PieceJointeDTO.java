package com.gtiinfo.ecreditproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PieceJointeDTO {
    private Long id;
    private String fileName;
    private String chemin;
    private Long demandeId;
}
