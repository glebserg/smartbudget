package ru.atc.smartbudget.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.atc.smartbudget.dto.incomeCategory.IncomeCategoryDetail;
import ru.atc.smartbudget.dto.incomeCategory.EditIncomeCategory;
import ru.atc.smartbudget.services.IncomeCategoryService;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/income-categories")
@Tag(name = "Категории доходов")
public class IncomeCategoryController {
    private final IncomeCategoryService incomeCategoryService;


    @Operation(summary = "Категория дохода по ID")
    @GetMapping("/{id}")
    public IncomeCategoryDetail getIncomeCategoryById(@PathVariable Long id) {
        return this.incomeCategoryService.getIncomeCategoryById(id);
    }

    @Operation(summary = "Редактирование категории дохода по ID")
    @PutMapping("/{id}")
    public IncomeCategoryDetail updateIncomeCategoryById(
            @PathVariable Long id,
            @RequestBody EditIncomeCategory data
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
