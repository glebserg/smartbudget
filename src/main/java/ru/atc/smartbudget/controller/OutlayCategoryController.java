package ru.atc.smartbudget.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.atc.smartbudget.dto.outlayCategory.OutlayCategoryDetail;
import ru.atc.smartbudget.dto.outlayCategory.EditOutlayCategory;
import ru.atc.smartbudget.services.OutlayCategoryService;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/outlay-categories")
@Tag(name = "Категории расходов")
public class OutlayCategoryController {
    private final OutlayCategoryService outlayCategoryService;


    @Operation(summary = "Категория расхода по ID")
    @GetMapping("/{id}")
    public OutlayCategoryDetail getOutlayCategoryById(@PathVariable Long id) {
        return this.outlayCategoryService.getOutlayCategoryById(id);
    }

    @Operation(summary = "Редактирование категории расхода по ID")
    @PutMapping("/{id}")
    public OutlayCategoryDetail updateOutlayCategoryById(
            @PathVariable Long id,
            @RequestBody EditOutlayCategory data
    ) {
        return this.outlayCategoryService.updateOutlayCategoryById(id, data);
    }

    @Operation(summary = "Удаление категории расхода по ID")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOutlayCategoryById(@PathVariable Long id) {
        outlayCategoryService.deleteOutlayCategoryById(id);
    }
}
