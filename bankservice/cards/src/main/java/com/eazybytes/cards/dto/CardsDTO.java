package com.eazybytes.cards.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(
    name = "Cards",
    description = "Schema to hold card information"
)
public class CardsDTO {

    @Schema(
        description = "mobile number of customer",
        example = "5678638363"
    )
    @Pattern(regexp = "(^$|[0-9]{10})")
    private String mobileNumber;

    @Schema(
        description = "card number of customer",
        example = "100234006737"
    )
    private String cardNumber;

    @Schema(
        description = "type of the card",
        example = "credit card"
    )
    private String cardType;

    @Schema(
        description = "total amount limit available against a card",
        example = "100000"
    )
    private int totalLimit;

    @Schema(
        description = "total amount used by a customer",
        example = "10000"
    )
    private int amountUsed;

    @Schema(
        description = "total available amount against a card",
        example = "90000"
    )
    private int availableAmount;

    public CardsDTO() {

    }
}
