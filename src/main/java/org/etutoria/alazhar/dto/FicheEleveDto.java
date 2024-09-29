package org.etutoria.alazhar.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Schema(name = "FicheEleve", description = "Schema to hold FicheEleve information")
@Data
public class FicheEleveDto {
    @Schema(description = "ID of the fiche", example = "1")
    private Long id;

    @NotEmpty(message = "Type of fiche cannot be null or empty")
    @Schema(description = "Type of fiche", example = "TYPE1")
    private String typeFiche;

    @Schema(description = "Student associated with the fiche")
    private StudentDto student;

    @Schema(description = "Annee associated with the fiche")
    private AnneeDto annee;
}