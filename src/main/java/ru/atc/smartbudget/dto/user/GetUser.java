package ru.atc.smartbudget.dto.user;

import lombok.Data;
import ru.atc.smartbudget.dto.incomeCategory.GetIncomeCategory;
import ru.atc.smartbudget.model.DBIncomeCategory;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class GetUser {
    private Long userId;
    private String firstName;
    private String secondName;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
