package ru.atc.smartbudget.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.atc.smartbudget.dto.income.GetIncome;
import ru.atc.smartbudget.dto.income.PutIncome;
import ru.atc.smartbudget.dto.user.GetUser;
import ru.atc.smartbudget.model.DBIncome;
import ru.atc.smartbudget.services.IncomeService;

import java.util.NoSuchElementException;

@RestController
@Tag(name = "Доходы")
@RequestMapping("/api/v1/incomes")
public class IncomeController {
    private final IncomeService incomeService;

    public IncomeController(IncomeService incomeService) {
        this.incomeService = incomeService;
    }

    @Operation(summary = "Доход по ID")
    @GetMapping("/{id}")
    public GetIncome getIncomeById(@PathVariable Long id) {
        return this.incomeService.getIncomeById(id);
    }

    @Operation(summary = "Редактирование дохода по ID")
    @PutMapping("/{id}")
    public GetIncome updateIncomeById(@PathVariable Long id, PutIncome data) {
        return this.incomeService.updateIncomeById(id, data);
    }


}
