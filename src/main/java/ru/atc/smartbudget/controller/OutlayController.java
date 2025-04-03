package ru.atc.smartbudget.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.atc.smartbudget.dto.income.GetIncome;
import ru.atc.smartbudget.dto.income.PutIncome;
import ru.atc.smartbudget.dto.outlay.GetOutlay;
import ru.atc.smartbudget.dto.outlay.PutOutlay;
import ru.atc.smartbudget.services.IncomeService;
import ru.atc.smartbudget.services.OutlayService;

@RestController
@Tag(name = "Расходы")
@RequestMapping("/api/v1/outlays")
public class OutlayController {
    private final OutlayService outlayService;

    public OutlayController(OutlayService outlayService) {
        this.outlayService = outlayService;
    }


    @Operation(summary = "Расход по ID")
    @GetMapping("/{id}")
    public GetOutlay getOutlayById(@PathVariable Long id) {
        return this.outlayService.getOutlayById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Outlay not found"));
    }

    @Operation(summary = "Редактирование дохода по ID")
    @PutMapping("/{id}")
    public GetOutlay updateOutlayById(@PathVariable Long id, PutOutlay data) {
        return this.outlayService.updateOutlayById(id, data)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Outlay not found"));
    }


}
