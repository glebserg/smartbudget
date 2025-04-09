package ru.atc.smartbudget.dto.incomeCategory;

import lombok.Data;
import lombok.NonNull;


@Data
public class CreateIncomeCategory {

    @NonNull
    private String title;

    @NonNull
    private String description;
}