package ru.atc.smartbudget.dto.outlayCategory;

import lombok.Data;
import lombok.NonNull;


@Data
public class CreateOutlayCategory {

    @NonNull
    private String title;

    @NonNull
    private String description;
}