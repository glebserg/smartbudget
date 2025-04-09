package ru.atc.smartbudget.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name="outlay_categories")
@Data
public class OutlayCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "outlay_category_id")
    private Long outlayCategoryId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "priority")
    private Integer priority;
}