package ru.atc.smartbudget.dto.outlay;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import ru.atc.smartbudget.dto.incomeCategory.GetIncomeCategory;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetOutlay {
    private Long outlayId;
    private GetIncomeCategory incomeCategory;

    @NonNull
    private Double value;

    @NonNull
    private LocalDate incomeDate;
}