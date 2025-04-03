package ru.atc.smartbudget.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.atc.smartbudget.dto.incomeCategory.GetIncomeCategory;
import ru.atc.smartbudget.dto.incomeCategory.PutIncomeCategory;
import ru.atc.smartbudget.dto.outlayCategory.GetOutlayCategory;
import ru.atc.smartbudget.dto.outlayCategory.PutOutlayCategory;
import ru.atc.smartbudget.model.DBOutlayCategory;
import ru.atc.smartbudget.services.OutlayCategoryService;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1/outlay-categories")
@Tag(name = "Категории расходов")
public class OutlayCategoryController {
    private final OutlayCategoryService outlayCategoryService;

    public OutlayCategoryController(OutlayCategoryService outlayCategoryService) {
        this.outlayCategoryService = outlayCategoryService;
    }

    @Operation(summary = "Категория расхода по ID")
    @GetMapping("/{id}")
    public GetOutlayCategory getOutlayCategoryById(@PathVariable Long id) {
        return this.outlayCategoryService.getOutlayCategoryById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Outlay category not found"));
    }

    @Operation(summary = "Редактирование категории расхода по ID")
    @PutMapping("/{id}")
    public GetOutlayCategory updateOutlayCategoryById(
            @PathVariable Long id,
            @RequestBody PutOutlayCategory data
    ) {
        return this.outlayCategoryService.updateOutlayCategoryById(id, data)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Outlay category not found"));
    }

    @Operation(summary = "Удаление категории расхода по ID")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOutlayCategoryById(@PathVariable Long id) {
        outlayCategoryService.deleteOutlayCategoryById(id);
    }
}
