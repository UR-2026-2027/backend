package org.example.expenses.expense;

import java.math.BigDecimal;

public record Expense(Long id, String description, BigDecimal amount) {
}
