package org.etutoria.alazhar.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.etutoria.alazhar.dto.ErrorResponseDto;
import org.etutoria.alazhar.dto.PaiementDto;
import org.etutoria.alazhar.services.PaiementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "CRUD REST APIs for Payment",
        description = "CRUD REST APIs in Course-app to CREATE, UPDATE, FETCH AND DELETE Payment details"
)
@RestController
@RequestMapping(path = "api/payments", produces = {MediaType.APPLICATION_JSON_VALUE})
@CrossOrigin("*")
@AllArgsConstructor
public class PaymentController {
    private final PaiementService paymentService;

    @Operation(
            summary = "Create Payment REST API",
            description = "REST API to create a new payment inside Course-app"
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
    public ResponseEntity<PaiementDto> createPayment(@RequestBody PaiementDto paiementDto) {
        PaiementDto createdPaiement = paymentService.createPaiement(paiementDto);
        return new ResponseEntity<>(createdPaiement, HttpStatus.CREATED);
    }
}