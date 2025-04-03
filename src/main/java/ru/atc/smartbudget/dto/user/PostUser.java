package ru.atc.smartbudget.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostUser {
    @NonNull
    private String firstName;

    @NonNull
    private String secondName;
}