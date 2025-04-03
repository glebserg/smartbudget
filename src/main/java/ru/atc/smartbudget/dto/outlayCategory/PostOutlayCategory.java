package ru.atc.smartbudget.dto.outlayCategory;

import lombok.Data;
import lombok.NonNull;


@Data
public class PostOutlayCategory {

    @NonNull
    private String title;

    @NonNull
    private String description;
}