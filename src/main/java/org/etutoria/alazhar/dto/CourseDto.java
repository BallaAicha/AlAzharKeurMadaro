package org.etutoria.alazhar.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Schema(name = "Course", description = "Schema to hold Course information")
@Data
public class CourseDto {
    @Schema(description = "ID of the course", example = "1")
    private Long courseId;

    @NotEmpty(message = "Course name cannot be null or empty")
    @Size(max = 45, message = "Course name must be at most 45 characters")
    @Schema(description = "Name of the course", example = "Math 101")
    private String courseName;

    @NotEmpty(message = "Course duration cannot be null or empty")
    @Size(max = 45, message = "Course duration must be at most 45 characters")
    @Schema(description = "Duration of the course", example = "3 months")
    private String courseDuration;

    @NotEmpty(message = "Course description cannot be null or empty")
    @Size(max = 64, message = "Course description must be at most 64 characters")
    @Schema(description = "Description of the course", example = "Basic mathematics")
    private String courseDescription;

    @Schema(description = "Instructor ID associated with the course")
    private Long instructorId;

    @Schema(description = "List of matiere cours associated with the course")
    private Set<MatiereCoursDto> matiereCours = new HashSet<>();

    @Schema(description = "Class associated with the course")
    private ClasseDto classe;
}