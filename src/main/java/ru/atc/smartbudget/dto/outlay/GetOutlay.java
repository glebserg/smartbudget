package ru.atc.smartbudget.dto.outlay;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import ru.atc.smartbudget.dto.outlayCategory.GetOutlayCategory;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetOutlay {
    private Long outlayId;

    @NonNull
    private GetOutlayCategory outlayCategory;

    @NonNull
    private Double value;

    @NonNull
    private LocalDate outlayDate;

}