package com.eazybytes.loans.controller;

import com.eazybytes.loans.constants.LoansConstant;
import com.eazybytes.loans.dto.ErrorResponseDTO;
import com.eazybytes.loans.dto.LoansDTO;
import com.eazybytes.loans.dto.ResponseDTO;
import com.eazybytes.loans.service.ILoansService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
/*
* @author Eazybank
* */
@Tag(
    name = "CRUD REST APIs for Loan in Eazybank",
    description = "CRUD REST APIs in Eazybank to CREATE, UPDATE, FETCH, DELETE loans detail"
)
@RequestMapping(path = "api", produces = {MediaType.APPLICATION_JSON_VALUE})
@RestController
@Validated
public class LoansController {

    private ILoansService iLoansService;

    @Operation(
        summary = "Create Loan REST API",
        description = "REST API for create new loan inside eazybank"
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "201",
            description = "Http Status Created"
        ),
        @ApiResponse(
            responseCode = "500",
            description = "Http Status Internal Server Error",
            content = @Content(
                schema = @Schema(implementation = ErrorResponseDTO.class)
            )
        )
    })
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createLoan(@RequestParam
                                                  @Pattern(regexp = "(^$|[0-9]{10})", message = "mobile number must be equals to 10 digits") String mobileNumber) {
        iLoansService.createLoan(mobileNumber);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDTO(LoansConstant.STATUS_201, LoansConstant.MESSAGE_201));
    }

    @Operation(
        summary = "Fetch Loan REST API",
        description = "REST API for fetch loan details based on the mobile number"
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "201",
            description = "Http Status Created"
        ),
        @ApiResponse(
            responseCode = "500",
            description = "Http Status Internal Server Error",
            content = @Content(
                schema = @Schema(implementation = ErrorResponseDTO.class)
            )
        )
    })
    @GetMapping("/fetch")
    public ResponseEntity<LoansDTO> fetchLoanDetail(@RequestParam @Pattern(regexp = "(^$|[0-9]{10})", message = "mobile number must be equals to 10 digits") String mobileNumber) {
        LoansDTO loansDTO = iLoansService.fetchLoan(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(loansDTO);
    }

    @Operation(
        summary = "Updated Loan REST API",
        description = "REST API for updated the details based on mobile number"
    )
    @ApiResponses({
        @ApiResponse(
            responseCode = "201",
            description = "Http Status Created"
        ),
        @ApiResponse(
            responseCode = "417",
            description = "Http Status Expectation Failed"
        ),
        @ApiResponse(
            responseCode = "500",
            description = "Http Status Internal Server Error",
            content = @Content(
                schema = @Schema(implementation = ErrorResponseDTO.class)
            )
        )
    })
    @PutMapping("/update")
    public ResponseEntity<ResponseDTO> updateLoanDetail(@RequestBody @Valid LoansDTO loansDTO) {
        boolean isUpdated = iLoansService.updateLoan(loansDTO);
        if(isUpdated) {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(LoansConstant.STATUS_200, LoansConstant.MESSAGE_200));
        } else {
            return  ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseDTO(LoansConstant.STATUS_417, LoansConstant.MESSAGE_417_UPDATE));
        }
    }

    @ApiResponses({
        @ApiResponse(
            responseCode = "201",
            description = "Http Status Created"
        ),
        @ApiResponse(
            responseCode = "417",
            description = "Http Status Expectation Failed"
        ),
        @ApiResponse(
            responseCode = "500",
            description = "Http Status Internal Server Error",
            content = @Content(
                schema = @Schema(implementation = ErrorResponseDTO.class)
            )
        )
    })
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> deleteLoanDetail(@RequestParam @Pattern(regexp = "(^$|[0-9]{10})", message = "mobile number must be 10 digits") String mobileNumber) {
        boolean isDeleted = iLoansService.deleteLoan(mobileNumber);
        if(isDeleted) {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(LoansConstant.STATUS_200, LoansConstant.MESSAGE_200));
        } else {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseDTO(LoansConstant.STATUS_417, LoansConstant.MESSAGE_417_DELETE));
        }
    }
}
