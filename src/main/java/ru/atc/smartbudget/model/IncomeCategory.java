package ru.atc.smartbudget.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "income_categories")
@Data
public class IncomeCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "income_category_id")
    private Long incomeCategoryId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}