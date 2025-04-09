package ru.atc.smartbudget.dto.outlay;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import ru.atc.smartbudget.dto.outlayCategory.OutlayCategoryDetail;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class OutlayDetail {
    private Long outlayId;

    @NonNull
    private OutlayCategoryDetail outlayCategory;

    @NonNull
    private Double value;

    @NonNull
    private LocalDate outlayDate;

}