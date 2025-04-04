package ru.atc.smartbudget.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.atc.smartbudget.model.DBIncome;


import java.time.LocalDate;
import java.util.List;

public interface IncomeRepository extends JpaRepository<DBIncome, Long> {
    List<DBIncome> findAllByUserId(Long userId);
    List<DBIncome> findAllByUserIdAndIncomeDateBetweenOrderByIncomeDate(Long userId, LocalDate startDate, LocalDate endDate);
}
