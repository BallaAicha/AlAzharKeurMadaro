package org.etutoria.alazhar.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Schema(name = "Mois", description = "Schema to hold Mois information")
@Data
public class MoisDto {
    @Schema(description = "ID of the mois", example = "1")
    private Long id;

    @NotEmpty(message = "Mois cannot be null or empty")
    @Schema(description = "Mois", example = "January")
    private String mois;
}