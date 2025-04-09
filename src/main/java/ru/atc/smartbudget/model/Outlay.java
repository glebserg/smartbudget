package ru.atc.smartbudget.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "outlays")
@Data
public class Outlay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "outlay_id")
    private Long outlayId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "value")
    private Double value;

    @Column(name = "comment")
    private String comment;

    @Column(name = "outlay_date")
    private LocalDate outlayDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "outlay_category_id")
    private OutlayCategory outlayCategory;
}