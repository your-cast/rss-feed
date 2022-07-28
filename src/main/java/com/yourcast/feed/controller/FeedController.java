package com.yourcast.feed.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

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

import com.yourcast.feed.models.FeedResponse;

import javax.validation.Valid;

@Slf4j
@AllArgsConstructor
@RestController(value = "RSS Feed Controller")
@RequestMapping("/api/v1/feed")
public class FeedController {
    @Operation(method = "generateByToken", description = "Method to check arrested a account by IBAN", tags = {"Feed"})
    @ApiResponses(value = {
        @ApiResponse(description = "IBAN not found.", responseCode = "404", content = {
                @Content(mediaType = "application/json")
        }),
        @ApiResponse(description = "IBAN found.", responseCode = "200", content = {
            @Content(
                mediaType = "application/json",
                schema = @Schema(implementation = FeedResponse.class)
            )
        }),
        @ApiResponse(description = "Unknown Error.", responseCode = "500", content = {
                @Content(mediaType = "application/json")
        })
    })
    @GetMapping(value = "/{token}")
    public ResponseEntity<?> generateByToken(
        @Valid
        @Parameter(name = "token", in = ParameterIn.PATH, required = true, description = "token for generate")
        @PathVariable(value = "token") String token
    ) {
        LOG.info("Generate feed by token: {}", token);
        try {
            if (token == null) {
                return ResponseEntity.notFound().build();
            }

            FeedResponse response = new FeedResponse();
            response.setToken(token);

            return ResponseEntity.ok(response);
        } catch (Exception exception) {
            LOG.error("Exception: {}", exception.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}