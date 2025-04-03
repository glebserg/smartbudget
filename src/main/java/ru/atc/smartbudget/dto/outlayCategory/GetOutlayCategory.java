package ru.atc.smartbudget.dto.outlayCategory;

import lombok.Data;
import lombok.NonNull;


@Data
public class GetOutlayCategory {
    @NonNull
    private Long outlayCategoryId;

    @NonNull
    private String title;

    @NonNull
    private String description;
}
