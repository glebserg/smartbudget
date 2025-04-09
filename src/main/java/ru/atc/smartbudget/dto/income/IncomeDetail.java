package ru.atc.smartbudget.dto.income;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import ru.atc.smartbudget.dto.incomeCategory.IncomeCategoryDetail;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class IncomeDetail {
    private Long incomeId;
    private IncomeCategoryDetail incomeCategory;

    @NonNull
    private Double value;

    @NonNull
    private LocalDate incomeDate;
}