package org.etutoria.alazhar.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Schema(name = "Niveau", description = "Schema to hold Niveau information")
@Data
public class NiveauDto {
    @Schema(description = "ID of the niveau", example = "1")
    private Long niveauId;

    @NotEmpty(message = "Niveau name cannot be null or empty")
    @Schema(description = "Name of the niveau", example = "Primary")
    private String niveauName;

    @Schema(description = "Mensualite of the niveau", example = "1000.0")
    private double mensualite;

    @Schema(description = "Frais d'inscription of the niveau", example = "200.0")
    private double fraisInscription;

    @Schema(description = "Frais de scolarite of the niveau", example = "300.0")
    private double fraisScolarite;

    @Schema(description = "Minimum age for the niveau", example = "6")
    private int ageMin;

    @Schema(description = "Maximum age for the niveau", example = "12")
    private int ageMax;

    @NotEmpty(message = "Critere d'admission cannot be null or empty")
    @Schema(description = "Critere d'admission for the niveau", example = "Pass entrance exam")
    private String critereAdmission;

    @NotEmpty(message = "Critere de passage cannot be null or empty")
    @Schema(description = "Critere de passage for the niveau", example = "Pass final exam")
    private String criterePassage;
}