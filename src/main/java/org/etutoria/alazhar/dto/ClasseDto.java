package org.etutoria.alazhar.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Schema(name = "Classe", description = "Schema to hold Classe information")
@Data
public class ClasseDto {
    @Schema(description = "ID of the class", example = "1")
    private Long classId;

    @NotEmpty(message = "Class name cannot be null or empty")
    @Size(max = 45, message = "Class name must be at most 45 characters")
    @Schema(description = "Name of the class", example = "Math 101")
    private String className;

    @Schema(description = "Size of the class", example = "30")
    private int classSize;

    @Schema(description = "Number of benches in the class", example = "15")
    private int classBench;

    @Schema(description = "Niveau associated with the class")
    private NiveauDto niveau;

    @Schema(description = "List of courses associated with the class")
    private Set<CourseDto> courses = new HashSet<>();

    @Schema(description = "List of inscriptions associated with the class")
    private Set<InscriptionDto> inscriptions = new HashSet<>();
}