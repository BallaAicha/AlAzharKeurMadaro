package org.etutoria.alazhar.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Schema(name = "Inscription", description = "Schema to hold Inscription information")
@Data
public class InscriptionDto {
    @Schema(description = "ID of the inscription", example = "1")
    private Long id;

    @NotEmpty(message = "Date of inscription cannot be null or empty")
    @Schema(description = "Date of inscription", example = "2024-10-10")
    private String dateInscription;

    @NotEmpty(message = "Montant cannot be null or empty")
    @Schema(description = "Montant of the inscription", example = "1000")
    private String montant;

    @NotEmpty(message = "Status cannot be null or empty")
    @Schema(description = "Status of the inscription", example = "PAID")
    private String status;

    @Schema(description = "Annee associated with the inscription")
    private AnneeDto annee;

    @Schema(description = "Classe associated with the inscription")
    private ClasseDto classe;

    @Schema(description = "Student associated with the inscription")
    private StudentDto student;
}