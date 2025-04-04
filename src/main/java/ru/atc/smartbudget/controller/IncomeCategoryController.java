package ru.atc.smartbudget.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.atc.smartbudget.dto.incomeCategory.GetIncomeCategory;
import ru.atc.smartbudget.dto.incomeCategory.PutIncomeCategory;
import ru.atc.smartbudget.services.IncomeCategoryService;

@RestController
@RequestMapping("/api/v1/income-categories")
@Tag(name = "Категории доходов")
public class IncomeCategoryController {
    private final IncomeCategoryService incomeCategoryService;

    public IncomeCategoryController(IncomeCategoryService incomeCategoryService) {
        this.incomeCategoryService = incomeCategoryService;
    }


    @Operation(summary = "Категория дохода по ID")
    @GetMapping("/{id}")
    public GetIncomeCategory getIncomeCategoryById(@PathVariable Long id) {
        return this.incomeCategoryService.getIncomeCategoryById(id);
    }

    @Operation(summary = "Редактирование категории дохода по ID")
    @PutMapping("/{id}")
    public GetIncomeCategory updateIncomeCategoryById(
            @PathVariable Long id,
            @RequestBody PutIncomeCategory data
    ) {
        return this.incomeCategoryService.updateIncomeCategoryById(id, data);
    }

    @Operation(summary = "Удаление категории дохода по ID")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteIncomeCategoryById(@PathVariable Long id) {
        this.incomeCategoryService.deleteIncomeCategoryById(id);
    }

}
