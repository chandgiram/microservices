package com.eazybytes.loans.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(
    name = "Response", description = "Schema to holds response information"
)
public class ResponseDTO {

    @Schema(
        description = "status code in the response"
    )
    private String statusCode;

    @Schema(
        description = "status message in the response"
    )
    private String statusMessage;
}
