package org.etutoria.alazhar.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Set;

@Schema(name = "Tuteur", description = "Schema to hold Tuteur information")
@Data
public class TuteurDto {
    @Schema(description = "ID of the tuteur", example = "1")
    private Long tuteurId;

    @NotEmpty(message = "First name cannot be null or empty")
    @Size(max = 45, message = "First name must be at most 45 characters")
    @Schema(description = "First name of the tuteur", example = "John")
    private String firstName;

    @NotEmpty(message = "Last name cannot be null or empty")
    @Size(max = 45, message = "Last name must be at most 45 characters")
    @Schema(description = "Last name of the tuteur", example = "Doe")
    private String lastName;

    @NotEmpty(message = "Number cannot be null or empty")
    @Size(max = 45, message = "Number must be at most 45 characters")
    @Schema(description = "Number of the tuteur", example = "123456789")
    private String number;

    @NotEmpty(message = "Email cannot be null or empty")
    @Size(max = 45, message = "Email must be at most 45 characters")
    @Schema(description = "Email of the tuteur", example = "john.doe@example.com")
    private String email;

    @NotEmpty(message = "Address cannot be null or empty")
    @Size(max = 45, message = "Address must be at most 45 characters")
    @Schema(description = "Address of the tuteur", example = "1234 Main St")
    private String address;

    @Schema(description = "List of students associated with the tuteur")
    private Set<StudentDto> students;
}