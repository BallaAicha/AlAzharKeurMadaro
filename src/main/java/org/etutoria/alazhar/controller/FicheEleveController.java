package org.etutoria.alazhar.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.etutoria.alazhar.dto.ErrorResponseDto;
import org.etutoria.alazhar.dto.FicheEleveDto;
import org.etutoria.alazhar.services.FicheEleveService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "CRUD REST APIs for FicheEleve",
        description = "CRUD REST APIs in Course-app to CREATE, UPDATE, FETCH AND DELETE FicheEleve details"
)
@RestController
@RequestMapping(path = "api/fiches", produces = {MediaType.APPLICATION_JSON_VALUE})
@CrossOrigin("*")
@AllArgsConstructor
public class FicheEleveController {
    private final FicheEleveService ficheEleveService;

    @Operation(
            summary = "Create FicheEleve REST API",
            description = "REST API to create a new fiche eleve inside Course-app"
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
    public ResponseEntity<FicheEleveDto> createFicheEleve(@RequestBody FicheEleveDto ficheEleveDto) {
        FicheEleveDto createdFicheEleve = ficheEleveService.createFicheEleve(ficheEleveDto);
        return new ResponseEntity<>(createdFicheEleve, HttpStatus.CREATED);
    }
}