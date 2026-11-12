package org.example.expenses.expense;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record CreateExpenseRequest(
        @NotBlank String description,
        @NotNull @DecimalMin(value = "0.01") BigDecimal amount
) {
}
