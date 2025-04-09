package ru.atc.smartbudget.dto.user;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDetail {
    private Long userId;
    private String firstName;
    private String secondName;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
