package ru.atc.smartbudget.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.atc.smartbudget.model.DBIncomeCategory;

import java.util.List;

public interface IncomeCategoryRepository extends JpaRepository<DBIncomeCategory, Long> {
    List<DBIncomeCategory> findByUserUserId(Long userId);
}
