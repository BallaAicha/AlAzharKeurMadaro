package org.etutoria.alazhar.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Schema(name = "Student", description = "Schema to hold Student information")
@Data
public class StudentDto {
    @Schema(description = "ID of the student", example = "1")
    private Long studentId;

    @NotEmpty(message = "First name cannot be null or empty")
    @Size(max = 45, message = "First name must be at most 45 characters")
    @Schema(description = "First name of the student", example = "Jane")
    private String firstName;

    @NotEmpty(message = "Last name cannot be null or empty")
    @Size(max = 45, message = "Last name must be at most 45 characters")
    @Schema(description = "Last name of the student", example = "Smith")
    private String lastName;

    @NotEmpty(message = "Date of birth cannot be null or empty")
    @Size(max = 45, message = "Date of birth must be at most 45 characters")
    @Schema(description = "Date of birth of the student", example = "01/01/2000")
    private String dateNaissance;

    @NotEmpty(message = "Address cannot be null or empty")
    @Size(max = 45, message = "Address must be at most 45 characters")
    @Schema(description = "Address of the student", example = "1234 Main St")
    private String address;

    @NotEmpty(message = "Genre cannot be null or empty")
    @Size(max = 45, message = "Genre must be at most 45 characters")
    @Schema(description = "Genre of the student", example = "F OR M")
    private String genre;

    @Schema(description = "User associated with the student")
    private UserDto user;

    @Schema(description = "List of fiches associated with the student")
    private Set<FicheEleveDto> fiches = new HashSet<>();

    @Schema(description = "Inscription associated with the student")
    private InscriptionDto inscription;

    @Schema(description = "Tuteur associated with the student")
    private TuteurDto tuteur;

    @Schema(description = "List of paiements associated with the student")
    private Set<PaiementDto> paiements = new HashSet<>();
}