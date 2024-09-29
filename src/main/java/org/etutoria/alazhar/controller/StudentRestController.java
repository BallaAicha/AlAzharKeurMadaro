package org.etutoria.alazhar.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.etutoria.alazhar.dto.ErrorResponseDto;
import org.etutoria.alazhar.dto.StudentDto;
import org.etutoria.alazhar.services.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "CRUD REST APIs for Students",
        description = "CRUD REST APIs in Course-app to CREATE, UPDATE, FETCH AND DELETE student details"
)
@RestController
@RequestMapping(path = "api/students", produces = {MediaType.APPLICATION_JSON_VALUE})
@CrossOrigin("*")
@AllArgsConstructor
public class StudentRestController {
    private final IStudentService studentService;


    @Operation(
            summary = "Create Student REST API",
            description = "REST API to create a new student inside Course-app"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "HTTP Status Created"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "HTTP Status Bad Request",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto) {
        StudentDto createdStudent = studentService.createStudent(studentDto);
        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }
}