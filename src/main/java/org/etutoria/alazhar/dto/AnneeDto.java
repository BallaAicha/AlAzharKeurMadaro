package org.etutoria.alazhar.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.etutoria.alazhar.entities.ANNEE;

@Schema(name = "Annee", description = "Schema to hold Annee information")
@Data
public class AnneeDto {
    @Schema(description = "ID of the annee", example = "1")
    private Long id;

    @NotEmpty(message = "Annee cannot be null or empty")
    @Schema(description = "Annee", example = "2026-2027")
    private String annee;

    public ANNEE toEntity() {
        ANNEE anneeEntity = new ANNEE();
        anneeEntity.setId(this.id);
        anneeEntity.setAnnee(this.annee);
        return anneeEntity;
    }
}