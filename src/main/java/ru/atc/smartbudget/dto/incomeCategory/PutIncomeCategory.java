package ru.atc.smartbudget.dto.incomeCategory;

import lombok.Data;
import lombok.NonNull;


@Data
public class PutIncomeCategory {

    @NonNull
    private String title;

    @NonNull
    private String description;
}