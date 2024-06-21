package com.eazybytes.loans.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@Schema(
    name = "error response", description = "Schema holds to error information"
)
public class ErrorResponseDTO {

    @Schema(
        description = "api path invoked by client"
    )
    private String apiPath;

    @Schema(
        description = "error code representing the error happened"
    )
    private HttpStatus statusCode;

    @Schema(
        description = "error message representing the error happened"
    )
    private String errorMessage;

    @Schema(
        description = "time representing when the error happened"
    )
    private LocalDateTime errorTime;
}
