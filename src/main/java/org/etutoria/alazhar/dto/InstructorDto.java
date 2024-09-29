package org.etutoria.alazhar.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Schema(name = "Instructor", description = "Schema to hold Instructor information")
@Data
public class InstructorDto {
    @Schema(description = "ID of the instructor", example = "1")
    private Long instructorId;

    @NotEmpty(message = "First name cannot be null or empty")
    @Size(max = 45, message = "First name must be at most 45 characters")
    @Schema(description = "First name of the instructor", example = "John")
    private String firstName;

    @NotEmpty(message = "Last name cannot be null or empty")
    @Size(max = 45, message = "Last name must be at most 45 characters")
    @Schema(description = "Last name of the instructor", example = "Doe")
    private String lastName;

    @NotEmpty(message = "Summary cannot be null or empty")
    @Size(max = 64, message = "Summary must be at most 64 characters")
    @Schema(description = "Summary of the instructor", example = "Experienced math teacher")
    private String summary;

    @NotEmpty(message = "Phone cannot be null or empty")
    @Size(max = 45, message = "Phone must be at most 45 characters")
    @Schema(description = "Phone number of the instructor", example = "123456789")
    private String phone;

    @NotEmpty(message = "Photo cannot be null or empty")
    @Size(max = 45, message = "Photo must be at most 45 characters")
    @Schema(description = "Photo URL of the instructor", example = "http://example.com/photo.jpg")
    private String photo;

    @NotEmpty(message = "Salary cannot be null or empty")
    @Size(max = 45, message = "Salary must be at most 45 characters")
    @Schema(description = "Salary of the instructor", example = "5000")
    private String salary;

    @Schema(description = "User associated with the instructor")
    private UserDto user;

    @Schema(description = "List of course IDs associated with the instructor")
    private Set<Long> courseIds = new HashSet<>();
}