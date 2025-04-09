package ru.atc.smartbudget.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.atc.smartbudget.dto.income.IncomeDetail;
import ru.atc.smartbudget.dto.income.EditIncome;
import ru.atc.smartbudget.services.IncomeService;

@AllArgsConstructor
@RestController
@Tag(name = "Доходы")
@RequestMapping("/api/v1/incomes")
public class IncomeController {
    private final IncomeService incomeService;


    @Operation(summary = "Доход по ID")
    @GetMapping("/{id}")
    public IncomeDetail getIncomeById(@PathVariable Long id) {
        return this.incomeService.getIncomeById(id);
    }

    @Operation(summary = "Редактирование дохода по ID")
    @PutMapping("/{id}")
    public IncomeDetail updateIncomeById(@PathVariable Long id, EditIncome data) {
        return this.incomeService.updateIncomeById(id, data);
    }


}
