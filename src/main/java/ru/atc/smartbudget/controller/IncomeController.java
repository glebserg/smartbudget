package ru.atc.smartbudget.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
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


    @GetMapping("/{id}")
    public DBIncome getIncomeById(@PathVariable Long id) {
        try {
            return incomeService.getIncomeById(id);
        } catch (NoSuchElementException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
