package ru.atc.smartbudget.dto.outlayCategory;

import lombok.Data;
import lombok.NonNull;


@Data
public class EditOutlayCategory {

    @NonNull
    private String title;

    @NonNull
    private String description;

    @NonNull
    private Integer priority;
}