package com.yourcast.feed.controller;

import com.yourcast.feed.models.dto.ArrestedDto;
import com.yourcast.feed.models.response.ArrestedResponse;
import lombok.extern.slf4j.Slf4j;
import com.yourcast.feed.services.ArrestedServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

import javax.validation.Valid;

@AllArgsConstructor
@Slf4j
@RestController(value = "Arrested account")
@RequestMapping("/api/v1/arrests")
public class ArrestedController {
    private final ArrestedServiceImpl arrestedService;

    @Operation(method = "findByIban", description = "Method to check arrested a account by IBAN", tags = {"Arrested"})
    @ApiResponses(value = {
        @ApiResponse(description = "IBAN not found.", responseCode = "404", content = {
                @Content(mediaType = "application/json")
        }),
        @ApiResponse(description = "IBAN found.", responseCode = "200", content = {
            @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = ArrestedResponse.class)
            )
        }),
        @ApiResponse(description = "Unknown Error.", responseCode = "500", content = {
                @Content(mediaType = "application/json")
        })
    })
    @GetMapping(value = "/{iban}")
    public ResponseEntity<?> findByIban(
        @Valid
        @Parameter(name = "iban", in = ParameterIn.PATH, required = true, description = "IBAN to search for")
        @PathVariable(value = "iban") String iban
    ) {
        LOG.info("[CONTROLLER] search by IBAN: {}", iban);
        try {
            ArrestedDto arrested = arrestedService.findByIban(iban);

            if (arrested == null) {
                LOG.info("[CONTROLLER] IBAN not found: {}" + iban);
                return ResponseEntity.notFound().build();
            }

            ArrestedResponse response = new ArrestedResponse();
            response.setArrested(arrested.isActive());

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            LOG.info("[CONTROLLER] exception: {}", e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}