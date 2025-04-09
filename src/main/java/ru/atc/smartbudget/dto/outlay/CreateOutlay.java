package ru.atc.smartbudget.dto.outlay;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateOutlay {

    @NonNull
    private Long outlayCategoryId;

    @NonNull
    private Double value;

    @NonNull
    private LocalDate outlayDate;

    private String comment;
}