package com.eazybytes.loans.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Schema(
    name = "Loan",
    description = "Schema holds to loan information"
)
public class LoansDTO {

    @NotEmpty(message = "mobile number can not be null or empty")
    @Pattern(regexp = "(^$|[0-9]){10}", message = "mobile number must be 10 digits")
    @Schema(
        description = "mobile number of costumer", example = "8393739393"
    )
    private String mobileNumber;

    @NotEmpty(message = "loan number can not be null or empty")
    @Pattern(regexp = "(^$|[0-9]{12})", message = "mobile number must be 12 digits")
    @Schema(
        description = "loan number of customer", example = "974379883423"
    )
    private String loanNumber;

    @NotEmpty(message = "loan type can be a null or empty")
    @Schema(
        description = "type of loan", example = "home loan"
    )
    private String loanType;

    @Positive(message = "total loan amount should be greater than zero")
    @Schema(
        description = "total loan amount", example = "100000"
    )
    private int totalLoan;

    @PositiveOrZero(message = "total loan amount paid should be greater than zero or equal zero")
    @Schema(
        description = "total loan amount paid", example = "10000"
    )
    private int amountPaid;

    @PositiveOrZero(message = "total out standing amount paid should be greater than zero or equal zero")
    @Schema(
        description = "total outStanding amount against a loan", example = "99000"
    )
    private int outStandingAmount;
}
