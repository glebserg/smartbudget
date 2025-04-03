package ru.atc.smartbudget.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "incomes")
@Data
public class DBIncome {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "income_id")
    private Long incomeId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "value")
    private Double value;

    @Column(name = "income_date")
    private LocalDate incomeDate;

    @ManyToOne
    @JoinColumn(name = "income_category_id")
    private DBIncomeCategory incomeCategory;
}