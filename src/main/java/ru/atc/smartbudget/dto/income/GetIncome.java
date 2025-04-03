package ru.atc.smartbudget.dto.income;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import ru.atc.smartbudget.dto.incomeCategory.GetIncomeCategory;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetIncome {
    private Long incomeId;
    private GetIncomeCategory incomeCategory;

    @NonNull
    private Double value;

    @NonNull
    private LocalDate incomeDate;
}