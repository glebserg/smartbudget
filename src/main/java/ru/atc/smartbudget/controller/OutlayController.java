package ru.atc.smartbudget.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.atc.smartbudget.dto.outlay.OutlayDetail;
import ru.atc.smartbudget.dto.outlay.EditOutlay;
import ru.atc.smartbudget.services.OutlayService;

@AllArgsConstructor
@RestController
@Tag(name = "Расходы")
@RequestMapping("/api/v1/outlays")
public class OutlayController {
    private final OutlayService outlayService;


    @Operation(summary = "Расход по ID")
    @GetMapping("/{id}")
    public OutlayDetail getOutlayById(@PathVariable Long id) {
        return this.outlayService.getOutlayById(id);
    }

    @Operation(summary = "Редактирование дохода по ID")
    @PutMapping("/{id}")
    public OutlayDetail updateOutlayById(@PathVariable Long id, EditOutlay data) {
        return this.outlayService.updateOutlayById(id, data);
    }


}
