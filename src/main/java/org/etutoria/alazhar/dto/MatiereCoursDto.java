package org.etutoria.alazhar.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Schema(name = "MatiereCours", description = "Schema to hold MatiereCours information")
@Data
public class MatiereCoursDto {
    @Schema(description = "ID of the matiere cours", example = "1")
    private Long matiereCoursId;

    @NotEmpty(message = "Matiere name cannot be null or empty")
    @Size(max = 45, message = "Matiere name must be at most 45 characters")
    @Schema(description = "Name of the matiere", example = "Algebra")
    private String matiereName;

    @NotEmpty(message = "Matiere description cannot be null or empty")
    @Size(max = 64, message = "Matiere description must be at most 64 characters")
    @Schema(description = "Description of the matiere", example = "Basic algebra course")
    private String matiereDescription;

    @Schema(description = "Course associated with the matiere cours")
    private CourseDto course;
}