package org.etutoria.alazhar.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Schema(name = "Paiement", description = "Schema to hold Paiement information")
@Data
public class PaiementDto {
    @Schema(description = "ID of the paiement", example = "1")
    private Long id;

    @NotEmpty(message = "Montant cannot be null or empty")
    @Schema(description = "Montant of the paiement", example = "500")
    private String montant;

    @NotEmpty(message = "Type of paiement cannot be null or empty")
    @Schema(description = "Type of paiement", example = "CASH")
    private String typePaiement;

    @Schema(description = "Annee associated with the paiement")
    private AnneeDto annee;

    @Schema(description = "Mois associated with the paiement")
    private MoisDto mois;

    @Schema(description = "Student associated with the paiement")
    private StudentDto student;
}