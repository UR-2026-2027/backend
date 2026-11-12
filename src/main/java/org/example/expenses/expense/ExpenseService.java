package org.example.expenses.expense;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ExpenseService {

    private final List<Expense> expenses = new CopyOnWriteArrayList<>();
    private final AtomicLong nextId = new AtomicLong(1);

    public ExpenseService() {
        this.expenses.add(new Expense(nextId.getAndIncrement(), "Lunch", new BigDecimal("12.50")));
        this.expenses.add(new Expense(nextId.getAndIncrement(), "Cos", new BigDecimal("15.00")));
        this.expenses.add(new Expense(nextId.getAndIncrement(), "Cos2", new BigDecimal("30.00")));
    }

    public List<Expense> findAll(String description, BigDecimal amount) {
        return expenses.stream()
                .filter(expense -> description == null
                        || expense.description().toLowerCase(Locale.ROOT)
                        .contains(description.toLowerCase(Locale.ROOT)))
                .filter(expense -> amount == null || expense.amount().compareTo(amount) == 0)
                .toList();
    }

    public Expense add(CreateExpenseRequest request) {
        Expense expense = new Expense(
                nextId.getAndIncrement(),
                request.description().trim(),
                request.amount()
        );
        expenses.add(expense);
        return expense;
    }
}
